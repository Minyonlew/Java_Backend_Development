package my.day07.encapsulation01;
/*
 * 
 * 测试封装		
 * 
 * 
 * */
public class TestEnca01 {   //每个Class 文件只能有一个类用public 修饰 。其他都是default（默认）
	
	public static void main(String[] args) {
		Human h = new Human();
		
		//h.age = 13;    //私有的成员变量只能在本类中使用，不能再其他类（子类都不行）
		
		h.name = "hi";   //default 默认的成员变量可以在本包中的所有类中使用
		
		h.height =0;     //protected 可以被本类、本包其他类、以及其他包的子类使用
	}

}




class Boy extends Human{
	
	void sayHello(){
		//System.out.println(age);//私有的成员变量只能在本类中使用，不能再其他类（子类都不行）
		
	}

}