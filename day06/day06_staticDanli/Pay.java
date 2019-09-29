package day06_staticDanli;

public class Pay {
	public static void pay() {
		System.out.println("Ö§¸¶Ò³Ãæ");
		UserInfo info = UserInfo.getUserInfo();
		System.out.println(info.userName + info.psw);
	}
	
}
