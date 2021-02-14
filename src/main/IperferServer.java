package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class IperferServer extends Iperfer {

	private static final double SEC_TO_NANO = 1_000_000_000.0;
	private static final double KB_TO_BYTE = 1000.0;
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
		while((inputLine = in.readLine()) != null) {
			//store the size of the incoming data
			dataSizeByte += inputLine.getBytes().length;
		}
		//keep track to time - end
		long end = System.nanoTime();
		
		//add the stored size into a larger unit
		long toAdd = (long) (dataSizeByte/KB_TO_BYTE);
		dataSizeByte -= toAdd * KB_TO_BYTE;
		dataSizeKB += toAdd;
		//calculate the data transfer rate in Mbps
		double speed = (dataSizeKB/KB_TO_BYTE)/((end-start)/SEC_TO_NANO);
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
