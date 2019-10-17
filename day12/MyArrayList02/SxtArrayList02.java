package day12.byHand.ArrayList;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加泛型
 *
 *
 */
public class SxtArrayList02<E> {
	
	private Object[]  elementData;
	private int  size;
	
	private static final int DEFALT_CAPACITY = 10 ;
	
	
	public SxtArrayList02(){
		elementData = new Object[DEFALT_CAPACITY]; 
	}
	
	public SxtArrayList02(int  capacity) {
		elementData  = new Object[capacity];
	}
	
	public  void  add(E  element){
		elementData[size++] = element;
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
		SxtArrayList02  s1 = new SxtArrayList02(20);
		s1.add("aa");
		s1.add("bb");
		
		System.out.println(s1);
		

	}
	
	
}
