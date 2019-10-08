package auto;

public class Test {
	public static void main(String[] args) {
		Person xiaoming = new Person("小明");
		Auto [] as = {new Car("粤a 88888", "宝马", "550i"),
				new Bus("粤A 66666", "金杯", 25),new Truck("粤A 99999","东风", 20)};
		int money = xiaoming.countMoney(as, 3);
		System.out.println(money);
		
		
	}
}
