package game;
import cell.*;
import java.util.*;
import actors.*;


/**
 * The `City` class represents a virtual city with cells that are eventually
 * rooms, buildings and streets. It allows for the creation, building, 
 * and display of the city.
 */

public class City{
	
	private int x; //row
	private int y; //column
	private Cell[][] cells;
	private List<Building> buildings;
	private List<Room> rooms;
	private Door[][] doors;
	
	private int[] streetCoord;
	private List<Actor> actors;
	
	private List<Survivor> survivors;
	private List<Zombie> zombies;
	
	private List<Manhole> manholes;
	
	/**
     * Constructs a new City with the specified dimensions.
     *
     * @param x The number of rows in the city.
     * @param y The number of columns in the city.
     */
	public City(int x,int y) {
		this.x = x;
		this.y = y;
		this.cells = new Cell[x][y]; 
		this.buildings = new ArrayList<>();
		this.rooms = new ArrayList<>();
		this.doors = new Door[this.x*this.y+1][this.x*this.y+1];
		
		this.streetCoord = new int[2];
		this.actors = new ArrayList<>();

		this.survivors = new ArrayList<>();
		this.zombies = new ArrayList<>();
		
		this.manholes = new ArrayList<>();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Cell[][] getCells(){
		return this.cells;
	}
	
	//Creating cells for the entire city
	public void baseCity() {
		for (int row = 0; row < this.x; row++) {
    		for (int col = 0; col < this.y; col++) {
    			this.cells[row][col] = new Cell(row,col);
            }
    	}
	}

	//select 2 random int to indicate the 2 main street position
	public void buildStreets() {
		Random random = new Random();
        int rx = this.streetCoord[0] = random.nextInt(this.x - 4) +2;
		int ry = this.streetCoord[1] = random.nextInt(this.y - 4) +2;
		
		for (int i = 0; i<this.x; i++){
			this.cells[i][ry] = new StreetCell(i, ry);
		}
		
		for (int j = 0; j<this.y; j++){
			this.cells[rx][j] = new StreetCell(rx, j);
		}
	}

	//Creating buildings in the 4 corners of the city around the streets
	public void buildBuildings(int rx, int ry){
		Building b1 = new Building(0, 0, rx, ry); // top left corner
    	Building b2 = new Building(rx+1, 0, this.x - rx-1, ry); // bottom left corner 
    	Building b3 = new Building(0, ry+1, rx, this.y -ry- 1); // top right corner
    	Building b4 = new Building(rx+1, ry+1, this.x-rx-1, this.y-ry-1); // bottom left corner
    	
    	this.buildings.add(b1);
    	this.buildings.add(b2);
    	this.buildings.add(b3);
    	this.buildings.add(b4);
	}

	//Add all the rooms in the city to the rooms list:
	public void addRoomstoRoomsList(){
		for (Building b : this.buildings) {
    		for (int row = 0; row < b.getNbX(); row++) {
    	        for (int col = 0; col < b.getNbY(); col++) {
    	            this.rooms.add(b.getRoom(row, col));
    	        }
    	    }
    	}
	}

	//Turn the cells in buildings into rooms
	public void turnCellsToRooms(){
		for (Building b : this.buildings) {
    		int x1 = b.getIndX();
			int y1 = b.getIndY();
    		for (int row = 0; row < b.getNbX(); row++) {
    	        for (int col = 0; col < b.getNbY(); col++) {
    	            this.cells[x1+row][y1+col] = b.getRoom(row, col);
    	        }
    	    }
    	}
	}

	//Turn no more than 1/16th of the rooms into Continental hotels and
	// no more than 1/16th of the rooms into Drugstore
	public void tunrRoomsToSpecialRooms(){
		Random random = new Random();
		int lrooms = Math.floorDiv(this.rooms.size(), 16);
		int rcontinental = random.nextInt(lrooms) + 1;
		int rdrugstore = random.nextInt(lrooms) +1;

		for (int i=1; i<=rcontinental; i++){
			int j = random.nextInt(this.rooms.size());
			int x = this.rooms.get(j).getx();
			int y = this.rooms.get(j).gety();
			this.cells[x][y] = new Continental(x,y);
		}

		for (int i=1; i<=rdrugstore; i++){
			int j = random.nextInt(this.rooms.size());
			int x = this.rooms.get(j).getx();
			int y = this.rooms.get(j).gety();
			this.cells[x][y] = new Drugstore(x,y);
		}
	}

	//Turn the cells at the ends of streets into manholes
	//Special case with 5*5 city - in this case there's only one manhole
	public void turnToManholes(int rx, int ry){
		if (this.x==5 && this.y==5){
			this.cells[2][2] = new Manhole(2,2);
			//new
			this.manholes.add((Manhole) this.cells[2][2]);
		} else if (this.x>=5 && this.y>5 || this.x>5 && this.y>=5) {
			this.cells[0][ry] = new Manhole(0,ry);
			this.cells[rx][0] = new Manhole(rx,0);
			this.cells[this.x-1][ry] = new Manhole(this.x-1,rx);
			this.cells[rx][this.y-1] = new Manhole(rx,this.y-1);
			//new
			this.manholes.add((Manhole) this.cells[0][ry]);
			this.manholes.add((Manhole) this.cells[rx][0]);
			this.manholes.add((Manhole) this.cells[this.x-1][ry]);
			this.manholes.add((Manhole) this.cells[rx][this.y-1]);
		}
	}

	//For each room if the neighbors to its right and down are cells add new door to the doors
	// list with its coordinates being the number of rooms this door is connecting.
	// the rooms here are numbered with integers 1 to x*y from left to right, from top to bottom
	public void addDoorsToDoorsList(){
		for (Room r : this.rooms) {
			int roomx = r.getx();
			int roomy = r.gety();
			int roomId = this.y*roomx+roomy+1;
			if ((roomy+1)<this.y){ //door to the right
				this.doors[roomId][roomId+1] = new Door(roomId, roomId+1);
				this.doors[roomId+1][roomId] = new Door(roomId+1, roomId);
			} 
			if ((roomx+1)<this.x) { //door to the north
				this.doors[roomId+this.y][roomId] = new Door(roomId+this.y, roomId);
				this.doors[roomId][roomId+this.y] = new Door(roomId, roomId+this.y);
			}
			if ((roomy-1)>=0){ //door to the left
				this.doors[roomId][roomId-1] = new Door(roomId, roomId-1);
				this.doors[roomId-1][roomId] = new Door(roomId-1, roomId);
			} 
			if ((roomx-1)>=0) { //door to the south
				this.doors[roomId-this.y][roomId] = new Door(roomId-this.y, roomId);
				this.doors[roomId][roomId-this.y] = new Door(roomId, roomId-this.y);
			}
		}
	}
	
	/**
     * Builds the city by creating cells as a basis of the city, then creates and adds buildings,
	 * turn the cells in the buildings into rooms. It also places the special cells like the manhole and 
	 * creates doors for rooms and places them in an array with indexes that references the cells it connects
     */
	public void buildCity(){
		this.baseCity();
		this.buildStreets();
		this.buildBuildings(this.streetCoord[0], this.streetCoord[1]);
		this.addRoomstoRoomsList();
		this.turnCellsToRooms();
		this.tunrRoomsToSpecialRooms();
		this.turnToManholes(this.streetCoord[0], this.streetCoord[1]);
		this.addDoorsToDoorsList();
	}

	/**
     * Displays the city by printing the characters representing each cell.
     */
	public void displayCity() {
		int numRows = this.x;
		int numCols = this.y;
        // Table headers
        System.out.print("+");
        for (int col = 1; col <= numCols; col++) {
            System.out.print("---+");
        }
        System.out.println();

        // Table content with numbers in each cell
        for (int row = 0; row < numRows; row++) {
            System.out.print("|");
            for (int col = 0; col < numCols; col++) {
				Cell c1 = this.cells[row][col];
				//Check if the cell to the right exists and is a certain cell
				if (col+1 < numCols){
					System.out.print(c1.toCharacter());
					
					if (c1.hasZombie()){
						System.out.print("z");
					} else {
						System.out.print(" ");
					}
					
					if (c1.hasSurvivor()) {
						System.out.print("s");
					} else {
						System.out.print(" ");
					}
					
					Cell c2 = this.cells[row][col+1];
					
					if (c1.isStreetCell() && c2.isStreetCell()){
						System.out.print(" ");
					} else {
						System.out.print("|");
					}
				}
				else {
					System.out.print(c1.toCharacter());
					if (c1.hasZombie()){
						System.out.print("z");
					} else {
						System.out.print(" ");
					}
					if (c1.hasSurvivor()) {
						System.out.print("s");
					} else {
						System.out.print(" ");
					} 
					System.out.print("|");
				}
            }
            System.out.println();

            // Row separator
            System.out.print("+");
            for (int col = 0; col < numCols; col++) {
				Cell c1 = this.cells[row][col];
				if (row+1 < numRows) {
					Cell c2 = this.cells[row+1][col];
					if (c1.isStreetCell() && c2.isStreetCell()){
						System.out.print("   +");
					} else {
						System.out.print("---+");
					}
				} 
				else {
					System.out.print("---+");
				}
            }
            System.out.println();
        }
    }

	/**
     * Gets a specific building within the city.
     *
     * @param nb The index of the building.
     * @return The building at the specified index.
     */
	public Building getBuilding(int nb) {
		return this.buildings.get(nb);
	}

	public void detailsCity() {
		System.out.println("This city has " + this.buildings.size() + " buildings.");
		System.out.println("Number of rows: " + this.x);
		System.out.println("Number of columns: " + this.y);
	}
	
	public int[] getStreetCoord() {
		return this.streetCoord;
	}
	
	public void addSurvivor(Survivor s) {
		int sx = s.getX();
		int sy = s.getY();
		this.cells[sx][sy].addSurvivorToCell(s);
		this.actors.add(s);
		this.survivors.add(s);
		s.setZone(this.cells[sx][sy]);
	}

	public void displaySurvivors() {
		System.out.println("Survivors: ");
		for (int i = 0; i < this.survivors.size(); i++) {
			Survivor s = this.survivors.get(i);
			System.out.println("Survivor "+ (i+1) + ": "+ s.toString());
		}
	}
	
	public void displayZombies() {
		System.out.println("Zombies: ");
		for (int i = 0; i < this.zombies.size(); i++) {
			Zombie z = this.zombies.get(i);
			System.out.println("*Zombie "+ (i+1) + ": "+ z.toString());
		}
	}

	public List<Survivor> getSurvivors(){
		return this.survivors;
	}
	
	public List<Zombie> getZombies(){
		return this.zombies;
	}
	
	public Survivor getSurvivor(int i){
		return this.survivors.get(i);
	}
	
	public Cell getCell(int x, int y) {
		return this.cells[x][y];
	}
	
	public List<Building> getBuildings() {
		return this.buildings;
	}
	
	public List<Manhole> getManholes() {
		return this.manholes;
	}
	
	public void addZombie(Zombie z) {
		int x = z.getX();
		int y = z.getY();
		this.cells[x][y].addZombieToCell(z);
		this.actors.add(z);
		this.zombies.add(z);
		z.setZone(this.cells[x][y]);
	}

	public void removeSurvivor(Survivor s) {
		int sx = s.getX();
		int sy = s.getY();
		this.cells[sx][sy].removeSurvivor(s);
		this.actors.remove(s);
		this.survivors.remove(s);
	}
	
	public boolean cellExists(int cellx, int celly) {
		return (cellx >= 0 && cellx < this.x) && (celly >= 0 && celly < this.y);
	}
	
	public Door getDoor(int x, int y) {
		return this.doors[x][y];
	}
	
	public int getCellId(int cellx, int celly) {
		return this.y*cellx+celly+1;
	}
	
	public HashMap<String, Door> getDoorsForCell(int cx, int cy){
		
		HashMap<String, Door> result = new HashMap<>();
		int cellId = this.getCellId(cx, cy);
		
		if (this.cellExists(cx,cy+1)) {
    		int rid = this.getCellId(cx, cy+1);
    		Door d1 = this.getDoor(cellId, rid);
    		if (d1 != null) {
    			result.put("West", d1);
    		}
    	} 
    	
    	if (this.cellExists(cx, cy-1)) {
    		int rid = this.getCellId(cx, cy-1);
    		Door d2 = this.getDoor(cellId, rid);
    		if (d2 != null) {
    			result.put("East", d2);
    		}
    	}
    	
    	if (this.cellExists(cx+1, cy)) {
    		int rid = this.getCellId(cx+1, cy);
    		Door d3 = this.getDoor(cellId, rid);
    		if (d3 != null) {
    			result.put("South", d3);
    		}
    	}
    	
    	if (this.cellExists(cx-1, cy)) {
    		int rid = this.getCellId(cx-1, cy);
    		Door d4 = this.getDoor(cellId, rid);
    		if (d4 != null) {
    			result.put("North", d4);
    		}
    	}
    	return result;
	}
	
	public List<Cell> getNeighboringCells(int cx, int cy){
		
		List<Cell> result = new ArrayList<>();
		
		if (this.cellExists(cx,cy+1)) {
    		result.add(this.cells[cx][cy+1]);
    	} 
    	
    	if (this.cellExists(cx, cy-1)) {
    		result.add(this.cells[cx][cy-1]);
    	}
    	
    	if (this.cellExists(cx+1, cy)) {
    		result.add(this.cells[cx+1][cy]);
    	}
    	
    	if (this.cellExists(cx-1, cy)) {
    		result.add(this.cells[cx-1][cy]);
    	}
    	
    	return result;
	}
	
	/* move actor to ax, ay coordinates */
	public void moveActor(Actor a, int ax, int ay) {
		a.getZone().removeActor(a);
		a.setX(ax);
		a.setY(ay);
		a.setZone(this.cells[ax][ay]);
		this.cells[ax][ay].addActorToCell(a);
	}

}
