package my.day07.encapsulation01;
/*
 * 
 * ���Է�װ		
 * 
 * 
 * */
public class TestEnca01 {   //ÿ��Class �ļ�ֻ����һ������public ���� ����������default��Ĭ�ϣ�
	
	public static void main(String[] args) {
		Human h = new Human();
		
		//h.age = 13;    //˽�еĳ�Ա����ֻ���ڱ�����ʹ�ã������������ࣨ���඼���У�
		
		h.name = "hi";   //default Ĭ�ϵĳ�Ա���������ڱ����е���������ʹ��
		
		h.height =0;     //protected ���Ա����ࡢ���������ࡢ�Լ�������������ʹ��
	}

}




class Boy extends Human{
	
	void sayHello(){
		//System.out.println(age);//˽�еĳ�Ա����ֻ���ڱ�����ʹ�ã������������ࣨ���඼���У�
		
	}

}