package filePathTest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path=Paths.get("");
		System.out.println("path里面包含的路径数量="+path.getNameCount());
		System.out.println(path.toAbsolutePath());
		Path absolutePath=path.toAbsolutePath();
		System.out.println(absolutePath.getRoot());
		System.out.println(absolutePath.getNameCount());
	}

}
