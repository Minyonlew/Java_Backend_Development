package auto;

public class Car extends Auto {
	private String type;

	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String carId, String brand, String type) {
		super(carId, brand);
		this.type = type;
	}


//	小汽车的子类重写父类计算租金的方法
	@Override
	public int countMoney(int day) {
		if ("550i".equals(type)) {
			return 600*day;
		}else {
			return 800*day;
		}
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
