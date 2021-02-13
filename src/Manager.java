import java.util.HashMap;

import Exceptions.*;


public class Manager {
	
	private final static short ARG_TYPE_POS = 1;
	
	private final static short SERVER_ARG_LENGTH = 4;
	private final static short SERVER_ARG_PORT_POS = 2;
	
	private final static short CLIENT_ARG_LENGTH = 8;
	private final static short CLIENT_ARG_HOST_POS = 2;
	private final static short CLIENT_ARG_PORT_POS = 4;
	private final static short CLIENT_ARG_TIME_POS = 6;
	/**
	 * Check and validate the client/server type indicated in the command arguments
	 * @return 1 for client, 0 for server
	 * @throws InvalidArgsException - argument doesn't provide a type
	 * 
	 */
	public static boolean validateType(String[] args) throws InvalidArgsException {
		if(args[ARG_TYPE_POS].equals("-c")) {
			return true;
		}
		else if(args[ARG_TYPE_POS].equals("-s")) {
			return false;
		}
		throw new InvalidArgsException("Error: missing or additional arguments");
	}
	
	/**
	 * validate the provided argument to make sure it has the right format
	 * @throws InvalidArgsException - argument content format doesn't match expectation
	 * @throws InvalidPortNumberException - provided port number has a legal format but
	 * 		  	is in invalid range	
	 */
	public static HashMap<String, Object> validateArgs(String[] args, boolean isClient) throws InvalidArgsException, InvalidPortNumberException{	
		return null;
		//TODO
	}
	
	public static void main(String[] args) {
		try {
			boolean isClient = validateType(args);
			validateArgs(args, isClient);
		} catch (InvalidArgsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPortNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
