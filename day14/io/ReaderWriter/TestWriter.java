package day14.io.ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("G:/0ASXTJAVA/Code/IOTest/2.txt");

		fw.write("hi���");
		
		//ˢ�»�����
		fw.flush();
		
		fw.close();
	}

}
