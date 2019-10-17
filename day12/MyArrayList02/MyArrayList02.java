package day12.byHand.ArrayList;


public class MyArrayList02<E> {
	/*
	 * 1.在01的基础上 添加数组扩容的功能
	 * */

	private Object[] elementData;
	private int size;
	
	//数组的初始长度
	private static final int DEFALT_CAPACITY = 10 ;
	
	//构造方法 
	//一个是默认数组的长度
	public MyArrayList02(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	//一个是自定义长度
	public MyArrayList02(int capacity){
		elementData = new Object[capacity];
	}
	
	
	//实现add()
	public void add(Object obj) {
		//当元素个数跟数组长度一样时，扩容
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

		MyArrayList02 m1 = new MyArrayList02(20);
		for(int i=0;i<40;i++){
			m1.add("gao"+i);
		}
		

		System.out.println(m1);
	}

}
