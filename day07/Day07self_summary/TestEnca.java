package my.day07.encapsulation02;

import my.day07.encapsulation01.Human;

public class TestEnca {

	public static void main(String[] args) {
		Human h = new Human();
		
		//h.name = "hi"; //default ��Ĭ�ϣ� ��ͬ������ʹ��
	}
	
}

class Girl extends Human {
	
	void saGood(){
		
		System.out.println(height);   //protected ���Ա����ࡢ���������ࡢ�Լ�������������ʹ��
	}
	
}