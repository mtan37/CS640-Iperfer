package src;

public class IperferClient extends Iperfer {
	private String serverName;
	private int serverPort;
	private Object conn; // TODO: determine type
	private long time;
	
	IperferClient(String serverName, int serverPort, int time){
		//TODO
	}
	
	@Override
	/**
	 * Runs an iperfer client which sends data to a server for a determined amount of time
	 */
	void run(int serverPort) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sends a 1000 byte chunk of data to the server
	 */
	private void sendData() {
		//TODO
	}

}
