package action;

class CantExecuteActionException extends Exception {
	
	public CantExecuteActionException(String message) {
        super("Can't execute this action.");
    }

}
