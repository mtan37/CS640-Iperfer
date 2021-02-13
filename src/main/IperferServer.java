package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class IperferServer extends Iperfer {

	private static final double SEC_TO_NANO = 1_000_000_000.0;
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
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(clientSocket.getInputStream()));
		String inputLine;
		long dataSizeByte = 0;
		long dataSizeKB = 0;
		//keep track to time - start
		long start = System.nanoTime();
		//keep reading data from client until client closes connection
		while(!clientSocket.isClosed()) {
			int counter = 0;
			while((inputLine = in.readLine()) != null) {
				//store the size of the incoming data
				dataSizeByte += inputLine.getBytes().length;
				//add the stored size into a larger unit
				if(counter > 100) {
					counter = 0;
					long toAdd = dataSizeByte/1000;
					dataSizeByte -= toAdd * 1000;
					dataSizeKB += toAdd;
				}
				counter++;
			}
		}
		serverSocket.close();
		//keep track to time - end
		long end = System.nanoTime();
		//calculate the data transfer rate in Mbps
		double speed = (double)(dataSizeKB/1000.0)/(double)(end-start)/SEC_TO_NANO;
		//print out summary
		printSummary(dataSizeKB, speed);
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
