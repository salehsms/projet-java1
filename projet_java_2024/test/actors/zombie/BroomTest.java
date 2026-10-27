package actors.zombie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BroomTest {
    /**
     * Tests the canBeAttacked method of the Broom class.
     * It checks if the Broom can be attacked with a given harm value.
     */
    @Test
    public void testBroomZombieInformation() {
        Zombie br0 = new Broom(2, 3,4);
        Assertions.assertFalse(br0.canBeAttacked(1));// Broom cannot be attacked with damage value 1

    }

    /**
     * Tests the getActionPoints method of the Broom class.
     * It verifies if the action points of the Broom are correctly retrieved.
     */
    @Test
    public void testGetActionPoints() {
        Zombie br1 = new Broom(2, 3, 4);
        Assertions.assertEquals(4, br1.getActionPoints());
    }
    /**
     * Tests the getLifePoints method of the Broom class.
     * It ensures that the life points of the Broom are correctly retrieved.
     */
    @Test
    public void testGetLifePoints() {
        Zombie br2 = new Broom(2, 3, 4);
        Assertions.assertEquals(2,  br2.getLifePoints());
    }

    /**
     * Tests the getPointsOfDamage method of the Broom class.
     * It ensures that the points of damage inflicted by the Broom are correctly retrieved.
     */
    @Test
    public void testGetPointsOfDamage() {
        Zombie br3 = new Broom(2, 3, 4);
        Assertions.assertEquals(2, br3.getPointsOfDamage());
    }

    /**
     * Tests the canBeAttacked method of the Broom class with a harm value.
     * It checks if the Broom can be attacked with a given harm value.
     */
    @Test
    public void testCanBeAttacked() {
        Zombie br4 = new Broom(2, 3, 4);
        Assertions.assertTrue(br4.canBeAttacked(2)); // Broom can be attacked with damage value 2
    }

}