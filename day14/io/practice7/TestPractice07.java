package day14.io.practice7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*��1��ʹ��File��ķ���ȥ����һ���ı��ļ����Ƚ����ж�
        ���û���򴴽�������������ɾ���ٴ���
��2��ʹ��BufferedWriter����������   
            �������ˡ�
          �������º�ʱ��?
          ����֪���١�
          С¥��ҹ�ֶ��磬
          �ʹ��������������С�
          ��������Ӧ���ڣ�
          ֻ�����ոġ�
          �ʾ����м���
          ǡ��һ����ˮ������
         д�롾1�������������ļ�
��3���ٽ���2����д����ļ���ȡ������̨���

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
