package test;

import java.util.Scanner;

public class Manager {
	static Scanner input = new Scanner(System.in);
	static Goods [] goods = new Goods[]{
		new Goods("�յ�", 3999.9f),
		new Goods("���ӻ�", 8888.f),
		new Goods("����", 1999.f),
		new Goods("����",199.f),
		new Goods("ϴ�»�", 4000.f)
		
	};
	public static void main(String[] args) {
		login();
	}
	public static void login() {
		System.out.println("�������û���");
		String userName = input.next();
		System.out.println("����������");
		String psw = input.next();
		if (userName.equals(psw)) {
			System.out.println("��½�ɹ�");
			show();
		}else {
			System.out.println("�û��������������벻��ȷ");
		}
		
	}
	
	public static void show() {
		System.out.println("**************��ӭʹ�þ����̳�*********************");
		System.out.println("���\t��Ʒ��\t�۸�");
		for (int i = 0; i < goods.length; i++) {
			System.out.print(i+1+"\t");
			System.out.println(goods[i]);
		}
		System.out.println("**************��ӭѡ��******************");
		System.out.println("��������Ҫ��������Ʒ�ı��");
		int no = input.nextInt();
		Goods gs = goods[no-1];
		System.out.println("��������Ҫ��������Ʒ������");
		int count = input.nextInt();
		float money = gs.getPrice()*count;
		System.out.println("�븶��:"+change(money));
		
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
