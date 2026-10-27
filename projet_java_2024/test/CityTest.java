import org.junit.*;
import static org.junit.Assert.*;

/**
* This class contains JUnit tests for the City class.
*/
public class CityTest {

    /**
    * Tests the placement of buildings within the city.
    */
    @Test
    public void testBuildingPlacement() {
        City city = new City(5, 5);
        city.buildCity();

        Building b1 = city.getBuilding(0);
        Building b2 = city.getBuilding(1);
        Building b3 = city.getBuilding(2);
        Building b4 = city.getBuilding(3);

        assertEquals(0, b1.getIndX());
        assertEquals(0, b1.getIndY());

        assertEquals(3, b2.getIndX());
        assertEquals(0, b2.getIndY());

        assertEquals(0, b3.getIndX());
        assertEquals(3, b3.getIndY());

        assertEquals(3, b4.getIndX());
        assertEquals(3, b4.getIndY());
         
  
        // Check if the rooms were initialized
        for (int i = 0; i < city.getBuilding(3).getNbX(); i++) {
            for (int j = 0; j < city.getBuilding(3).getNbY(); j++) {
                assertNotNull(city.getBuilding(3).getRoom(i, j));
            }
        }
    }
}

