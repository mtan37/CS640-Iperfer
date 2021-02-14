package main;
import java.util.HashMap;

import Exceptions.*;

public class Manager {

	private final static short ARG_TYPE_POS = 0;

	private final static short SERVER_ARG_LENGTH = 3;
	private final static short SERVER_ARG_PORT_POS = 1;// -p

	private final static short CLIENT_ARG_LENGTH = 7;
	private final static short CLIENT_ARG_HOST_POS = 1;// -h
	private final static short CLIENT_ARG_PORT_POS = 3;// -p
	private final static short CLIENT_ARG_TIME_POS = 5;// -t

	/**
	 * Check and validate the client/server type indicated in the command arguments
	 * 
	 * @return 1 for client, 0 for server
	 * @throws InvalidArgsException - argument doesn't provide a type
	 * 
	 */
	public static boolean validateType(String[] args) throws InvalidArgsException {
		try {
			if (args[ARG_TYPE_POS].equals("-c")) {
				return true;
			} else if (args[ARG_TYPE_POS].equals("-s")) {
				return false;
			}
		}
		catch (Exception e) {
			throw new InvalidArgsException("Error: missing or additional arguments");
		}
		throw new InvalidArgsException("Error: missing or additional arguments");
	}

	/**
	 * validate the provided argument to make sure it has the right format
	 * 
	 * @throws InvalidArgsException       - argument content format doesn't match
	 *                                    expectation
	 * @throws InvalidPortNumberException - provided port number has a legal format
	 *                                    but is in invalid range
	 */
	public static HashMap<String, Object> validateArgs(String[] args, boolean isClient)
			throws InvalidArgsException, InvalidPortNumberException, NumberFormatException {
		if (isClient) {
			// check if the flags are in place properly
			if (args.length != CLIENT_ARG_LENGTH)
				throw new InvalidArgsException("Error: missing or additional arguments");
			if (!args[CLIENT_ARG_HOST_POS].equals("-h"))
				throw new InvalidArgsException("Error: missing or additional arguments");
			if (!args[CLIENT_ARG_PORT_POS].equals("-p"))
				throw new InvalidArgsException("Error: missing or additional arguments");
			if (!args[CLIENT_ARG_TIME_POS].equals("-t"))
				throw new InvalidArgsException("Error: missing or additional arguments");
			Integer portNum = Integer.parseInt(args[CLIENT_ARG_PORT_POS + 1]);
			if (portNum < 1024 || portNum > 65535)
				throw new InvalidPortNumberException("Error: port number must be in the range 1024 to 65535");
			Integer time = Integer.parseInt(args[CLIENT_ARG_TIME_POS + 1]);
			HashMap<String, Object> argsList = new HashMap<String, Object>();
			argsList.put("port", portNum);
			argsList.put("time", time);
			argsList.put("host", args[CLIENT_ARG_HOST_POS + 1]);
			return argsList;
		} else {
			// check if the flags are in place properly
			if (args.length != SERVER_ARG_LENGTH)
				throw new InvalidArgsException("Error: missing or additional arguments");
			if (!args[SERVER_ARG_PORT_POS].equals("-p"))
				throw new InvalidArgsException("Error: missing or additional arguments");
			Integer portNum = Integer.parseInt(args[SERVER_ARG_PORT_POS + 1]);
			if (portNum < 1024 || portNum > 65535)
				throw new InvalidPortNumberException("Error: port number must be in the range 1024 to 65535");
			HashMap<String, Object> argsList = new HashMap<String, Object>();
			argsList.put("port", portNum);
			return argsList;
		}
	}

	public static void main(String[] args) {
		try {
			boolean isClient = validateType(args);
			HashMap<String, Object> argsList = validateArgs(args, isClient);
			Iperfer prog = null;
			if (isClient) {
				// create an instance of IperferClient
				String host = (String) argsList.get("host");
				Integer port = (Integer) argsList.get("port");
				Integer time = (Integer) argsList.get("time");
				prog = new IperferClient(host, port, time);
			} else {
				// create an instance of IperferServer
				Integer port = (Integer) argsList.get("port");
				prog = new IperferServer(port);
			}
			prog.run();
		} catch (InvalidArgsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidPortNumberException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error: port number must be in the range 1024 to 65535");
			e.printStackTrace();
		}
	}
}
