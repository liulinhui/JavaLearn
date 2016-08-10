package channelTest;

import java.nio.charset.Charset;
import java.util.SortedMap;
/**
 * java支持的所有字符集
 *
 */
public class CharsetTest {

	public static void main(String[] args) {
		SortedMap<String,Charset>map=Charset.availableCharsets();
		for(String alian:map.keySet()){
			System.out.println(map.get(alian));
		}
	}

}
