package actors;

public class Abomination extends Zombie {

    /**
     * Constructs a new Abomination with the specified coordinates, action points,
     * and initial life points.
     * @param x The x-coordinate of the Abomination's initial position.
     * @param y The y-coordinate of the Abomination's initial position.
     * @param actionPoints The action points of the Abomination.
     */
    public Abomination(int x,int y) {
        super(x, y);
        this.pointsOfDamage = 3;
        this.lifePoints = 6;
        this.damageResistance = 1;
        
        this.name = "Abomination";
    }

}
