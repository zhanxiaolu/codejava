
import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;

import NET.NetWorkDemoTest;

public class RunTest  {
	@Test
	public void test1() throws UnknownHostException, IOException {
		 try {
			if (true) {
				throw new NullPointerException();
			} else {
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Integer s=new Integer(9);
		Integer t=new Integer(9);
		System.out.println(s==t);
		System.out.println(s.equals(9));
	}
	public static void operator(StringBuffer x, StringBuffer y) { 
	    x.append(y); y = x; 
	}
	public static void main(String[] args) {
		Integer s=new Integer(9);
		Integer t=new Integer(9);
		System.out.println(s==t);
		System.out.println(s.equals(9));
	}
}
