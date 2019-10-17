package day14.io.File;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) throws IOException {
		
		//通过File的构造方法创建一个对象
		File file = new File("G:/0ASXTJAVA/Code/IOTest/test.jpg");
		
		//判断路径指向的文件是否存在
		if(!file.exists())
		{
			//创建一个新文件
			file.createNewFile();
			//创建一个目录 ，前提要求所要创建的目录的路径必须存在，如果路径不存在则创建失败
			//file.mkdir();
			
			//创建一个目录，如果路径不存在，则将路径所需要的目录一起创建出来
			file.mkdirs();
		}
		
		//判断文件可读可写
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		
		//获取文件的绝对路径
		System.out.println(file.getAbsolutePath());
		//获取文件的相对路径
		System.out.println(file.getCanonicalPath());
		//获取文件的长度
		System.out.println(file.length());
		//构造一个表示此抽象路径名的 file: URI
		System.out.println(file.toURI());
	}

}
