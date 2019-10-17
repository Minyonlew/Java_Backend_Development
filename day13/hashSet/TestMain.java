package day13.hashSet;
import java.util.HashSet;
import java.util.Iterator;

import day11.customExceptionTest.Person;
public class TestMain {

	public static void main(String[] args) {
		HashSet<Employee> hs = new HashSet<Employee>();	
		Iterator<Employee> it = hs.iterator();
		
		
/*-存了两个一样的元素进hashSet, 
 * 通过hashCode值 和 equals()方法 来完成的。如果元素的HashCode值相同，就调用equals()方法。
 * 然而，hashSet的equals()方法判断的是两个对象是否相等，而不是对象的内容是否相等，
 * 所以要想让两个内容相等的对象不能同时存进hashSet里，需要要重写hashSet里面的equals()方法。
 * 
 * */
		hs.add(new Employee(1002,"李默文",22));   
		hs.add(new Employee(1001,"王小华",20));
		hs.add(new Employee(1002,"李默文",22));
		
		System.out.println("人数："+hs.size());
		System.out.println("员工内容：");
		
		System.out.println(hs);

	}

}
