package day13.practice02.Worker;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 定义一个Worker类,属性:name:String,age:int,salary:double 
	a).把若干Worker对象放在List中,排序并遍历输出,按照age升序排列
	b).把若干Worker对象放在Set中并遍历,要求没有重复元素
	c).把若干Worker对象放在Map中并按照三种方式分别遍历,要求以Worker的姓名作为key。
 *
 */

public class Test01 {   //实现a要求

	public static void main(String[] args) {
		ArrayList<Worker01> ls = new ArrayList<Worker01>();
		ls.add(new Worker01("旺财1", 20, 3000.0));
		ls.add(new Worker01("旺财2", 21, 3000.0));
		ls.add(new Worker01("旺财3", 30, 3000.0));
		ls.add(new Worker01("旺财4", 29, 3000.0));
		
		//通过 内部实现Comparable 实现对象的排序 ？？
		//为什么还需要Collection的排序呢
		Collections.sort(ls);
		
		System.out.println(ls);
	}

}
