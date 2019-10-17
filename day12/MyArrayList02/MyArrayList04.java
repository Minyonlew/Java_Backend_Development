package day12.byHand.ArrayList;



public class MyArrayList04<E> {
	/*
	 * 1.��03�Ļ����� ����� remove()����
	 * 2.remove() ��ɾ��ָ����Ԫ�أ���һ��������
	 * 3.isEmpty()
 	 * */

	private Object[] elementData;
	private int size;
	
	//����ĳ�ʼ����
	private static final int DEFALT_CAPACITY = 10 ;
	
	//���췽�� 
	//һ����Ĭ������ĳ���
	public MyArrayList04(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	//һ�����Զ��峤��
	public MyArrayList04(int capacity){
		if(capacity<0){
			throw  new  RuntimeException("��������������Ϊ����");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
	}
	
	
	public void remove(E element) {
		//��element����Ԫ�ؼ��ϣ���õ�һ����ȵ�ֵ
		for(int i = 0 ;i<size;i++)
		{
			if(element.equals(elementData[i]))
			{
				remove(i);
			}
		}
		
	}
	public void remove(int index) {
		//0,1,2,3,4,5,6,7
		//a,b,c,d,e,f,g,null
		//a,b,c,e,f,g,null,null
		//Ҫ�ƶ���Ԫ����Ŀ  8-3-1 = 4
		int numMoved = elementData.length-index-1;
		if(numMoved>0)
		{
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		
		//�����ɾ�����һ����������ǰ���Ѿ�ɾ����Ҫ��������ظ���Ԫ��
		elementData[--size]=null;
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
	public  boolean isEmpty(){
		return  size==0?true:false;
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

		MyArrayList04 m1 = new MyArrayList04(20);
		for(int i=0;i<40;i++){
			m1.add("gao"+i);
		}
		
		m1.set("hi", 10);
		System.out.println(m1.get(10));
		System.out.println(m1);
		
		m1.remove(3);
		m1.remove("gao12");
		System.out.println(m1);
		System.out.println(m1.size);
		
		System.out.println(m1.isEmpty()); 
	}

}
