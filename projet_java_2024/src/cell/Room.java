package cell;
import java.util.*;

/**
 * The Room class represents a specific type of cell in a grid, extending the Cell class.
 */
public class Room extends Cell {
	
	private List<Door> doors;
    /**
     * Constructs a new Room cell with the specified x and y coordinates.
     * @param x The x-coordinate of the room cell.
     * @param y The y-coordinate of the room cell.
     */
    public Room(int x, int y) {
        super(x, y);
        this.doors = new ArrayList<>();
    }


    /**
     * Checks if the cell is a room.
     *
     * @return True, indicating that the cell is a room.
     */
    public boolean isRoom() {
        return true;
    }
    
    /**
     * Returns a character representation of the room.
     * @return A string representing the cell.
     */
    public String toCharacter() {
		return " ";
	}
    
    public void addDoor(Door d) {
    	this.doors.add(d);
    }


}







