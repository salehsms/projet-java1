import static org.junit.Assert.*;

import action.LookAround;
import actors.Actor;
import actors.Lucky;
import actors.Survivor;
import actors.Zombie;
import game.City;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;


public class LookAroundTest {
    @Test
    public void testExecute() {
        // Create a City
        City city = new City(5,5);
        Survivor actor = new Lucky(1, 2);

        //List<Survivor> survivors = new ArrayList<Survivor>();
        Survivor survivor = new Survivor(3,4);
       // survivors.add(survivor);

        // Create an instance of LookAround
        LookAround lookAroundAction = new LookAround(city, actor);

        // Execute the action
        lookAroundAction.execute();

    }
}











