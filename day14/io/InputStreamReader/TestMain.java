package day14.io.InputStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * FileReader  只能使用系统默认的编码格式将文件中的字节读成字符
 * FileWriter  只能使用系统默认的编码格式将字符拆分成字节写入文件
 * 
 * 如果使用的编码格式不是系统默认的编码格式   
 * 		需要使用转换流  将读取到的字节流转换为对应编码格式的字符流
 * 		需要使用转换流  将字符流按照对应的 编码格式转换为字节流保存到文件
 * 
 * 		InputStreamReader
 * 		使用指定的编码格式，将文件中的字节读成字符
 * 		OutputStreamWriter
 * 		使用指定的编码格式  将要输出的字符 拆分成字节   写入文件
 * */

public class TestMain {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("G:/0ASXTJAVA/Code/IOTest/3.txt"),"UTF-8");
		int len = 0;
		while((len=isr.read())!=-1){
			System.out.println((char)len);
		}
		isr.close();
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/3.txt"));
		osw.write("你好");
		osw.flush();
		osw.close();
	
	}

}
