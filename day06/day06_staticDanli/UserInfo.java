package day06_staticDanli;

import java.util.Scanner;

public class UserInfo {

	 String userName;
	 String psw;
	 
	 //声明一个UseInfo 静态对象
	 
	 static UserInfo info = null;
	 
	 //定义一个静态方法来 确保属性被定义且确保都来自同一个对象
	 public static UserInfo getUserInfo() {
		 
		 if (info == null) {
				info = new UserInfo();
				Scanner input = new Scanner(System.in);
				System.out.println("请输入用户名");
				String name = input.next();
				System.out.println("请输入密码");
				String psw = input.next();
				info.userName = name;
				info.psw = psw;
				
			}
			
			return info;
	 }

}
