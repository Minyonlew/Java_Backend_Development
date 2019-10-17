package day12.byHand.ArrayList;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

/**
 * 增加set和get方法
 * 增加：数组边界的检查
 * 
 *
 */
public class SxtArrayList04<E> {
	
	private Object[]  elementData;
	private int  size;
	
	private static final int DEFALT_CAPACITY = 10 ;
	
	
	public SxtArrayList04(){
		elementData = new Object[DEFALT_CAPACITY]; 
	}
	
	public SxtArrayList04(int  capacity) {
		
		if(capacity<0){
			throw  new  RuntimeException("容器的容量不能为负数");
		} else if(capacity==0){
			elementData  = new Object[DEFALT_CAPACITY];
		}else{
			elementData  = new Object[capacity];
		}
		
		
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
		SxtArrayList04  s1 = new SxtArrayList04();
		
		for(int i=0;i<40;i++){
			s1.add("gao"+i);
		}
		
		s1.set("dddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(39));

	}
	
	
}
