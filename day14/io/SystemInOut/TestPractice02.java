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
 * ʹ�ü���¼��(System.in)��������ʫ��д���ļ�
            �������ˡ�
          �������º�ʱ��?
          ����֪���١�

�ٽ�д����ļ���ȡ������̨���System.out
*/
public class TestPractice02 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		//ת��Ϊ�ַ���
		InputStreamReader isr = new InputStreamReader(is);
		//���ַ���ת��Ϊ�����ַ���
		//��������System.in
		BufferedReader bfr = new BufferedReader(isr);
		
		//�������д���ļ���
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
		//������д���ļ���
		
		//��ȡ�ļ��������
		Scanner sc = new Scanner(new File("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		//��������system.out���
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
