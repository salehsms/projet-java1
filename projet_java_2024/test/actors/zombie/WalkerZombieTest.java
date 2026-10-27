package actors.zombie;
import org.junit.jupiter.api.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WalkerZombieTest {
    /**
     * Test to verify the information of a WalkerZombie.
     * It checks if the actionPoints of the WalkerZombie are set correctly.
     */
    @Test
    public void testWalkerZombieInformation() {
        Zombie walkerZombie = new Walker(2, 3, 4);
        assertEquals(4, walkerZombie.getActionPoints());
    }


    /**
     * This test case verifies the functionality of the getLifePoints() method in the Zombie class.
     */
    @Test
    public void TestGetLifePoints() {
        Zombie walkerZombie = new Walker(2, 3, 4);
        assertEquals(1, walkerZombie.getLifePoints());
    }


    /**
     * This test case verifies the functionality of the getPointsOfDamage() method in the Zombie class.
     */
    @Test
    public void testGetPointsOfDamage() {
        Zombie walkerZombie = new Walker(2, 3, 4);
        assertEquals(1, walkerZombie.getPointsOfDamage());
    }

    /**
     * This test case verifies the functionality of the canBeAttacked() method in the Zombie class.
     */
    @Test
    public void testCanBeAttacked() {
        Zombie walkerZombie = new Walker(2, 3, 4);
        assertTrue(walkerZombie.canBeAttacked(1));
    }

}