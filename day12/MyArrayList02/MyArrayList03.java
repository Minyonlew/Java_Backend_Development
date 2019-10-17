package day12.byHand.ArrayList;



public class MyArrayList03<E> {
	/*
	 * 1.��02�����ϣ���� set get ����
	 * 2.set() ��Ԫ�ذ���ָ�����±�ӵ�����
	 * 3.get() ��������Ѱ��ָ���±��Ԫ��
	 * 4.ͨ��checkRange ���������������±��Ƿ�׼ȷ
	 * */

	private Object[] elementData;
	private int size;
	
	//����ĳ�ʼ����
	private static final int DEFALT_CAPACITY = 10 ;
	
	//���췽�� 
	//һ����Ĭ������ĳ���
	public MyArrayList03(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	//һ�����Զ��峤��
	public MyArrayList03(int capacity){
		if(capacity<0){
			throw  new  RuntimeException("��������������Ϊ����");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
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
	
	public E get(int index)
	{
		//��������Ѱ��ָ���±��Ԫ��
		checkRange(index);
		
		return (E)elementData[index];
	}
	
	public void set(E element , int index) {
		//��Ԫ�ذ���ָ�����±�ӵ�����
		checkRange(index);
		elementData[index] = element;
		
		
	}
	public void checkRange(int index) {
		
		//�ж��±� �Ƿ���� [0,size-1) �ķ�Χ��
		if(index<0||index>size-1)
			throw new RuntimeException("�������Ϸ�:"+index);
		
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

		MyArrayList03 m1 = new MyArrayList03(20);
		for(int i=0;i<40;i++){
			m1.add("gao"+i);
		}
		
		m1.set("hi", 10);
		System.out.println(m1.get(10));
		System.out.println(m1);
	}

}
