package day12.byHand.ArrayList;


public class MyArrayList01<E> {
	/*
	 * 1.�ȶ���һ�����飬����һ�����ԣ�Ԫ�ظ��� size
	 * 2.���ӷ���
	 * 3.ʵ�� add()����
	 * */

	private Object[] elementData;
	private int size;
	
	//����ĳ�ʼ����
	private static final int DEFALT_CAPACITY = 10 ;
	
	//���췽�� 
	//һ����Ĭ������ĳ���
	public MyArrayList01(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	//һ�����Զ��峤��
	public MyArrayList01(int capacity){
		elementData = new Object[capacity];
	}
	
	
	//ʵ��add()
	public void add(Object obj) {
		elementData[size++]=obj;
	}
	
	@Override
	public String toString() {
		
		//Ҫ��ӡ [a,b,c]����ʽ
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i =0;i<size;i++)
		{
			sb.append(elementData[i]+",");
		}
		//��sb��ǰ�����ַ�����Ϊ]
		sb.setCharAt(sb.length()-1, ']');

		return sb.toString();
		
	}
	

	public static void main(String[] args) {

		MyArrayList01 m1 = new MyArrayList01(20);
		m1.add("aa");
		m1.add("bb");

		System.out.println(m1);
	}

}
