package chapter2;

import java.io.IOException;

public class StaticResorceProcessor {

	public void process(Request request, Response response){
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
