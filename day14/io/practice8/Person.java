package day14.io.practice8;
/*
��1������User�࣬������������name:String,age:int,gender String,��дtoString������ʾ�������Ϣ
��2��ʹ��BufferedWriterд���ļ��ԡ�,���ָ�
��3��ʹ��BufferedReader��ȡ��Ϣ�����зָ��ԭ�ɶ��󣬵��ö����toString��������������Ϣ
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
