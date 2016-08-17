package threadCommunication;

public class DrawThread extends Thread {

	private Account account;
	private double drawAmount;

	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	/**
	 * 执行100次取钱操作
	 */
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			account.draw(drawAmount);
		}
	}
}
