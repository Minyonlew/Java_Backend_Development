package day13.TreeSet.Comparable_Compartor;

public class Person implements Comparable<Person>{

	private int age ;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		return true;
	}

	@Override
	public int compareTo(Person o) {
		
		if(this.getAge()==o.getAge())
			return 0;
		else if(this.getAge()>o.getAge())
			return 1;
		else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}	
	

}
