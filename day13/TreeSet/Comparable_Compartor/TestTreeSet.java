package day13.TreeSet.Comparable_Compartor;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet {
	
	/*-��ʹ��TreeSetʱ�����ȥ�Ķ�����Ҫ����ȷ�Ĵ�С��ϵ
	 * �����磩���TreeSet��new Employee��1002,"��Ĭ��",22����(new Employee(1001,"��С��",20) ʱ
	 * ϵͳ�޷�ȷ������������Ĵ�С��ϵ�����Ա����ʱ��ᱨ��
	 *-Ϊ�˾����������ĸ����Կ�������ȷ������֮��Ĵ�С��ϵ������Employee�����age��������
	 * �����ַ�����
	 * 	-����һ�����ⲿ�Ƚ����� ������  ʵ��Comparator�ӿ� ʵ��compare����
	 * 
	 *  -����һ�����ڲ��Ƚ�����������  ʵ��Comparable�ӿ� ʵ��compareTo����
	 *  
	 *  
	 *	
	 * */
	
	
	
	

	

	public static void main(String[] args) {
		//TreeSet ts = new TreeSet(new AgeCp());   //�ⲿ�Ƚ���
		TreeSet  ts2 = new TreeSet();      //�ڲ��Ƚ�ǿ
		ts2.add(new Person(10));
		ts2.add(new Person(10));
		ts2.add(new Person(20));
		System.out.println(ts2);
	}

}
