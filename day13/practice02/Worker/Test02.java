package day13.practice02.Worker;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test02 {

	public static void main(String[] args) {
//		HashSet<Worker02> hs = new HashSet<Worker02>();
//		hs.add(new Worker02("����1", 20, 3000.0));
//		hs.add(new Worker02("����2", 21, 3000.0));
//		hs.add(new Worker02("����3", 30, 3000.0));
//		hs.add(new Worker02("����1", 20, 3000.0));
//		System.out.println(hs);
		
		HashMap<String, Worker02> hm = new HashMap<String, Worker02>();
		hm.put("����1", new Worker02("����1", 20, 3000.0));
		hm.put("����2", new Worker02("����2", 20, 3000.0));
		hm.put("����3", new Worker02("����3", 20, 3000.0));
		hm.put("����4", new Worker02("����4", 20, 3000.0));
		
		//��������Ϊkey,ͨ��keySet�������õ���key ��ֵ�� set����
		Set<String> set = hm.keySet();
		//����set�����е�key��ͨ��get�����õ���Ӧ��value�����
		for (String string : set) {
			System.out.println(hm.get(string));
		}
		System.out.println("****");
		
		//ͨ��������������set�е�key
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(hm.get(it.next()));
		}
		System.out.println("****");
		
		//ͨ�� values������hm���values����ֵ�� Collection
		Collection<Worker02> cln = hm.values();
		for (Worker02 worker02 : cln) {
			System.out.println(worker02);
		}
	}

}
