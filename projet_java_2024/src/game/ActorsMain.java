package game;

import actors.*;
import equipements.*;
import java.util.List;

public class ActorsMain {

    /**
     * The main method of the City with actors.
     *
     * @param args Command-line arguments containing the number of rows (nbRow) and columns (nbCol).
     */
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                throw new IllegalArgumentException("Please provide at least two arguments: nbRow and nbCol");
            }

            int nbRow = Integer.parseInt(args[0]);
            int nbCol = Integer.parseInt(args[1]);

            if (nbRow < 5 || nbCol < 5) {
                throw new IncorrectArgumentException("Arguments must be integers greater than or equal to 5");
            }

            City city = new City(nbRow, nbCol);

            // Build the city
            city.buildCity();

            // Display city details
            city.detailsCity();

            // Display the city
            city.displayCity();

            ActionExample action = new ActionExample(city);

            System.out.println();
            System.out.println("---Create/add survivors and zombies---");
            System.out.println();

            action.CreatePlayers();
            action.createZombies();
            city.displaySurvivors();
            city.displayCity();

            System.out.println();
            System.out.println("---Put a map in each survivors' backpack---");
            System.out.println();
            
            List<Survivor> survivors = city.getSurvivors();
            
            for (Survivor s: survivors){
                action.putItemInBackpack(s, new Map());
            }

            city.displayCity();
            System.out.println();
            city.displaySurvivors();

            System.out.println();
            System.out.println("---Put a vial in each survivors' hand---");
            System.out.println();

            for (Survivor s: survivors){
                action.putItemInHand1(s, new Vial());
            }
            
            city.displayCity();
            city.displaySurvivors();

            System.out.println();
            System.out.println("---Move survivors to north---");
            System.out.println();

            for (int i=0; i<city.getSurvivors().size(); i++) {
            	action.moveSurvivorToNorth(city.getSurvivors().get(0));
            }

            city.displayCity();
            city.displaySurvivors();

        } catch (NumberFormatException e) {
            System.out.println("Error: Arguments must be integers.");
        } catch (IllegalArgumentException | IncorrectArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
