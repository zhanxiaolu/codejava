package NET;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;

/**
 * socket ��ʾ����
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
		if (StringUtils.isNotEmpty(host)) {// ��ӡ����ָ��host��ip��ַ�����磺www.baidu.com
			InetAddress[] addresses = InetAddress.getAllByName(host);
			for (InetAddress a : addresses)
				System.out.println(a);
		} else {// ��ӡ��������������ַ
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
