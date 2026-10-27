package game;
public class CityMain {

    /**
     * The main method of the City.
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

            // Display the city
            city.displayCity();

            // Display city details
            city.detailsCity();

        } catch (NumberFormatException e) {
            System.out.println("Error: Arguments must be integers.");
        } catch (IllegalArgumentException | IncorrectArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}