package actors.zombie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RunnerZombieTest {


    /**
     * This test case verifies the functionality of the canBeAttacked() method in the Zombie class.
     */
    @Test
    public void testCanBeAttacked() {
        Runner runnerZombie = new Runner(2, 3, 4);
        assertTrue(runnerZombie.canBeAttacked(1));


    }

    /**
     * This test case verifies the functionality of the getActionAbility() method in the Runner class.
     */
    @Test
    public void testGetActionAbility() {
        Runner runnerZombie = new Runner(2, 3, 4);
        assertEquals(2, runnerZombie.getActionAbility());
    }

    /**
     * This test case verifies the functionality of the getActionPoints() method in the Runner class.
     */
    @Test
    public void testGetActionPoints () {
        Runner runnerZombie = new Runner(2, 3, 4);
        assertEquals(4, runnerZombie.getActionPoints());


    }
    /**
     * This test case verifies the functionality of the getLifePoints() method in the Runner class.
     */
    @Test
    public void testGetLifePoints () {
        Runner runnerZombie = new Runner(2, 3, 4);
        assertEquals(2, runnerZombie.getLifePoints());
    }


    /**
     * This test case verifies the functionality of the getPointsOfDamage() method in the Runner class.
     */
    @Test
    public void testGetPointsOfDamage () {
        Runner runnerZombie = new Runner(2, 3, 4);
        assertEquals(1, runnerZombie.getPointsOfDamage());


    }
    }
