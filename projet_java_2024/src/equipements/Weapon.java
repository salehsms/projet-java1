package equipements;

/*
* Weapon class is abstract class represents a generic weapon in the game
* It extends the Equipment class,inheriting basic equipment with properties.
*/
public abstract class Weapon extends Equipment {
	protected int dieRoll;
    protected int threshold;
    protected int damage;
    protected int[] range;

    /**
     * Constructs a new Weapon
     * instance of Weapon
     */
    public Weapon() {
    	super();
    }
    /**
     * this method return the name of this weapon.
     * @return the name of the weapon
     */
    public String getName() {
		return "weapon";
	}
    
    public boolean canAttackZombie() {
    	return true;
    }
    
    public String toString() {
    	String result = "Name: " + this.getName() + ", damage: " + this.damage + ", range: " + this.range;
    	return result;
    }
    
    public int getDieRoll() {
    	return this.dieRoll;
    }
    
    public int getThreshold() {
    	return this.threshold;
    }
    
    public int getDamage() {
    	return this.damage;
    }
}
