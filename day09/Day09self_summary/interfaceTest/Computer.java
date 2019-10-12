package day09.interfaceTest;

public class Computer {
	
	UsbInterface usbInterface ;
	
	public void UseUsb()
	{
		 usbInterface.func();
	}

	public UsbInterface getUsbInterface() {
		return usbInterface;
	}

	public void setUsbInterface(UsbInterface usbInterface) {
		this.usbInterface = usbInterface;
	}
	
	
	
}
