package day14.io.Object;

import java.io.Serializable;



public class Employee implements Serializable{

	private transient String name ;   //屏蔽不想被序列化的属性
	private double salary;
	
	public Employee() {
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
