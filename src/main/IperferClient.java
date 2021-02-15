package main;

import java.io.*;
import java.net.*;

public class IperferClient extends Iperfer {
	private String serverName;
	private int serverPort;
	private Socket conn;
	private int time;
	final static double NANO_CONVERS = 1000000000.0;
	
	IperferClient(String serverName, int serverPort, int runtime){
		this.serverName = serverName;
		this.serverPort = serverPort;
		this.time = runtime;
	}
	
	@Override
	/**
	 * Runs an iperfer client which sends data to a server for a determined amount of time
	 */
	void run() {
		byte[] oneKB = new byte[1000];
		try {
			// Creates a new socket and data stream
			conn = new Socket(serverName, serverPort);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			int count = 0;
			// Continuously sends 1 KB until the end time is reached
			long start = System.nanoTime();
			long end = start + time*(long)NANO_CONVERS;
			long sent_end ;
			while((sent_end = System.nanoTime()) < end) {
				out.write(oneKB);
				count++;
			}
			conn.close();
			
			// Finds the time spent and calculates the rate in Mbps
			long totalTime = sent_end - start;
			double rate = ((count*8/1000.0)/(totalTime/NANO_CONVERS));
			this.printSummary(count, rate);
			
		} catch(UnknownHostException e) {
			System.out.println("Unable to find host " + serverName);
			System.exit(1);
		} catch(IOException e) {
			System.out.println("Unable to establish I/O to the host " + serverName);
			System.exit(1);
		}
	}
	
	void printSummary(double dataKB, double rate) {
		System.out.println("sent=" + dataKB + " KB " + "rate=" + rate + " Mbps");
	}
}
