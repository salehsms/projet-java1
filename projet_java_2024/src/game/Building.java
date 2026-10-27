package game;
import cell.*;

/**
 * The Building class represents a building in a city.
 * It takes as parameter the indexes of a cell in a city as its top left room.
 * It also takes as parameter the row and column number of the building.
 */

public class Building{ 
    private int indx; //top left room x index
	private int indy; //top left room y index
	private int nbx;
	private int nby;
	private Room[][] rooms;
	
	
	/**
	 * Takes the x,y index of the top left cell and builds nbx * nby rooms around that cell 
	 * in a nbx by nby building shape
	 * @param indx top left cell column index
	 * @param indy top left cell row index
	 * @param nbx number of rooms in the x axis
	 * @param nby number of rooms in the y axis
	 */

	public Building(int indx, int indy, int nbx, int nby) {
		this.indx = indx;
		this.indy = indy;
		this.nbx = nbx;
		this.nby = nby;
		this.rooms = new Room[this.nbx][this.nby];

		for (int i = 0; i < this.nbx; i++) {
			for (int j = 0; j < this.nby; j++) {
				rooms[i][j] = new Room(this.indx + i, this.indy + j);
			}
		}
	}
	

    
	/**
	 * Retrieves a Room object based on the specified coordinates from the two-dimensional array of rooms.
	 * @param nbx The x-coordinate of the desired room.
	 * @param nby The y-coordinate of the desired room.
	 * @return The Room object located at the specified coordinates.
	 * @throws ArrayIndexOutOfBoundsException If the provided coordinates are outside the valid range of the rooms array.
	 */
	public Room getRoom(int nbx, int nby) {
		return this.rooms[nbx][nby];
	}




	/**
	 * Retrieves the x-coordinate index value associated with the current instance.
	 *
	 * @return The x-coordinate index value.
	 */
	public int getIndX() {
		return this.indx;
	}
	



	
	/**
	 * Retrieves the y-coordinate index associated with the current instance.
	 *
	 * @return The y-coordinate index.
	 */
	public int getIndY() {
		return this.indy;
	}



	/**
	 * Retrieves the x-coordinate value associated with the current instance.
	 *
	 * @return The x-coordinate value.
	 */
	public int getNbX() {
		return this.nbx;
	}
	

	/**
	 * Retrieves the y-coordinate value associated with the current instance.
	 *
	 * @return The y-coordinate value.
	 */
	public int getNbY() {
		return this.nby;
	}

	/**
	 * Returns a string representation of the City object.
	 * 
	 * @return A string describing the number of rows and columns in the city.
	 */
	public String toString() {
		return "nb of rows - " + this.nbx  + ", nb of columns - " + this.nby + ", nb of cells - " + this.nbx*this.nby;
	}
 }

