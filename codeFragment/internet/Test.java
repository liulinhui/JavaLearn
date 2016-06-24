package internet;

public class Test {
	static Common common = new Common();

	public static void main(String[] args) {
		String ipString = "121.122.111.121";
		String ipString2 = "123.122.111.34-123.122.111.123";
		System.out.println(common.ipIsInNet(ipString, ipString2));
		System.out.println(common.getJson("http://114.215.147.90:8080/SpringMvcStudy/ajaxAccount_login").toString());
	}
}
