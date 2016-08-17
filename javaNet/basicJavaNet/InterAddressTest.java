package basicJavaNet;

import java.io.IOException;
import java.net.InetAddress;

public class InterAddressTest {

	public static void main(String[] args) throws IOException {
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println(ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		System.out.println(ip.getCanonicalHostName());
	}

}
