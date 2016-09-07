package NET;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;

/**
 * socket 演示程序
 * 
 * @author Administrator
 * 
 */
public class NetWorkDemo {
	public void socketInfo(Socket s) {
		try {
			try {
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);

				while (in.hasNextLine()) {
					String line = in.nextLine();
					System.out.println(line);
				}
			} finally {
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getInetAddress(String host) throws UnknownHostException {
		if (StringUtils.isNotEmpty(host)) {// 打印参数指定host的ip地址，例如：www.baidu.com
			InetAddress[] addresses = InetAddress.getAllByName(host);
			for (InetAddress a : addresses)
				System.out.println(a);
		} else {// 打印本机的因特网地址
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
