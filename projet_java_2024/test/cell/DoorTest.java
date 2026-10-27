package cell;

import org.junit.Test;
import static org.junit.Assert.*;

/**
* This class contains unit tests for the Door class.
*/
public class DoorTest{
	/**
	* Tests the initial state of a door, including its position and closed state.
	*/
	@Test
	public void testDoorState(){
		Door door=new Door(2,3);

		assertEquals(2,door.getX());
		assertEquals(3,door.getY());
		assertFalse(door.isOpen());

	}
	/**
	* Tests the opening of a door and checks if it is in the open state.
	*/
	@Test
	public void testDoorOpen(){
		Door door=new Door(3,4);
		door.open();// Open the door before checking
	    assertTrue(door.isOpen());
	}
}
