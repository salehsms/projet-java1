package cell;
/**
* The Door class represents a door with coordinates (x, y) that can be open or closed.
*/
public class Door {
   private int x;
   private int y;
   private boolean open;
   //private String doorType;

   /**
    * Constructs a new Door with the specified coordinates, initially closed.
    *
    * @param x The x-coordinate of the door.
    * @param y The y-coordinate of the door.
    */
   public Door(int x, int y) {
       this.x = x;
       this.y = y;
       this.open = false;
   }

   /**
    * Gets the x-coordinate of the door.
    *
    * @return The x-coordinate of the door.
    */
   public int getX() {
       return this.x;
   }


   /**
    * Gets the y-coordinate of the door.
    *
    * @return The y-coordinate of the door.
    */
   public int getY() {
       return this.y;
   }

   /**
    * Checks if the door is open.
    *
    * @return true if the door is open, false if it is closed.
    */
   public boolean isOpen() {
       return this.open;
   }

    /**
    * Opens the door.
    */
    public void open() {
        this.open = true;
    }
    
    public String toString() {
    	if (this.open) {
    		return "open";
    	}
    	else {
    		return "closed";
    	}
    }
}
