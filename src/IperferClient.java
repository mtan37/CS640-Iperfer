package src;

import java.io.*;
import java.net.*

public class IperferClient extends Iperfer {
	private String serverName;
	private int serverPort;
	private Socket conn; // TODO: determine type
	private int time;
	
	IperferClient(String serverName, int serverPort){
		this.serverName = serverName;
		this.serverPort = serverPort;
	}
	
	@Override
	/**
	 * Runs an iperfer client which sends data to a server for a determined amount of time
	 */
	void run(int runtime) {
		// TODO Auto-generated method stub
		this.time = runtime;
		long start = System.nanoTime();
		try {
			conn = new Socket(serverName, serverPort);
			
			while(time > 0) {
				
			}
		}
		
		
	}
	
	/**
	 * Sends a 1000 byte chunk of data to the server
	 */
	private void sendData() {
		//TODO
	}

}
