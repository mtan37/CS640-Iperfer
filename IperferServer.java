////////////////////////////////////////////////////////
// 
//	Authors:     Marvin Tan, Jacob Biese
//	Assignment:  Assignment 1 - Iperfer
//
////////////////////////////////////////////////////////
package main;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IperferServer extends Handler {

	private static final double SEC_TO_NANO = 1_000_000_000.0;
	private static final double KB_TO_BYTE = 1000.0;
	private static final double BYTE_TO_BIT = 8.0;
	private int serverPort = 0;
	IperferServer(int serverPort) {
		this.serverPort = serverPort;
	}

	@Override
	void run() {
		try {
		//start listening on server port
		ServerSocket serverSocket = new ServerSocket(serverPort);
		//Waiting for connection from client
		Socket clientSocket = serverSocket.accept();
		BufferedInputStream in = new BufferedInputStream(
		        new BufferedInputStream(clientSocket.getInputStream()));
		byte[] kiloBytes = new byte[(int)KB_TO_BYTE];
		int bytes = 0;
		long dataSizeByte = 0;
		long dataSizeKB = 0;
		//keep track to time - start
		long start = System.nanoTime();
		//keep reading data from client until client closes connection
		while((bytes = in.read(kiloBytes, 0, (int)KB_TO_BYTE)) != -1){
			//store the size of the incoming data
			dataSizeByte += bytes;
		}
		
		//keep track to time - end
		long end = System.nanoTime();
		
		//add the stored size into a larger unit
		long toAdd = (long) (dataSizeByte/KB_TO_BYTE);
		dataSizeByte -= toAdd * KB_TO_BYTE;
		dataSizeKB += toAdd;
		//calculate the data transfer rate in Mbps
		double speed = ((dataSizeKB/KB_TO_BYTE)*BYTE_TO_BIT)/((end-start)/SEC_TO_NANO);
		//print out summary
		this.printSummary(dataSizeKB, speed);
		clientSocket.close();
		serverSocket.close();
		//stop the program
		System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			//stop the program
			System.exit(1);
		}

	}

	@Override
	void printSummary(double DataKB, double rate) {
		System.out.println(
				"recieved=" + DataKB + " KB " + "rate=" + rate + " Mbps");
	}

}
