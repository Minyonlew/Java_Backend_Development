package day13.hashSet;
import java.util.HashSet;
import java.util.Iterator;

import day11.customExceptionTest.Person;
public class TestMain {

	public static void main(String[] args) {
		HashSet<Employee> hs = new HashSet<Employee>();	
		Iterator<Employee> it = hs.iterator();
		
		
/*-��������һ����Ԫ�ؽ�hashSet, 
 * ͨ��hashCodeֵ �� equals()���� ����ɵġ����Ԫ�ص�HashCodeֵ��ͬ���͵���equals()������
 * Ȼ����hashSet��equals()�����жϵ������������Ƿ���ȣ������Ƕ���������Ƿ���ȣ�
 * ����Ҫ��������������ȵĶ�����ͬʱ���hashSet���ҪҪ��дhashSet�����equals()������
 * 
 * */
		hs.add(new Employee(1002,"��Ĭ��",22));   
		hs.add(new Employee(1001,"��С��",20));
		hs.add(new Employee(1002,"��Ĭ��",22));
		
		System.out.println("������"+hs.size());
		System.out.println("Ա�����ݣ�");
		
		System.out.println(hs);

	}

}
