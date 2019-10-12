package day09.interfaceTest;

public class TestInterface {

	public static void main(String[] args) {
		Computer pc = new Computer();
		
		Mouse m = new Mouse();
		pc.setUsbInterface(m);
		pc.UseUsb();
		
		Fan f = new Fan();
		pc.setUsbInterface(f);
		pc.UseUsb();
		
		ULink u = new ULink();
		pc.setUsbInterface(u);
		pc.UseUsb();
		
		
		
	}

}
