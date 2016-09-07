package NET;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class NetWorkDemoTest {
	NetWorkDemo demo = new NetWorkDemo();

	@Test
	public void testSocketInfo() throws UnknownHostException, IOException {
//		demo.socketInfo(new Socket("time-A.timefreq.bldrdoc.gov", 13));
		demo.socketInfo(new Socket("127.0.0.1", 8189));

	}
	@Test
	public void testGetInetAddress() throws UnknownHostException {
		demo.getInetAddress("www.sina.com");
	}

}
