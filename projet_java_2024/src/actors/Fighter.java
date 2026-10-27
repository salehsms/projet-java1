package actors;

public class Fighter extends Survivor {
        /**
         * Constructor for Figther class.
         * @param x The x-coordinate 
         * @param y The y-coordinate 
         */
	    public Fighter(int x,int y) {
               super(x,y);
               this.name = "fighter";
        }
}