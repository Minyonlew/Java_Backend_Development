package day09.interfaceTest;

public class Mouse implements UsbInterface{

	@Override
	public void func() {
		System.out.println("鼠标可以用了");
		
	}
}
