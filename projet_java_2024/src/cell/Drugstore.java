package cell;
/**
 * The Drugstore class represents a specific type of room in a grid, extending the Room class.
 * It implements the Grid interface, providing a character representation for the continental room.
 */
public class Drugstore extends Room{
  /**
   * Constructs a new Drugstore room with the specified x and y coordinates.
   *
   * @param x The x-coordinate of the continental room.
   * @param y The y-coordinate of the continental room.
   */
	public Drugstore(int x, int y) {
		super(x,y);
	}

  
  /**
   * Returns a character representation specific to the Drugstore room.
   * In this case, it returns the character "D".
   *
   * @return a string representing the continental room.
   */
	public String toCharacter() {
		return "D";
	}
}
