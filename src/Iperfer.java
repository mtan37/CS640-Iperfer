package src;

abstract class Iperfer {

	/*
	 * Runs an Iperfer instance
	 */
	abstract void run(int serverPort);
	
	/**
	 * Prints the number of kilobytes received and rate in megabits
	 * @param KBRecieved
	 * @param rate
	 */
	private void printSummary(int KBRecieved, int rate) {
		System.out.println("recieved=" + KBRecieved + " KB " + "rate=" + rate + " Mbps");
	}
	
}
