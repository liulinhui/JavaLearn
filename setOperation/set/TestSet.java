package set;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		Set<Object>set=new HashSet<Object>();
		set.add("math");
		set.add("chinese");
		String aString=new String("math");
		set.add(aString);
		System.out.println(set);
		System.out.println("math".hashCode()+"============"+aString.hashCode());
		System.out.println(aString=="math");
          
	}

}
