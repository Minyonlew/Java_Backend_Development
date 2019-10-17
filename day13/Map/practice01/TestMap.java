package day13.Map.practice01;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		Map<Integer,String> map2 = new HashMap<Integer,String>();
		 
	
		 	//1.返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
		 	map.put(2, "wangcai");
			map.put(3, "daniu");
			map2.put(1,"一");
			map2.put(2, "二");
			
			//从指定映射中将所有映射关系复制到此映射中（可选操作）。
			map.putAll(map2);
			System.out.println(map);
			
			//2，存储键值对。如果键相同，会出现值覆盖。
			System.out.println(map.put(4, "xiaoqiang"));
			System.out.println(map.put(4, "erhu"));
			System.err.println("********");
			
			//3.如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
			System.out.println(map.remove(2));
			//4.返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
			System.out.println(map.get(3));

			//5.如果此映射包含指定键的映射关系，则返回 true。
			System.out.println(map.containsKey(2));
			// 如果此映射将一个或多个键映射到指定值，则返回 true。
			System.out.println(map.containsValue("daniu"));
			
			//6.返回此映射中包含的映射关系的 Set 视图。
			System.out.println(map.entrySet());
			
			//7.返回此映射中包含的键的 Set 视图。
			System.out.println(map.keySet());
			
			//8.返回此映射中包含的值的 Collection 视图。
			System.out.println(map.values());
			
			//从此映射中移除所有映射关系（可选操作）。
			//map.clear();
			//System.out.println(map);
		}
}
