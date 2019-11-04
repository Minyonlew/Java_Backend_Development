package com.bjsxt.testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bjsxt.pojo.Person;
import com.bjsxt.pojo.Student;

/**
 * ��ͳ��ʽ:
 * 		ֻ�ܾ�̬�Ĵ���java����
 * ������ص�:
 * 		ʵ����java����Ķ�̬����.
 * �����ȱ��:
 * 		����Ĵ���Ч�ʵ�,Ӱ���������.
 * ����ʹ��:
 * 		����ʹ�ͳ��ϵķ�ʽ
 * ����ѧϰ:
 * 		��ȡ�����
 * 			Class.forName("���ȫ�޶�·��");		���������ʹ�ý϶�
 * 			����.class							�������䷽���϶�
 * 			������.getClass()						�������䷽���϶�
 * 			ע��:
 * 				һ����ֻ��һ�������
 * 		��������:
 * 			��ȡ�����
 * 			��ȡ������
 * 				getFields()						��ȡ���еĹ����ֶΰ�������			����Field[]
 * 				getDeclaredFields()				��ȡ�����������ֶ�(����������)		����Field[]
 * 				getField(String name)			��ȡָ���Ĺ����ֶΰ�������			����Field
 * 				getDeclaredField(String name)	��ȡָ�����������ֶ�(����������)		����Field
 * 			����������
 * 				������̬����
 * 					�����Զ���.get(null) 			���ؾ�̬���Ե�ֵ
 * 					�����Զ���.set(null,"ֵ")		��ֵ
 * 				�����Ǿ�̬����
 * 					�����Զ���.get(Object obj);
 * 					�����Զ���.set(Object obj,"ֵ");
 * 		��������:
 * 			��ȡ�����
 * 			��ȡ��������
 * 				getMethods()								��ȡ���еĹ���������������
 * 				getDeclaredMethods()						��ȡ���������ķ�������������
 * 				getMethod(String name,Class...cla)			��ȡָ���Ĺ�������
 * 						String name  	��ʾ������
 * 						Class...cla  	��ʾ�������յĲ������͵������
 * 				getDeclaredMethod(String name,Class...cla)	��ȡָ������������
 * 						String name  	��ʾ������
 * 						Class...cla  	��ʾ�������յĲ������͵������
 * 			��������
 * 				��̬����
 * 					��������.invoke(null,����ֵ1,����ֵ2,....);
 * 					��������.invoke(null,null);
 * 				�Ǿ�̬����
 * 					Object obj=cla.newInstance();
 * 					��������.invoke(obj,����ֵ1,����ֵ2,....)
 * 					��������.invoke(obj,null)
 * 			����������:
 * 				��ȡ�����
 * 				��ȡ����������
 * 				��������������
 * @author MyPC
 */
public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		//������������� 
			//operField();
		//��������෽��
			//operMethod();
		//�������������
			operConstructor();
	}
	//�������������
	private static void operConstructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//��ȡ�����
		Class cla=Class.forName("com.bjsxt.pojo.Student");
		//��ȡ��������������
			Constructor[] cs=cla.getConstructors();
			for(Constructor c:cs){
				System.out.println(c.getName());
			}
		//��ȡָ���Ĺ�����
			Constructor c=cla.getConstructor(String.class);
		//����ʵ��������
			Object obj=	c.newInstance("Ů");
			System.out.println(cla.getDeclaredMethod("getSsex",null).invoke(obj,null));
			
			Student s=new Student("Ů");
			System.out.println(s.getSsex());
			
	}
	//��������
	private static void operMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//��ȡ�����
		Class cla=Class.forName("com.bjsxt.pojo.Student");
		//��ȡ�෽������
			//��ȡ���еĹ���������������
			Method[] ms=cla.getMethods();
			for(Method m:ms){
				System.out.println("��ȡ������--->"+m.getName());
			}
			System.out.println("************************************");
			//��ȡ���������ķ�������������
			Method[] ms2=cla.getDeclaredMethods();
			for(Method m:ms2){
				System.out.println("��ȡ������--->"+m.getName());
			}
			//��ȡָ���Ĺ���������������
				Method m=cla.getMethod("pHi", int.class,String.class);
				System.out.println(m.getReturnType());
			//��ȡָ���������ķ���,����������
				Method m2=cla.getDeclaredMethod("sHello",null);
				System.out.println(m2.getName());
			//ִ�з���
				//��̬����
					Method m3=cla.getDeclaredMethod("sHi",String.class);
					m3.invoke(null, "����ѧ�˷���,�ÿ���");
				//�Ǿ�̬
					Method m4=cla.getDeclaredMethod("sHi",int.class,String.class);
					m4.invoke(cla.newInstance(), 3,"���书�ܺ�ǿ��");
	}

	public static void operField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		//��ȡ�����
		Class cla=Class.forName("com.bjsxt.pojo.Student");
		//��ȡ����������
			//��ȡ�༰�丸��Ĺ����ֶ�
				Field[] fds = cla.getFields();
				for(Field f:fds){
					System.out.println("��ȡ������------>"+f.getName());
					System.out.println("��ȡ���η�------>"+f.getModifiers());
					System.out.println("��ȡ����------>"+f.getType());//���ص������͵�Class����
				}
				System.out.println("******************************");
			//��ȡ�������������ֶ�
				Field[] fds2=cla.getDeclaredFields();
				for(Field f:fds2){
					System.out.println("��ȡ������----->"+f.getName());
					System.out.println("��ȡ���η�------>"+f.getModifiers());
					System.out.println("��ȡ����------>"+f.getType());//���ص������͵�Class����
				}
				System.out.println("******************************");
			//��ȡָ�����ֶ�
				Field f=cla.getField("pname");//ָ����ȡ�༰�丸��Ĺ����ֶ�
				System.out.println(f.getName());
				Field f2=cla.getDeclaredField("money");//ָ����ȡ��������ֶ�
				System.out.println(f2.getName());
				Field f3=cla.getSuperclass().getDeclaredField("pname");//ָ����ȡ�����������ֶ�
				System.out.println(f3.getName());
			//�����ֶ�ֵ
				System.out.println("************������̬�ֶ�**********************");
				//������̬����
				Field fs=cla.getDeclaredField("money");
				fs.set(null,2000);
				System.out.println(fs.get(null));
				System.out.println("************�����Ǿ�̬�ֶ�**********************");
				//�����Ǿ�̬����
				Field fd=cla.getDeclaredField("sname");
				Object obj=cla.newInstance();
				fd.set(obj, "����");
				System.out.println(fd.get(obj));	
				//�����������˽�л�����(�˽�)
				Field fd2=cla.getDeclaredField("ssex");
				fd2.setAccessible(true);//��������,����˽�л�����,����ȫ
				Object obj2=cla.newInstance();//��ȡʵ��������
				System.out.println(fd2.get(obj2));
				
	}
	//�����ȡ�����
	public static void getCla() throws ClassNotFoundException{
				//��ͳ��ʽ
				Person p=new Person();
				//���䴴�������
					//��һ�ַ�ʽ--->���������
					 Class cla01=Class.forName("com.bjsxt.pojo.Person");
					//�ڶ��ַ�ʽ---->���õײ�ʹ�÷����װ�ķ���
					 Class cla02=Person.class;
					//�����ַ�ʽ---->���õײ�ʹ�÷����װ�ķ���
					 Class cla03=new Person().getClass();
					 System.out.println(cla01==cla02);
					 
					 System.out.println("��ȡ�����İ���---->"+cla01.getPackage());
					 System.out.println("��ȡ������η�----->"+cla01.getModifiers());
					 System.out.println("��ȡ�������(ȫ�޶�)----->"+cla01.getName());
					 System.out.println("��ȡ�������(����)----->"+cla01.getSimpleName());
					 System.out.println("��ȡ��ĸ���������----->"+cla01.getSuperclass());	
	}
}
//����� Student��Class���� �ö����з����Student��������Ϣ
//��Ķ���	Student��ʵ�������� new Student()
//�������ĵ������   new  ZhangSan().cake
//�ѵ������--->����  Field.get(new Lisi())







