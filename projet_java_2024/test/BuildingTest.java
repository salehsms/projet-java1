import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


/**
* This class contains JUnit tests for the Building class.
*/
public class BuildingTest {
    /**
    * Tests the creation of a Building instance, including its initial state.
    */
    @Test
    public void testBuildingCreation() {
        Building building = new Building(0, 0, 2, 2);

        assertEquals(0, building.getIndX());
        assertEquals(0, building.getIndY());
        assertEquals(2,building.getNbX());
        assertEquals(2,building.getNbY());

        
        assertNotNull(building.getRoom(0, 0));
        assertNotNull(building.getRoom(0, 1));
        assertNotNull(building.getRoom(1, 0));
        assertNotNull(building.getRoom(1, 1));
    }

    /**
     * Tests the getRoom method of the Building class.
     */
    @Test
    public void testGetRoom() {
        Building building = new Building(0, 0, 1, 2);

        
        assertEquals(building.getRoom(0, 0), building.getRoom(0, 0));
    }
}

