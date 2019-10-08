package auto;

public class Truck extends Auto{
	private int t;

	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(String carId, String brand, int t) {
		super(carId, brand);
		this.t = t;
	}

	@Override
	public int countMoney(int day) {
		// TODO Auto-generated method stub
		return t*day*50;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}
	
}
