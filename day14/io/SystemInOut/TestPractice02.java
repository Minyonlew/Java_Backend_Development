package day14.io.SystemInOut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

import org.omg.CORBA.portable.OutputStream;

/*
 * 使用键盘录入(System.in)，将如下诗歌写入文件
            《虞美人》
          春花秋月何时了?
          往事知多少。

再将写入的文件读取到控制台输出System.out
*/
public class TestPractice02 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		//转化为字符流
		InputStreamReader isr = new InputStreamReader(is);
		//将字符流转换为缓冲字符流
		//用来代替System.in
		BufferedReader bfr = new BufferedReader(isr);
		
		//将输入的写进文件里
		BufferedWriter bfw = new BufferedWriter(new FileWriter("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		
		String str= null;
		
		while(!"-1".equals(str=bfr.readLine()))
		{
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}
		bfw.close();
		bfr.close();
		isr.close();
		//以上是写进文件里
		
		//读取文件里的内容
		Scanner sc = new Scanner(new File("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		//用来代替system.out输出
		BufferedWriter bfw2 = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(sc.hasNextLine()){
			
			bfw2.write(sc.nextLine());
			bfw2.newLine();
			bfw2.flush();
		}
		
		
		bfr.close();
		bfw.close();
		sc.close();

	}

}
