package cell;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains unit tests for the Continental class.
*/
public class ContinentalTest{
     /**
     * Tests whether a Continental instance is considered a room.
     */
    @Test
    public void testContinentalIsRoom() {
        Continental continental = new Continental(1, 2);

        // Check if the Continental is considered as a room
        assertTrue(continental.isRoom());
    }
}
