package com.bjsxt.pojo;

public class User {
	private String uname;
	private String ufav;
	
	
	
	
	
	public String getUfav() {
		return ufav;
	}
	public void setUfav(String ufav) {
		this.ufav = ufav;
	}
	public User(String uname, String ufav) {
		super();
		this.uname = uname;
		this.ufav = ufav;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	//����û��İ���
	public void operFav(String fav){
		if("LOL".equals(fav)){
			ufav=fav;
			System.out.println("����������");
		}else if("д����".equals(fav)){
			ufav=fav;
			System.out.println("������ø���");
		}else{
			System.out.println("���޴˰���");
		}	
	}
	
	//��ֵ����
	public int operNum(int a,int b){
		return a+b;
	}
	
	
	
	
	
	
	
}
