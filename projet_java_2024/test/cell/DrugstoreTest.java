package cell;

import org.junit.Test;
import static org.junit.Assert.*;

/**
* This class contains a unit test for the Drugstore class.
*/
public class DrugstoreTest{
    /**
    * Tests whether a Drugstore instance is considered a room.
    */
    @Test
    public void testDrugstoreIsRoom() {
        Drugstore drugstore = new Drugstore(1, 2);

        // Check if the Drugstore is considered a room
        assertTrue(drugstore.isRoom());
    }
}
