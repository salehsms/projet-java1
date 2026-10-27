package cell;

import actors.Abomination;
import actors.Broom;
import actors.Runner;
import actors.Walker;
import actors.Zombie;
import actors.ZombieType;

/**
 *The Manhole class provides a character representation for the manhole cell.
 *
 */
public class Manhole extends Cell{
	/**
     * Constructs a new Manhole cell with the specified x and y coordinates.
     * @param x The x-coordinate of the manhole cell.
     * @param y The y-coordinate of the manhole cell.
     */

	public Manhole(int x, int y) {
		super(x,y);
	}

     
	/**
     * Returns a character representation specific to the manhole cell.
     * In this case, it returns the character "M".
     * @return A string representing the manhole cell.
     */

	public String toCharacter() {
		return "M";
	}
	
	public boolean isStreetCell(){
        return true;
    }
	
	public Zombie produceZombie(ZombieType type) {
		Zombie z;
		switch(type) {
		case WALKER:
			z = new Walker(this.x, this.y);
			this.zombies.add(z);
			return z;
		case BROOM:
			z = new Broom(this.x, this.y);
			this.zombies.add(z);
			return z;
		case RUNNER:
			z = new Runner(this.x, this.y);
			this.zombies.add(z);
			return z;
		case ABOMINATION:
			z = new Abomination(this.x, this.y);
			this.zombies.add(z);
			return z;
		default:
			return null;
		}
	}
}
