////////////////////////////////////////////////////////
// 
//	Authors:     Marvin Tan, Jacob Biese
//	Assignment:  Assignment 1 - Iperfer
//
////////////////////////////////////////////////////////
abstract class Handler {

	/*
	 * Runs a client or server instance
	 */
	abstract void run();

	/**
	 * Prints the number of kilobytes received and rate in megabits
	 * 
	 * @param KBRecieved
	 * @param rate
	 */
	abstract void printSummary(double DataKB, double rate);

}
