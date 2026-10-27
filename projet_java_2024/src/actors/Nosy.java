package actors;


public class Nosy extends Survivor {
    //add level noisy
    protected int knowNoisy;
    /**
     * Constructor for Nosy class.
     * @param x The x-coordinate 
     * @param y The y-coordinate 
     */
    public Nosy(int x,int y) {
        super(x,y);
        this.name="nosy";
        this.knowNoisy = 0;
    }
    /**
     * Method to check if the Nosy instance is aware of noise.
     * @return True if the knowNoisy level is greater than 0, false otherwise.
     */
    public boolean doNoisy() {
        return knowNoisy > 0;
    }

}
