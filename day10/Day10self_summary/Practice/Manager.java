package test;

import java.util.Scanner;

public class Manager {
	static Scanner input = new Scanner(System.in);
	static Goods [] goods = new Goods[]{
		new Goods("空调", 3999.9f),
		new Goods("电视机", 8888.f),
		new Goods("冰箱", 1999.f),
		new Goods("风扇",199.f),
		new Goods("洗衣机", 4000.f)
		
	};
	public static void main(String[] args) {
		login();
	}
	public static void login() {
		System.out.println("请输入用户名");
		String userName = input.next();
		System.out.println("请输入密码");
		String psw = input.next();
		if (userName.equals(psw)) {
			System.out.println("登陆成功");
			show();
		}else {
			System.out.println("用户名或者密码输入不正确");
		}
		
	}
	
	public static void show() {
		System.out.println("**************欢迎使用京东商城*********************");
		System.out.println("序号\t商品名\t价格");
		for (int i = 0; i < goods.length; i++) {
			System.out.print(i+1+"\t");
			System.out.println(goods[i]);
		}
		System.out.println("**************欢迎选购******************");
		System.out.println("请输入索要批发的商品的编号");
		int no = input.nextInt();
		Goods gs = goods[no-1];
		System.out.println("请输入索要批发的商品的数量");
		int count = input.nextInt();
		float money = gs.getPrice()*count;
		System.out.println("请付款:"+change(money));
		
	}
	
	public static String  change(float money) {
		StringBuffer sb = new StringBuffer(money + "");
		int index = sb.indexOf(".");
		for (int i = index-3; i > 0; i-=3) {
			sb.insert( i,",");
		}
		return sb.toString();
	}
}
