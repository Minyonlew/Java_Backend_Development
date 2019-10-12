package day09.interfaceTest;

public class Fan implements UsbInterface{

	@Override
	public void func() {
		
		System.out.println("风扇可以用了");
		
	}

}
