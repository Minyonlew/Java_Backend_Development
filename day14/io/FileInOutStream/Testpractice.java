package day14.io.FileInOutStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Testpractice {
	/*复制图片
	 * 将G:\盘指定的图片复制到当前项目中
	 * 需求分析：
	 * 使用字节的输入流FileInputStream读取字节
	 * 使用字节的输出流FileOutputStream写入文件
	 * */

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("G:/0ASXTJAVA/Code/IOTest/test.jpg");
		FileOutputStream fos =new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/test02.jpg");
		
		int len = 0;
		byte []bs = new byte[1024];
		while((len=fis.read(bs))!=-1)
		{
			fos.write(bs, 0, len);

		}
		fos.close();
		fis.close();
	}

}
