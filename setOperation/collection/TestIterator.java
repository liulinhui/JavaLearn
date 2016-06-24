package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 测试Iterator迭代器
 * 
 * @author linkage
 *
 */
public class TestIterator {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection book=new HashSet();
		book.add("yuwen");
		book.add("math");
		book.add("history");
		Iterator iterator=book.iterator();
		while (iterator.hasNext()) {
			String aString=(String)iterator.next();
			if (aString.equals("math")) {
				iterator.remove();
			}                             //Iterator遍历中不能直接对集合修改   否则报错
			System.out.println(aString);
		}
		System.out.println(book);
	}

}
