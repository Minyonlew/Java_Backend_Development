package com.bjsxt.testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bjsxt.pojo.Person;
import com.bjsxt.pojo.Student;

/**
 * 传统方式:
 * 		只能静态的创建java对象
 * 反射的特点:
 * 		实现了java对象的动态创建.
 * 反射的缺点:
 * 		反射的代码效率低,影响程序性能.
 * 开发使用:
 * 		反射和传统结合的方式
 * 反射学习:
 * 		获取类对象
 * 			Class.forName("类的全限定路径");		创建类对象使用较多
 * 			类名.class							操作反射方法较多
 * 			对象名.getClass()						操作反射方法较多
 * 			注意:
 * 				一个类只有一个类对象
 * 		操作属性:
 * 			获取类对象
 * 			获取类属性
 * 				getFields()						获取所有的公共字段包括父类			返回Field[]
 * 				getDeclaredFields()				获取所有声明的字段(不包括父类)		返回Field[]
 * 				getField(String name)			获取指定的公共字段包括父类			返回Field
 * 				getDeclaredField(String name)	获取指定的声明的字段(不包括父类)		返回Field
 * 			操作类属性
 * 				操作静态属性
 * 					类属性对象.get(null) 			返回静态属性的值
 * 					类属性对象.set(null,"值")		赋值
 * 				操作非静态属性
 * 					类属性对象.get(Object obj);
 * 					类属性对象.set(Object obj,"值");
 * 		操作方法:
 * 			获取类对象
 * 			获取方法对象
 * 				getMethods()								获取所有的公共方法包括父类
 * 				getDeclaredMethods()						获取所有声明的方法不包括父类
 * 				getMethod(String name,Class...cla)			获取指定的公共方法
 * 						String name  	表示方法名
 * 						Class...cla  	表示方法接收的参数类型的类对象
 * 				getDeclaredMethod(String name,Class...cla)	获取指定的声明方法
 * 						String name  	表示方法名
 * 						Class...cla  	表示方法接收的参数类型的类对象
 * 			操作方法
 * 				静态方法
 * 					方法对象.invoke(null,参数值1,参数值2,....);
 * 					方法对象.invoke(null,null);
 * 				非静态方法
 * 					Object obj=cla.newInstance();
 * 					方法对象.invoke(obj,参数值1,参数值2,....)
 * 					方法对象.invoke(obj,null)
 * 			操作构造器:
 * 				获取类对象
 * 				获取构造器对象
 * 				操作构造器对象
 * @author MyPC
 */
public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		//反射操作类属性 
			//operField();
		//反射操作类方法
			//operMethod();
		//反射操作构造器
			operConstructor();
	}
	//反射操作构造器
	private static void operConstructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//获取类对象
		Class cla=Class.forName("com.bjsxt.pojo.Student");
		//获取构造器方法对象
			Constructor[] cs=cla.getConstructors();
			for(Constructor c:cs){
				System.out.println(c.getName());
			}
		//获取指定的构造器
			Constructor c=cla.getConstructor(String.class);
		//创建实例化对象
			Object obj=	c.newInstance("女");
			System.out.println(cla.getDeclaredMethod("getSsex",null).invoke(obj,null));
			
			Student s=new Student("女");
			System.out.println(s.getSsex());
			
	}
	//操作方法
	private static void operMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//获取类对象
		Class cla=Class.forName("com.bjsxt.pojo.Student");
		//获取类方法对象
			//获取所有的公共方法包括父类
			Method[] ms=cla.getMethods();
			for(Method m:ms){
				System.out.println("获取方法名--->"+m.getName());
			}
			System.out.println("************************************");
			//获取所有声明的方法不包括父类
			Method[] ms2=cla.getDeclaredMethods();
			for(Method m:ms2){
				System.out.println("获取方法名--->"+m.getName());
			}
			//获取指定的公共方法包括父类
				Method m=cla.getMethod("pHi", int.class,String.class);
				System.out.println(m.getReturnType());
			//获取指定的声明的方法,不包括父类
				Method m2=cla.getDeclaredMethod("sHello",null);
				System.out.println(m2.getName());
			//执行方法
				//静态方法
					Method m3=cla.getDeclaredMethod("sHi",String.class);
					m3.invoke(null, "今天学了反射,好开心");
				//非静态
					Method m4=cla.getDeclaredMethod("sHi",int.class,String.class);
					m4.invoke(cla.newInstance(), 3,"反射功能好强大");
	}

	public static void operField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		//获取类对象
		Class cla=Class.forName("com.bjsxt.pojo.Student");
		//获取反射类属性
			//获取类及其父类的公共字段
				Field[] fds = cla.getFields();
				for(Field f:fds){
					System.out.println("获取属性名------>"+f.getName());
					System.out.println("获取修饰符------>"+f.getModifiers());
					System.out.println("获取类型------>"+f.getType());//返回的是类型的Class对象
				}
				System.out.println("******************************");
			//获取类声明的所有字段
				Field[] fds2=cla.getDeclaredFields();
				for(Field f:fds2){
					System.out.println("获取属性名----->"+f.getName());
					System.out.println("获取修饰符------>"+f.getModifiers());
					System.out.println("获取类型------>"+f.getType());//返回的是类型的Class对象
				}
				System.out.println("******************************");
			//获取指定的字段
				Field f=cla.getField("pname");//指定获取类及其父类的公共字段
				System.out.println(f.getName());
				Field f2=cla.getDeclaredField("money");//指定获取类的所有字段
				System.out.println(f2.getName());
				Field f3=cla.getSuperclass().getDeclaredField("pname");//指定获取父类声明的字段
				System.out.println(f3.getName());
			//操作字段值
				System.out.println("************操作静态字段**********************");
				//操作静态属性
				Field fs=cla.getDeclaredField("money");
				fs.set(null,2000);
				System.out.println(fs.get(null));
				System.out.println("************操作非静态字段**********************");
				//操作非静态属性
				Field fd=cla.getDeclaredField("sname");
				Object obj=cla.newInstance();
				fd.set(obj, "李四");
				System.out.println(fd.get(obj));	
				//暴力反射操作私有化属性(了解)
				Field fd2=cla.getDeclaredField("ssex");
				fd2.setAccessible(true);//暴力反射,操作私有化属性,不安全
				Object obj2=cla.newInstance();//获取实例化对象
				System.out.println(fd2.get(obj2));
				
	}
	//反射获取类对象
	public static void getCla() throws ClassNotFoundException{
				//传统方式
				Person p=new Person();
				//反射创建类对象
					//第一种方式--->创建类对象
					 Class cla01=Class.forName("com.bjsxt.pojo.Person");
					//第二种方式---->调用底层使用反射封装的方法
					 Class cla02=Person.class;
					//第三种方式---->调用底层使用反射封装的方法
					 Class cla03=new Person().getClass();
					 System.out.println(cla01==cla02);
					 
					 System.out.println("获取类对象的包名---->"+cla01.getPackage());
					 System.out.println("获取类的修饰符----->"+cla01.getModifiers());
					 System.out.println("获取类的名称(全限定)----->"+cla01.getName());
					 System.out.println("获取类的名称(类名)----->"+cla01.getSimpleName());
					 System.out.println("获取类的父类的类对象----->"+cla01.getSuperclass());	
	}
}
//类对象 Student的Class对象 该对象中封存了Student的所有信息
//类的对象	Student的实例化对象 new Student()
//把张三的蛋糕给我   new  ZhangSan().cake
//把蛋糕给我--->李四  Field.get(new Lisi())







