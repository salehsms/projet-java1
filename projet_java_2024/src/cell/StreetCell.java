package cell;

public class StreetCell extends Cell{

    /**
     * Constructs a new Room cell with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the room cell.
     * @param y The y-coordinate of the room cell.
     */
    public StreetCell(int x, int y) {
        super(x, y);
    }


    /**
     * Checks if the cell is a room.
     *
     * @return True, indicating that the cell is a room.
     */
    public boolean isStreetCell() {
        return true;
    }
    
    /**
     * Returns a character representation of the room.
     * @return A string representing the cell.
     */
    public String toCharacter() {
		return " ";
	}
	    
}
