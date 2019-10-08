package my.day07.encapsulation01;

public class Human{          //公开的 不管是包外还是包内都可以调用
	
	private int age;         //私有属性
	String name ;            //默认（default）
	protected int height ;   //保护
	
	void sayAage(){
		System.out.println(age);//私有的成员变量只能在本类中使用，不能再其他类（子类都不行）
	}
	
}