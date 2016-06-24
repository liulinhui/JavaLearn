package internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Common {

	/**
	 * IP过滤
	 * 
	 * @param ip
	 *            IP地址
	 * @param iparea
	 *            IP网段 (*。*。*。*-*。*。*。*)
	 * @return
	 */
	public boolean ipIsInNet(String ip, String iparea) {
		if (iparea == null)
			throw new NullPointerException("IP段不能为空！");
		if (ip == null)
			throw new NullPointerException("IP不能为空！");
		iparea = iparea.trim();
		ip = ip.trim();
		final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
		if (!iparea.matches(REGX_IPB) || !ip.matches(REGX_IP))
			return false;
		int idx = iparea.indexOf('-');
		String[] sips = iparea.substring(0, idx).split("\\.");
		String[] sipe = iparea.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
		for (int i = 0; i < 4; ++i) {
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		return ips <= ipt && ipt <= ipe;
	}

	/**
	 * 访问url返回数据
	 * @param url
	 * @return
	 */
	public Map<Object, Object> getJson(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<Object, Object> map = resolveJsonstring(json.toString());
		return map;
	}

	/**
	 * json字符串解析
	 * @param string json字符串
	 * @return
	 */
	public Map<Object, Object> resolveJsonstring(String string) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		string = string.replace("{", "").replace("}", "").replace("\"", "");
		String[] arrStrings = string.split(",");
		for (int i = 0; i < arrStrings.length; i++) {
			map.put(arrStrings[i].split(":")[0], arrStrings[i].split(":")[1]);
		}
		return map;
	}

}
