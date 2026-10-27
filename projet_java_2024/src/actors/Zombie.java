
package actors;


/**
 * import actors.survivor.Survivor;
 * import cell.Cell;
 * import java.util.Random;
 *
 */

public abstract class Zombie extends Actor {
	
    protected int pointsOfDamage;
    protected int damageResistance = 0;
    

    /**
     * Constructs a new Zombie with the specified coordinates, action points,
     * and life points.
     * @param x The x-coordinate of the Zombie's initial position.
     * @param y The y-coordinate of the Zombie's initial position.
     * @param actionPoints The action points of the Zombie.
     * @param lifePoint The life points of the Zombie.
     */
    public Zombie(int x, int y) {
        super(x, y);
    }
    
    public boolean isZombie() {
    	return true;
    }
    
    public boolean isSurvivor() {
    	return false;
    }

    /**
     * Checks whether the zombie can be attacked based on the harm value.
     * @param harmValue The amount of harm inflicted by an attack.
     * @return True if the harm value is greater than the maximum damage
     * the zombie can take, false otherwise.
     */
    public boolean canBeAttacked(int harmValue) {
        return harmValue > this.damageResistance;
    }

    /**
     * Get the points of damage the zombie can inflict.
     * Subclasses must implement this method.
     * @return The points of damage the zombie can inflict.
     */
    public int getPointsOfDamage() {
    	return this.pointsOfDamage;
    }
    
    public int getDamageResistance() {
    	return this.damageResistance;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String toString() {
        return this.getName()  + "(" + this.x + "," + this.y + ")" + ", Life points : " + this.getLifePoints() 
        + ", Points of damage: " + getPointsOfDamage() + ", Damage Resistance: " + this.getDamageResistance();
    }
}