package actors;


public class Walker extends Zombie {

    /**
     * Constructs a new Walker with the specified coordinates, action points,
     * and initial life points.
     * @param x The x-coordinate of the Walker's initial position.
     * @param y The y-coordinate of the Walker's initial position.
     * @param actionPoints The action points of the Walker.
     */

    public Walker(int x, int y) {
        super(x, y);
        this.pointsOfDamage = 1;
        this.lifePoints = 1;
        
        this.name = "Walker";
    }

}
