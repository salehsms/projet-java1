package game;
class IncorrectArgumentException extends Exception {

    /**
     * Constructs a new IncorrectArgumentException with the specified error message.
     *
     * @param message The error message indicating the condition that was not met.
     */
    public IncorrectArgumentException(String message) {
        super("Values must be greater than or equal to 5");
    }
}