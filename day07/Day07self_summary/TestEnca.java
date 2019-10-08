package my.day07.encapsulation02;

import my.day07.encapsulation01.Human;

public class TestEnca {

	public static void main(String[] args) {
		Human h = new Human();
		
		//h.name = "hi"; //default （默认） 不同包不能使用
	}
	
}

class Girl extends Human {
	
	void saGood(){
		
		System.out.println(height);   //protected 可以被本类、本包其他类、以及其他包的子类使用
	}
	
}
