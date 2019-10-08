package auto;

public class Bus extends Auto{
	private int seat;
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(String carId, String brand, int seat) {
		super(carId, brand);
		this.seat = seat;
	}

	@Override
	public int countMoney(int day) {
		if (seat <= 16) {
			return 900*day;
		}else {
			return 1500*day;
		}
		
	}
	
	
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	

}
