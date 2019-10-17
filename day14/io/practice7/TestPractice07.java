package day14.io.practice7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*【1】使用File类的方法去创建一个文本文件，先进行判断
        如果没有则创建，如有有则先删除再创建
【2】使用BufferedWriter将如下文字   
            《虞美人》
          春花秋月何时了?
          往事知多少。
          小楼昨夜又东风，
          故国不堪回首月明中。
          雕栏玉砌应犹在，
          只是朱颜改。
          问君能有几多愁？
          恰似一江春水向东流。
         写入【1】中所创建的文件
【3】再将【2】中写入的文件读取到控制台输出

 * 
 * */
public class TestPractice07 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("G:/0ASXTJAVA/Code/IOTest02/2.txt");
		if(f.exists())
		{
			f.delete();
		}
		f.createNewFile();
		

		
		FileWriter fw = new FileWriter("G:/0ASXTJAVA/Code/IOTest02/2.txt");
		BufferedWriter bfw = new BufferedWriter(fw);
		Scanner sc = new Scanner(System.in);
		
		String str = null;
		while(!"-1".equals(str=sc.next()))
		{
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}
		
		bfw.close();
//		
		
		FileReader fr = new FileReader("G:/0ASXTJAVA/Code/IOTest02/2.txt");
		BufferedReader bfr = new BufferedReader(fr);
		String str2 =null;
		while((str2=bfr.readLine())!=null)
		{
			System.out.println(str2);
		}
		
	}

}
