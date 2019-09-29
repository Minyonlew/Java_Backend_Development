package day06_staticDanli;

import java.awt.List;

public class Login {



	public static void login() {
		
		System.out.println("µÇÂ¼Ò³Ãæ");
		UserInfo info = UserInfo.getUserInfo();
		
		System.out.println(info.userName+" "+info.psw);
		
		Lists.list();
		
	}
	
}
