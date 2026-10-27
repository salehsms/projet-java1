package actors.survivor;

import actors.*;
import cell.Cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SurvivorTest {

    private Survivor survivor; 

    /**
     * Set up the test environment before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
       this.survivor = new Survivor(2, 3);
    }

    /**
     * Test the addEquipment method of the Survivor class.
     * It checks if equipment is successfully added to the survivor's backpack.
     */
    @Test
    public void testAddEquipment() {
        Equipment equipment = new Equipment(); 
        survivor.addEquipment(equipment); 
        assertEquals(1, survivor.getBackpackSize()); 
    }

    /**
     * Test the takeDamage method of the Survivor class.
     * It checks if the survivor's life points decrease correctly after taking damage.
     */
    @Test
    public void testTakeDamage() {
        int initialLifePoints = survivor.getLifePoints(); 
        survivor.takeDamage(5); 
        assertEquals(initialLifePoints - 5, survivor.getLifePoints()); 

    /**
     * Test the receiveHealing method of the Survivor class.
     * It checks if the survivor's life points increase correctly after receiving healing.
     */
    @Test
    public void testReceiveHealing() {
        int initialLifePoints = survivor.getLifePoints(); 
        survivor.receiveHealing(3); 
        assertEquals(initialLifePoints + 3, survivor.getLifePoints()); 
    }

    /**
     * Test the changeEquipmentInHand method of the Survivor class.
     * It checks if the survivor's equipment in hand is successfully changed.
     */
    @Test
    public void testChangeEquipment() {
        Equipment initialEquipment = new Equipment(); 
        Equipment newEquipment = new Equipment(); 
        survivor.takeEquipmentInHand(initialEquipment); 
        survivor.changeEquipmentInHand(newEquipment); 
        assertEquals(newEquipment, survivor.getEquipmentInHand()); 
    }
}
