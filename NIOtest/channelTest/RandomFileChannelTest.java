package channelTest;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {

	public static void main(String[] args) {
		File file = new File("/home/liulinhui/git/test/a.text");
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
			FileChannel fileChannel = randomAccessFile.getChannel();
			{
				MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
//				randomAccessFile.seek(file.length()); 两种方法均可
				fileChannel.position(file.length());
				fileChannel.write(buffer);
				randomAccessFile.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
