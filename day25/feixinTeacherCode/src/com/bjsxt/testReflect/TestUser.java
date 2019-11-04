package com.bjsxt.testReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bjsxt.pojo.User;

public class TestUser {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//��ͳ��ʽ
			operTr();
		System.out.println("********************************");
		//���䷽ʽ
			operReflect();
	}
	private static void operReflect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//��ȡ�����
		Class cla=Class.forName("com.bjsxt.pojo.User");
		//��ȡʵ��������
		Object obj=cla.newInstance();
		//�����Ը�ֵ,���÷���
		Method m=cla.getDeclaredMethod("setUname", String.class);
		Method m2=cla.getDeclaredMethod("setUfav", String.class);
		m.invoke(obj, "����");
		m2.invoke(obj, "д����");
		//���÷���
		Method m3=cla.getDeclaredMethod("getUname",null);
		Method m4=cla.getDeclaredMethod("getUfav", null);
		System.out.println(m3.invoke(obj, null)+":"+m4.invoke(obj, null));
		Method m5=cla.getDeclaredMethod("operFav", String.class);
		m5.invoke(obj,m4.invoke(obj, null));
		
	}
	//��ͳ��ʽ
	private static void operTr() {
		User u=new User();
		u.setUname("����");
		u.setUfav("д����");
		System.out.println(u.getUname()+":"+u.getUfav());
		u.operFav(u.getUfav());
	}
}
