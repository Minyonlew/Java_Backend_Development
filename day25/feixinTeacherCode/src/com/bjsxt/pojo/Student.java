package com.bjsxt.pojo;

public class Student extends Person{
	//声明实体类的属性
	public String sname="张三";
	protected int sage;
	
	public String getSsex() {
		return ssex;
	}


	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	String sfav;
	private String ssex="男";
	public static int money=1000;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String ssex){
		this.ssex=ssex;
	}
	
	
	public int sHi(){
		return 2;
	}
	
	public String sHi(int num,String str){
		System.out.println(str+num);
		return str+num;
	}
	
	
	public static String sHi(String str){
		System.out.println(str);
		return str;
	}
	
	protected void sHello(){
		System.out.println("Student.sHello(protected)");
	}
	
	private void sHello1(){
		System.out.println("Student.sHello1(private)");
		
		
	}
	void sHello2(){
		System.out.println("Student.sHello2(default)");
	}	
}
