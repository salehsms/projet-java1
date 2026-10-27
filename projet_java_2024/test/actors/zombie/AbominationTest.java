package actors.zombie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbominationTest {


    @Test
    public void testAbominationZombieInformation() {
        Zombie ab0 = new Abomination(2, 3, 4);
        Assertions.assertFalse(ab0.canBeAttacked(1));

    }

    /**
     * Tests the getActionPoints method of the Abomination class.
     * It verifies if the action points of the Abomination are correctly retrieved.
     */
    @Test
    public void testGetActionPoints() {
        Zombie ab1 = new Abomination(2, 3, 4);
        Assertions.assertEquals(4, ab1.getActionPoints());
    }


    /**
     * Tests the getLifePoints method of the Abomination class.
     * It ensures that the life points of the Abomination are correctly retrieved.
     */
    @Test
    public void testGetLifePoints() {
        Zombie ab2 = new Abomination(2, 3, 4);
        Assertions.assertEquals(6, ab2.getLifePoints());
    }

    /**
     * Tests the getPointsOfDamage method of the Abomination class.
     * It ensures that the points of damage inflicted by the Abomination are correctly retrieved.
     */
    @Test
    public void testGetPointsOfDamages() {
        Zombie ab3 = new Abomination(2, 3, 4);
        Assertions.assertEquals(3, ab3.getPointsOfDamage());
    }

    /**
     * Tests the canBeAttacked method of the Abomination class.
     * It checks if the Abomination can be attacked with a given harm value.
     */
    @Test
    public void testCanBeAttacked() {
        Zombie ab4 = new Abomination(2, 3, 4);
        Assertions.assertTrue(ab4.canBeAttacked(2));


        /// Zombie walkerZombie = new Broom(5);
        /// Zombie walkerZombie = new Walker(new Cell(3, 4), 2);
        /// Zombie walkerZombie = new Walker(new Cell(4, 4), 2);
    }
}