package day14.io.ReaderWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args) throws IOException {
		
		
		FileReader fr = new FileReader("G:/0ASXTJAVA/Code/IOTest/1.txt");
		
		//char c = (char) fr.read();
		char [] ca= new char[1024];
		
		int len = fr.read(ca);
		
		
		System.out.println(ca);
		
		fr.close();
	}

}
