package chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer1 {

	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer1 server = new HttpServer1();
		server.await();
	}
	
	public void await(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(!shutdown){
			Socket socket = null;
			InputStream in = null;
			OutputStream out = null;
			
			try {
				socket = serverSocket.accept();
				in = socket.getInputStream();
				out = socket.getOutputStream();
				
				Request request = new Request(in);
				request.parse();
				
				Response response = new Response(out);
				response.setRequest(request);
				
				if(request.getUri().startsWith("/servlet/")){
					ServletProcessor1 processor = new ServletProcessor1();
					processor.process(request, response);
				}else{
					StaticResorceProcessor processor = new StaticResorceProcessor();
					processor.process(request, response);
				}
				
				socket.close();
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
