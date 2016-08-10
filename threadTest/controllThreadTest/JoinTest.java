package controllThreadTest;

/**
 * join线程
 * 
 * @author liulinhui
 *
 */
public class JoinTest extends Thread {
	public JoinTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new JoinTest("新线程").start();
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				JoinTest joinTest = new JoinTest("被join的线程");
				joinTest.start();
				//此时新线程和被join的线程并发执行，主线程阻塞
				joinTest.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
