package day13.practice02.Worker;


import java.util.ArrayList;
import java.util.Collections;

/**
 * ����һ��Worker��,����:name:String,age:int,salary:double 
	a).������Worker�������List��,���򲢱������,����age��������
	b).������Worker�������Set�в�����,Ҫ��û���ظ�Ԫ��
	c).������Worker�������Map�в��������ַ�ʽ�ֱ����,Ҫ����Worker��������Ϊkey��
 *
 */

public class Test01 {   //ʵ��aҪ��

	public static void main(String[] args) {
		ArrayList<Worker01> ls = new ArrayList<Worker01>();
		ls.add(new Worker01("����1", 20, 3000.0));
		ls.add(new Worker01("����2", 21, 3000.0));
		ls.add(new Worker01("����3", 30, 3000.0));
		ls.add(new Worker01("����4", 29, 3000.0));
		
		//ͨ�� �ڲ�ʵ��Comparable ʵ�ֶ�������� ����
		//Ϊʲô����ҪCollection��������
		Collections.sort(ls);
		
		System.out.println(ls);
	}

}
