package auto;

public class Test {
	public static void main(String[] args) {
		Person xiaoming = new Person("С��");
		Auto [] as = {new Car("��a 88888", "����", "550i"),
				new Bus("��A 66666", "��", 25),new Truck("��A 99999","����", 20)};
		int money = xiaoming.countMoney(as, 3);
		System.out.println(money);
		
		
	}
}
