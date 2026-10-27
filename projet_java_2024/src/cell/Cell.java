package cell;

import actors.*;
import equipements.*;
import java.util.*;

/**
 * The Cell class represents a single cell in a city.
 * It implements the Grid interface, providing methods to access
 * the cell's coordinates and obtain a character representation.
 */
public class Cell {
    protected int x;
    protected int y;
    
    protected List<Actor> actors;
    protected List<Equipment> tools;

    protected List<Survivor> survivors;
    protected List<Zombie> zombies;
    
    protected int noise;

    /**
     * Constructs a new Cell with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        //the noise of cell is initial a zero
        this.noise = 0 ;
        this.actors = new ArrayList<>();
        this.tools = new ArrayList<>();
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
    }

    /**
     * Gets the x-coordinate of the cell.
     *
     * @return The x-coordinate of the cell.
     */
    public int getx() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of the cell.
     *
     * @return The y-coordinate of the cell.
     */
    public int gety() {
        return this.y;
    }

    /**
     * Returns a character representation of the cell.
     * 
     * @return A string representing the cell.
     */
    public String toCharacter() {
        return " ";
    }

    /**
     * Checks if the cell is a room.
     *
     * @return false, indicating that the cell is a room.
     */
    public boolean isRoom() {
        return false;
    }

    public boolean isStreetCell() {
        return false;
    }

    public void addActorToCell(Actor a) {
        this.actors.add(a);
        if (a.isSurvivor()) {
        	this.survivors.add((Survivor) a);
        }
        if (a.isZombie()) {
        	this.zombies.add((Zombie) a);
        }
    }

    public void addSurvivorToCell(Survivor s) {
        this.actors.add(s);
        this.survivors.add(s);
    }

    public void addEquipment(Equipment e) {
        this.tools.add(e);
        e.setZone(this);
    }
    
    public void removeEquipment(int index) {
    	this.tools.get(index).removeZone();
        this.tools.remove(index);
    }
    
    public void deleteEquipment(Equipment tool) {
        this.tools.remove(tool);
        tool.removeZone();
    }

    public boolean hasSurvivor() {
        return !this.survivors.isEmpty();
    }

    public boolean hasZombie() {
        return !this.zombies.isEmpty();
    }

    public void addZombieToCell(Zombie z) {
        this.actors.add(z);
        this.zombies.add(z);
    }

    public void removeSurvivor(Survivor s) {
        this.survivors.remove(s);
        this.actors.remove(s);
    }
    
    public void removeActor(Actor a) {
        this.actors.remove(a);
        if (a.isSurvivor()) {
        	this.survivors.remove(a);
        }
        if (a.isZombie()) {
        	this.zombies.remove(a);
        }
    }
    
    public String getDescription() {
    	String result = "(x,y): " + this.x+ "," + this.y +"\n";
    	result += "Survivors: \n";
        for (int i = 0; i < this.survivors.size(); i++) {
            Survivor s = this.survivors.get(i);
            result += "* Survivor " + (i + 1) + ": " + s.toString() + "\n";
        }
        result += "Zombies: \n";
        for (int i = 0; i < this.zombies.size(); i++) {
            Zombie z = this.zombies.get(i);
            result += "* Zombie " + (i + 1) + ": " + z.toString() + "\n";
        }
        result+= "Noise level: " + this.noise + "\n"; //new
        return result;
    }
    
    public int getToolsNb() {
    	return this.tools.size();
    }
    
    /* get list of tools as string */
    public String getToolsDescription() {
        StringBuilder sb = new StringBuilder();

        if (!this.tools.isEmpty()) {
            for (Equipment e : this.tools) {
                sb.append(e.getName()).append(", ");
            }

            // Remove the trailing comma and space
            sb.setLength(sb.length() - 2);
        } else {
            // If tools is empty, return a space
            sb.append(" ");
        }

        return sb.toString();
    }
    
    public String getSurvivorDescription() {
    	String result = "Survivors: \n";
        for (int i = 0; i < this.survivors.size(); i++) {
            Survivor s = this.survivors.get(i);
            result += "* Survivor " + (i + 1) + ": " + s.toString() + "\n";
        }
        return result;
    }
    
    public String getZombieDescription() {
    	String result = "Zombies: \n";
		for (int i = 0; i < this.zombies.size(); i++) {
			Zombie z = this.zombies.get(i);
			result += "* Zombie " + (i + 1) + ": " + z.toString() + "\n";
		}
		return result;
	}
    
    public Equipment getTool(int i) {
    	return this.tools.get(i);
    }
    
    public int getSurvivorSize() {
    	return this.survivors.size();
    }
    
    public int getZombieSize() {
    	return this.zombies.size();
    }
    
    public Survivor getSurvivor(int i) {
    	return this.survivors.get(i);
    }
    
    public List<Survivor> getSurvivors(){
    	return this.survivors;
    }
    
    public List<Zombie> getZombies(){
    	return this.zombies;
    }
    
    public int getNoise() {
    	return this.noise;
    }
    
    public void setNoise(int i) {
    	this.noise = i;
    }
    
    public void increaseNoise(int i) {
    	this.noise += i;
    }
    
}
