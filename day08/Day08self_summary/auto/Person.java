package auto;

public class Person {
	private String name;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name) {
		super();
		this.name = name;
	}
	
	public int  countMoney(Auto[]as,int day) {
		int count = 0;
		for (Auto auto : as) {
			count += auto.countMoney(day);
		}
		return count;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
