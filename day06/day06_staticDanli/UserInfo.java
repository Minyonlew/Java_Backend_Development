package day06_staticDanli;

import java.util.Scanner;

public class UserInfo {

	 String userName;
	 String psw;
	 
	 //����һ��UseInfo ��̬����
	 
	 static UserInfo info = null;
	 
	 //����һ����̬������ ȷ�����Ա�������ȷ��������ͬһ������
	 public static UserInfo getUserInfo() {
		 
		 if (info == null) {
				info = new UserInfo();
				Scanner input = new Scanner(System.in);
				System.out.println("�������û���");
				String name = input.next();
				System.out.println("����������");
				String psw = input.next();
				info.userName = name;
				info.psw = psw;
				
			}
			
			return info;
	 }

}
