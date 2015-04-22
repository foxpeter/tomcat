package chapter3.connector.http;

public class HttpConnector implements Runnable {

	boolean stopped;
	private String scheme = "http";
	
	public String getScheme() {
		return scheme;
	}
	
	@Override
	public void run() {

	}

	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
}
