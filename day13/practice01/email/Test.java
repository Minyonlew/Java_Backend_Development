package day13.practice01.email;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ����������email���ݡ�aa@sohu.com,bb@163.com,cc@sina.com������Ҫ��   
 *   email�е��û����ֺ��ʼ���ַ���ַ��룬������Լ�ֵ��Ӧ�ķ�ʽ����HashMap������
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
		
		//����һ��set ����ȡkey
		Set<String> set = map.keySet();
		for (String string : set) {
			
			//��� ��ke y+@+ ֵValue
			System.out.println(string+"@"+map.get(string));
		}
	}
	
	
	
}
