package day12.byHand.ArrayList;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

/**
 * 增加remove
 * 
 *
 */
public class SxtArrayList05<E> {
	
	private Object[]  elementData;
	private int  size;
	
	private static final int DEFALT_CAPACITY = 10 ;
	
	
	public SxtArrayList05(){
		elementData = new Object[DEFALT_CAPACITY]; 
	}
	
	public SxtArrayList05(int  capacity) {
		
		if(capacity<0){
			throw  new  RuntimeException("容器的容量不能为负数");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
		
		
	}
	
	public int size(){
		return size;
	}
	
	public  boolean isEmpty(){
		return  size==0?true:false;
	}
	
	
	public  void  add(E  element){
		
		//什么时候扩容？？
		if(size == elementData.length){
			//扩容操作
			Object[]  newArray  =  new Object[elementData.length+(elementData.length>>1)];  //10-->10+10/2
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); 
			elementData = newArray;
		}
		
		elementData[size++] = element;
	}
	
	public  E  get(int index) {
		
		checkRange(index);
		
		return  (E)elementData[index];
	}
	
	public void set(E element, int  index) {
		
		checkRange(index);
		
		elementData[index] = element;
		
	}
	
	public  void  checkRange(int index ){
		//索引合法判断 [0,size)    10    0-9
				if(index<0||index>size-1){
					//不合法
					throw  new RuntimeException("索引不合法:"+index);
				}
	}
	
	public void  remove(E  element){
		//element，将它和所有元素挨个比较，获得第一个比较为true的，返回。
		for(int i=0;i<size;i++){
			if(element.equals(get(i))){   //容器中所有的比较操作，都是用的equals而不是==
				
				//将该元素从此处移除
				remove(i);
			}
		}
	}
	
	public  void  remove(int index){
		
		//a,b,c,d,e,f,g,h
		//a,b,c,e,f,g,h,h
		int numMoved = elementData.length-index-1;
		if(numMoved>0){
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		
		elementData[--size] = null;
		
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder  sb = new StringBuilder();
		
		//[a,b,c]
		sb.append("[");
		for(int i=0;i<size;i++){
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']'); 
		
		return  sb.toString();
	}
	
	
	public static void main(String[] args) {
		SxtArrayList05  s1 = new SxtArrayList05();
		
		for(int i=0;i<40;i++){
			s1.add("gao"+i);
		}
		
		s1.set("dddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(39));

		s1.remove(3);
		s1.remove("gao11");
		System.out.println(s1);
		System.out.println(s1.size);
		System.out.println(s1.isEmpty()); 
	}
	
	
}
