package bufferTest;

import java.nio.CharBuffer;

public class Demo {

	public static void main(String[] args) {
		// 创建buffer
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity=" + buff.capacity());
		System.out.println("limit=" + buff.limit());
		System.out.println("position=" + buff.position());
		// 放入元素
		buff.put('j');
		buff.put('a');
		buff.put('s');
		System.out.println("加入三个元素后position=" + buff.position());
		buff.flip();
		System.out.println("flip后limit的值="+buff.limit());
		System.out.println("flip后的position值="+buff.position());
		System.out.println("取出第一个元素（position=0）"+buff.get());
		System.out.println("取出第一个元素后position的值="+buff.position());
		//调用clear
		buff.clear();
		System.out.println("执行clear后limit=" + buff.limit());
		System.out.println("执行clear后position=" + buff.position());
		System.out.println("执行clear后buff里面的值没有被清除，buff第三个字符为："+buff.get(2));
		System.out.println("执行绝对读取后position的值没有改变："+buff.position());
	}

}
