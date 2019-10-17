package day12.byHand.ArrayList;


public class MyArrayList01<E> {
	/*
	 * 1.先定义一个数组，还有一个属性：元素个数 size
	 * 2.增加泛型
	 * 3.实现 add()方法
	 * */

	private Object[] elementData;
	private int size;
	
	//数组的初始长度
	private static final int DEFALT_CAPACITY = 10 ;
	
	//构造方法 
	//一个是默认数组的长度
	public MyArrayList01(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	//一个是自定义长度
	public MyArrayList01(int capacity){
		elementData = new Object[capacity];
	}
	
	
	//实现add()
	public void add(Object obj) {
		elementData[size++]=obj;
	}
	
	@Override
	public String toString() {
		
		//要打印 [a,b,c]的形式
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i =0;i<size;i++)
		{
			sb.append(elementData[i]+",");
		}
		//将sb当前最后的字符设置为]
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
