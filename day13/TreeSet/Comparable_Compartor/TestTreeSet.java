package day13.TreeSet.Comparable_Compartor;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet {
	
	/*-在使用TreeSet时，存进去的对象需要有明确的大小关系
	 * （例如）存进TreeSet（new Employee（1002,"李默文",22）、(new Employee(1001,"王小华",20) 时
	 * 系统无法确定这两个对象的大小关系，所以编译的时候会报错。
	 *-为了决定对象中哪个属性可以用来确定它们之间的大小关系（如用Employee里面的age来决定）
	 * 有两种方法：
	 * 	-创建一个“外部比较器” 来决定  实现Comparator接口 实现compare方法
	 * 
	 *  -创建一个“内部比较器”来决定  实现Comparable接口 实现compareTo方法
	 *  
	 *  
	 *	
	 * */
	
	
	
	

	

	public static void main(String[] args) {
		//TreeSet ts = new TreeSet(new AgeCp());   //外部比较器
		TreeSet  ts2 = new TreeSet();      //内部比较强
		ts2.add(new Person(10));
		ts2.add(new Person(10));
		ts2.add(new Person(20));
		System.out.println(ts2);
	}

}
