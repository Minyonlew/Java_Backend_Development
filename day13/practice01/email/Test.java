package day13.practice01.email;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 假如有以下email数据“aa@sohu.com,bb@163.com,cc@sina.com”现需要把   
 *   email中的用户部分和邮件地址部分分离，分离后以键值对应的方式放入HashMap？遍历
 * 
 *
 */
public class Test {

	public static void main(String[] args) {
		String str = "aa@sohu.com,bb@163.com,cc@sina.com";
		String []strA = str.split(",");
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (String string : strA) {
			String [] emails = string.split("@");
			map.put(emails[0], emails[1]);
			
		}
		
		//创建一个set 来获取key
		Set<String> set = map.keySet();
		for (String string : set) {
			
			//输出 键ke y+@+ 值Value
			System.out.println(string+"@"+map.get(string));
		}
	}
	
	
	
}
