package day14.io.practice8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(new Person("Íú²Æ1",20,"ÄÐ"));
		list.add(new Person("Íú²Æ2",20,"ÄÐ"));
		list.add(new Person("Íú²Æ3",20,"ÄÐ"));
		list.add(new Person("Íú²Æ4",20,"ÄÐ"));
		
		BufferedWriter bfw = new BufferedWriter(new FileWriter("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			bfw.write(p.toString());
			bfw.newLine();
			bfw.flush();
		}
		bfw.close();
		
		BufferedReader bfr = new BufferedReader(new FileReader("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		String str = null;
		while((str=bfr.readLine())!=null)
		{
			String [] strs = str.split(",");
			Person p = new Person(strs[0],new Integer(strs[1]),strs[2]);
			System.out.println(p);
		}
		bfr.close();

	}

}
