package chapter2;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class RequestTest {
	
	@Test
	public void test() {
		Request request = new Request();
		String actual = request.parseUri("get /servlet/test http1.1");
		Assert.assertEquals("/servlet/test", actual);
	}

}
