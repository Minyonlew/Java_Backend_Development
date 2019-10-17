package day14.io.FileInOutStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

	public static void main(String[] args) throws IOException {
		//【1】搭建管道  链接数据源和目的地
		FileInputStream fis = new FileInputStream("G:/0ASXTJAVA/Code/IOTest/1.txt");
		
		//【2】 读取数据
		//一次读一个字节
//		int n = -1;
//		while((n=fis.read())!=-1){   //read() 返回：下一个数据字节；如果已到达文件末尾，则返回 -1。
//			System.out.println((char)n);
//			
//		}
		
//		//一次性将文件中所有字节都读到一个字节数组中
//		byte [] bs = new byte[1024];
//		int len = fis.read(bs);  //read(byte[] b)  返回：读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1
//		System.out.println(new String(bs,0,len));
		
		/*
		 * 将流中的一些数据读到字节数组中
		 * 从字节输入流中读两个字节
		 * 并且将这两个字节 放在数组中从下标为3的位置开始存放
		 * */
		byte [] bs2 = new byte[1024];
		//跳过去n个字节不读取
		fis.skip(3);
		int len2 = fis.read(bs2, 3, 2);
		System.out.println(new String(bs2,3,len2));
		
//		//读取文本文件的数据
//		int len3 = 0;
//		while((len3=fis.read())!=-1)
//		{
//			//...
//		}
		
		
		//关闭流对象
		fis.close();
		
		
		
	}

}
