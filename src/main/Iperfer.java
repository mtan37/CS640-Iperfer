
package main;

abstract class Iperfer {

	/*
	 * Runs an Iperfer instance
	 */
	abstract void run();

	/**
	 * Prints the number of kilobytes received and rate in megabits
	 * 
	 * @param KBRecieved
	 * @param rate
	 */
	@SuppressWarnings("unused")
	abstract void printSummary(double DataKB, double rate);

}
