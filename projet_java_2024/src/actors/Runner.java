package actors;


public class Runner extends Zombie {
    
    protected int runnerActionAbility = 2;//The action ability of a Runner

    /**
     * Constructs a new Runner with the specified coordinates, action points,
     * and initial life points.
     * @param x The x-coordinate of the Runner's initial position.
     * @param y The y-coordinate of the Runner's initial position.
     * @param actionPoints The action points of the Runner.
     */
    public Runner(int x, int y) {
        super(x, y);
        this.pointsOfDamage = 1;
        this.lifePoints = 2;
        
        this.name = "Runner";
    }

    /**
     * Retrieves the action ability of the Runner, indicating how many times it can move per turn.
     * @return The action ability of the Runner.
     */
    public int getActionAbility() {
        return this.runnerActionAbility;
    }

    /**
     * Displays a message indicating the action taken by the Runner.
     * This method is specific to the Runner class.
     */
    public void displayTakenDamage() {
        System.out.println("Attack twice and Move twice: ");
    }

}
