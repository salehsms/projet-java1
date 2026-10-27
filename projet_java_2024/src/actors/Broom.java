package actors;


public class Broom extends Zombie {

    /**
     * Constructs a new Broom with the specified coordinates, action points,
     * and initial life points.
     * @param x The x-coordinate of the Broom's initial position.
     * @param y The y-coordinate of the Broom's initial position.
     * @param actionPoints The action points of the Broom.
     */
    public Broom(int x,int y) {
        super(x, y);
        this.pointsOfDamage = 2;
        this.lifePoints = 4;
        this.damageResistance = 1;
        
        this.name = "Broom";
    }


}
