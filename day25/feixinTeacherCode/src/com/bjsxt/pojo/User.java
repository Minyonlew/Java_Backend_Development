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
	
	
	//输出用户的爱好
	public void operFav(String fav){
		if("LOL".equals(fav)){
			ufav=fav;
			System.out.println("这个爱好真棒");
		}else if("写代码".equals(fav)){
			ufav=fav;
			System.out.println("这个爱好更棒");
		}else{
			System.out.println("查无此爱好");
		}	
	}
	
	//数值运算
	public int operNum(int a,int b){
		return a+b;
	}
	
	
	
	
	
	
	
}
