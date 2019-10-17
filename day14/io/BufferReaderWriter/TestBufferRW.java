package day14.io.BufferReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferRW {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("G:/0ASXTJAVA/Code/IOTest/1.txt");
		FileWriter fw = new FileWriter("G:/0ASXTJAVA/Code/IOTest/2.txt");
		
		BufferedReader bfr = new BufferedReader(fr);
		BufferedWriter bfw = new BufferedWriter(fw);
		
		String str = null;
		
		while((str = bfr.readLine())!=null)
		{
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}

		
		
		bfw.close();
		bfr.close();
		fw.close();
		fr.close();

	}

}
