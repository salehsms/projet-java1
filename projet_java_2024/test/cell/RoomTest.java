package cell;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * This class contains JUnit tests for the Room class.
 */
public class RoomTest {

    /**
    * Tests the creation of a Room instance, including its initial state.
    */
    @Test
    void testRoomCreation() {
        Room room = new Room(1, 2);

        assertTrue(room.isRoom());
    }
    
    /**
    * Tests if a Room is considered a room.
    */
    @Test
    void testIsRoom() {
        Room room = new Room(5, 6);

        assertTrue(room.isRoom());
    }
}
