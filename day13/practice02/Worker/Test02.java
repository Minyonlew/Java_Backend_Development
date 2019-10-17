package day13.practice02.Worker;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test02 {

	public static void main(String[] args) {
//		HashSet<Worker02> hs = new HashSet<Worker02>();
//		hs.add(new Worker02("旺财1", 20, 3000.0));
//		hs.add(new Worker02("旺财2", 21, 3000.0));
//		hs.add(new Worker02("旺财3", 30, 3000.0));
//		hs.add(new Worker02("旺财1", 20, 3000.0));
//		System.out.println(hs);
		
		HashMap<String, Worker02> hm = new HashMap<String, Worker02>();
		hm.put("旺财1", new Worker02("旺财1", 20, 3000.0));
		hm.put("旺财2", new Worker02("旺财2", 20, 3000.0));
		hm.put("旺财3", new Worker02("旺财3", 20, 3000.0));
		hm.put("旺财4", new Worker02("旺财4", 20, 3000.0));
		
		//以名字作为key,通过keySet方法将得到的key 赋值给 set集合
		Set<String> set = hm.keySet();
		//遍历set集合中的key，通过get方法得到对应的value并输出
		for (String string : set) {
			System.out.println(hm.get(string));
		}
		System.out.println("****");
		
		//通过迭代器来遍历set中的key
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(hm.get(it.next()));
		}
		System.out.println("****");
		
		//通过 values方法将hm里的values都赋值给 Collection
		Collection<Worker02> cln = hm.values();
		for (Worker02 worker02 : cln) {
			System.out.println(worker02);
		}
	}

}
