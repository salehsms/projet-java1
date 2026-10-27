package cell;
/**
 * The Continental class represents a specific type of room in a grid, extending the Room class.
 * (Continental estends Building ou room?)
 * It implements the Grid interface, providing a character representation for the continental room.
 */
public class Continental extends Room {

    /**
     * Constructs a new Continental room with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the continental room.
     * @param y The y-coordinate of the continental room.
     */
    public Continental(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a character representation specific to the continental room.
     * In this case, it returns the character "C".
     *
     * @return a string representing the continental room.
     */
    public String toCharacter() {
        return "C";
    }
}
