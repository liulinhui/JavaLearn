package threadCommunication;

public class Account {
	private String accountNo;// 账户
	private double balance;// 余额
	private boolean flag = false; // 是否已经有存款

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	// 账户余额不允许修改 仅仅提供了get方法
	public double getBalancd() {
		return balance;
	}

	/**
	 * 取钱
	 * 
	 * @param drowAccount
	 */
	public synchronized void draw(double drowAccount) {
		try {
			if (balance<=0) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱" + drowAccount);
				balance -= drowAccount;
				System.out.println("账户余额为" + balance);
				flag = false;
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 存钱
	 * 
	 * @param despositAccount
	 */
	public synchronized void desposit(double despositAccount) {
		try {
			if (balance>0) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "存钱：" + despositAccount);
				balance += despositAccount;
				System.out.println("账户余额为：" + balance);
				flag = true;
				notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object != null && object.getClass() == Account.class) {
			Account target = (Account) object;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}

}
