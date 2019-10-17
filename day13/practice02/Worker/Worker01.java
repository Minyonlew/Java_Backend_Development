package day13.practice02.Worker;

public class Worker01 implements Comparable<Worker01> {

	private String name;
	private int age;
	private double salary;
	public Worker01() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worker01(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Worker01 [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}
	
	@Override
	public int compareTo(Worker01 arg0) {
		// TODO Auto-generated method stub
		return this.age - arg0.age;
	}
	
	
	
}
