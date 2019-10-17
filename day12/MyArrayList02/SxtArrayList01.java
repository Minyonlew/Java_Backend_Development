package day12.byHand.ArrayList;

/**
 * �Զ���ʵ��һ��ArrayList�����ײ�ԭ��
 * 
 *
 */
public class SxtArrayList01 {
	
	private Object[]  elementData;
	private int  size;
	
	private static final int DEFALT_CAPACITY = 10 ;
	
	
	public SxtArrayList01(){
		elementData = new Object[DEFALT_CAPACITY]; 
	}
	
	public SxtArrayList01(int  capacity) {
		elementData  = new Object[capacity];
	}
	
	public  void  add(Object  obj){
		elementData[size++] = obj;
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
		SxtArrayList01  s1 = new SxtArrayList01(20);
		s1.add("aa");
		s1.add("bb");
		
		System.out.println(s1);
		
	}
	
	
}
