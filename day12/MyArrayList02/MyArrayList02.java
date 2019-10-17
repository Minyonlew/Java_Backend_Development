package day12.byHand.ArrayList;


public class MyArrayList02<E> {
	/*
	 * 1.��01�Ļ����� ����������ݵĹ���
	 * */

	private Object[] elementData;
	private int size;
	
	//����ĳ�ʼ����
	private static final int DEFALT_CAPACITY = 10 ;
	
	//���췽�� 
	//һ����Ĭ������ĳ���
	public MyArrayList02(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	//һ�����Զ��峤��
	public MyArrayList02(int capacity){
		elementData = new Object[capacity];
	}
	
	
	//ʵ��add()
	public void add(Object obj) {
		//��Ԫ�ظ��������鳤��һ��ʱ������
		if(size==elementData.length){
										//10-->10+(10/2)
			Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		
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

		MyArrayList02 m1 = new MyArrayList02(20);
		for(int i=0;i<40;i++){
			m1.add("gao"+i);
		}
		

		System.out.println(m1);
	}

}
