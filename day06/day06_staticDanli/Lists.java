package day06_staticDanli;

public class Lists {

	public static void  list() {
		
		System.out.println("�б�");
		
		UserInfo info = UserInfo.getUserInfo();
		System.out.println(info.userName+info.psw);
		Pay.pay();
	}
}
