package com.bjsxt.pojo;

public class Person {
	public String pname;
	protected  int page;
	String pfav;
	private String psex;
	
	
	

	public String pHi(){
		return "Hi reflect";
	}
	
	public String pHi(int num,String str){
		return str+num;
	}
	
	protected void pHello(){
		System.out.println("Person.pHello(protected)");
	}
	
	private void pHello1(){
		System.out.println("Person.pHello1(private)");
		
		
	}
	void pHello2(){
		System.out.println("Person.pHello2(default)");
	}	
}





































