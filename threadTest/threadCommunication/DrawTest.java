package threadCommunication;

public class DrawTest {

	public static void main(String[] args) {
		Account account = new Account("123456789", 0);
		new DepositThread("存钱人A", account, 800).start();
		new DepositThread("存钱人B", account, 800).start();
		new DepositThread("存钱人C", account, 800).start();
		new DrawThread("取钱者", account, 800).start();
	}

}
