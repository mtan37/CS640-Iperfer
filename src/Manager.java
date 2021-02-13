package src;
import Exceptions.*;


public class Manager {

	/**
	 * Check and validate the client/server type indicated in the command arguments
	 * @return 1 for client, 0 for server
	 * @throws InvalidArgsException - argument doesn't provide a type
	 * 
	 */
	public boolean validateType(String[] args) throws InvalidArgsException, InvalidPortNumberException {
		//TODO
		return false;
	}
	
	/**
	 * validate the provided argument to make sure it has the right format
	 * @throws InvalidArgsException - argument content format doesn't match expectation
	 * @throws InvalidPortNumberException - provided port number has a legal format but
	 * 		  	is in invalid range	
	 */
	public void validateServerArgs(String[] args) {
		//TODO
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
