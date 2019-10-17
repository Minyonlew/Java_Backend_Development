package day14.io.FileInOutStream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {

	public static void main(String[] args) throws IOException {
		//创建一个操作文件的字节输出流
		//参数的布尔值的作用是规定   是否在文件原有的数据后面追加内容
		FileOutputStream fos = new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/1.txt",true);
		
		//向字节输出流里面写数据   数据最终写入文件，并且默认直接覆盖文件中原有的数据
		//fos.write(98);  
		
		//一次写入一个字节数组
		//fos.write("我好你好他好".getBytes());
		//将字节数组中的一部分写入文件
		fos.write("我好你好他好".getBytes(),2,4);  //向文件输入了 ： 好你
		
	}

}
