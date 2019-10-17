package day12.byHand.ArrayList;



public class MyArrayList03<E> {
	/*
	 * 1.在02基础上，添加 set get 功能
	 * 2.set() 将元素按照指定的下标加到容器
	 * 3.get() 在容器中寻找指定下标的元素
	 * 4.通过checkRange 方法来检测输入的下标是否准确
	 * */

	private Object[] elementData;
	private int size;
	
	//数组的初始长度
	private static final int DEFALT_CAPACITY = 10 ;
	
	//构造方法 
	//一个是默认数组的长度
	public MyArrayList03(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	//一个是自定义长度
	public MyArrayList03(int capacity){
		if(capacity<0){
			throw  new  RuntimeException("容器的容量不能为负数");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
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
	
	public E get(int index)
	{
		//在容器中寻找指定下标的元素
		checkRange(index);
		
		return (E)elementData[index];
	}
	
	public void set(E element , int index) {
		//将元素按照指定的下标加到容器
		checkRange(index);
		elementData[index] = element;
		
		
	}
	public void checkRange(int index) {
		
		//判断下标 是否存在 [0,size-1) 的范围内
		if(index<0||index>size-1)
			throw new RuntimeException("索引不合法:"+index);
		
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

		MyArrayList03 m1 = new MyArrayList03(20);
		for(int i=0;i<40;i++){
			m1.add("gao"+i);
		}
		
		m1.set("hi", 10);
		System.out.println(m1.get(10));
		System.out.println(m1);
	}

}
