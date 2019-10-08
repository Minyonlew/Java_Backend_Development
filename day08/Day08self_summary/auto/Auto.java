package auto;

public abstract class Auto {
	private String CarId;
	private String brand;
	public Auto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auto(String carId, String brand) {
		super();
		CarId = carId;
		this.brand = brand;
	}

	public abstract int countMoney(int day);
	public String getCarId() {
		return CarId;
	}
	public void setCarId(String carId) {
		CarId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
}
