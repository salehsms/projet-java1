package actionTest;

import static org.junit.Assert.*;

import action.OpenDoor;
import actors.Survivor;
import cell.Door;
import game.City;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OpenDoorTest {
    @Test
    public void testExecute() {
        // Create a City
        City city = new City(5,5);
        Survivor survivor = new Survivor(4,5);
        // Create a Door
        Door door = new Door(1,0);

        // Create an instance of OpenDoor
        OpenDoor openDoorAction = new OpenDoor(city, survivor, door);

        // Execute the action
        openDoorAction.execute();

    }
}














