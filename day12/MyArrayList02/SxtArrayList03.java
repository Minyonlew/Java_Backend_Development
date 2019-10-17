package day12.byHand.ArrayList;
import java.util.ArrayList;

/**
 * �����������ݹ���
 *
 *
 */
public class SxtArrayList03<E> {
	
	private Object[]  elementData;
	private int  size;
	
	private static final int DEFALT_CAPACITY = 10 ;
	
	
	public SxtArrayList03(){
		elementData = new Object[DEFALT_CAPACITY]; 
	}
	
	public SxtArrayList03(int  capacity) {
		elementData  = new Object[capacity];
		ArrayList l;
	}
	
	public  void  add(E  element){
		
		//ʲôʱ�����ݣ���
		if(size == elementData.length){
			//���ݲ���
			Object[]  newArray  =  new Object[elementData.length+(elementData.length>>1)];  //10-->10+10/2
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); 
			elementData = newArray;
		}
		
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
		SxtArrayList03  s1 = new SxtArrayList03();
		
		for(int i=0;i<400;i++){
			s1.add("gao"+i);
		}
		
		
		System.out.println(s1);
		

	}
	
	
}
