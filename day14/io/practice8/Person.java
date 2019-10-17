package day14.io.practice8;
/*
【1】创建User类，包含以下属性name:String,age:int,gender String,重写toString方法显示对象的信息
【2】使用BufferedWriter写入文件以“,”分隔
【3】使用BufferedReader读取信息并进行分割，还原成对象，调用对象的toString方法输出对象的信息
 * */

public class Person {

	private String name ;
	private int age;
	private String  gender;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return  name + "," + age + "," + gender;
	}
	
	
	
	
}
