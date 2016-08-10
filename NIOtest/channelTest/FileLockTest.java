package channelTest;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) {
		try {
			FileChannel fileChannel=new FileOutputStream("/home/liulinhui/git/test/a.text").getChannel();
			{
				FileLock fileLock=fileChannel.tryLock();
				Thread.sleep(5000);
				System.out.println("解除锁定");
				fileLock.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
