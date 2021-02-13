package main;

import java.io.*;
import java.net.*;

public class IperferClient extends Iperfer {
	private String serverName;
	private int serverPort;
	private Socket conn;
	private int time;

	IperferClient(String serverName, int serverPort, int runtime) {
		this.serverName = serverName;
		this.serverPort = serverPort;
		this.time = runtime;
	}

	@Override
	/**
	 * Runs an iperfer client which sends data to a server for a determined amount of time
	 */
	void run() {
		// TODO Auto-generated method stub
		/*
		long start = System.nanoTime();
		try {
			conn = new Socket(serverName, serverPort);
			
			while(time > 0) {
				
			}
		}*/
		
		
	}

	/**
	 * Sends a 1000 byte chunk of data to the server
	 */
	private void sendData() {
		// TODO
	}

	@Override
	void printSummary(double DataKB, double rate) {
		// TODO Auto-generated method stub
		
	}

}
