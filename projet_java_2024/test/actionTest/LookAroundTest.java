package actionTest;
import static org.junit.Assert.*;
import org.junit.Test;

import action.LookAround;
import actors.Survivor;
import cell.Cell;
import cell.Door;
import game.City;

public class LookAroundTest {
    @Test
    public void testExecute() {
        // Création de la ville
        City city = new City( 3, 3);

        // Création des cellules
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(1,2);
        Cell cell3 = new Cell(3,2);
       

        // Ajout des cellules à la ville
        city.addCell(0, 0, cell1);
        city.addCell(0, 1, cell2);
        city.addCell(1, 0, cell3);
        

        // Création des portes
        Door door1 = new Door(1, 2);
        Door door2 = new Door(2, 3);
        Door door3 = new Door(3, 4);
        
        // Ajout des portes à la ville
        city.addDoor(door1);
        city.addDoor(door2);
        city.addDoor(door3);
        

        // Création du survivant
        Survivor survivor = new Survivor(4, 2);
        //city.placeActor(1, 1, survivor);
        LookAround lookAround = new LookAround(city, survivor);
        lookAround.execute();
        assertTrue(true);
    }
}
