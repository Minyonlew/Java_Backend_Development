package day14.io.InputStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * FileReader  ֻ��ʹ��ϵͳĬ�ϵı����ʽ���ļ��е��ֽڶ����ַ�
 * FileWriter  ֻ��ʹ��ϵͳĬ�ϵı����ʽ���ַ���ֳ��ֽ�д���ļ�
 * 
 * ���ʹ�õı����ʽ����ϵͳĬ�ϵı����ʽ   
 * 		��Ҫʹ��ת����  ����ȡ�����ֽ���ת��Ϊ��Ӧ�����ʽ���ַ���
 * 		��Ҫʹ��ת����  ���ַ������ն�Ӧ�� �����ʽת��Ϊ�ֽ������浽�ļ�
 * 
 * 		InputStreamReader
 * 		ʹ��ָ���ı����ʽ�����ļ��е��ֽڶ����ַ�
 * 		OutputStreamWriter
 * 		ʹ��ָ���ı����ʽ  ��Ҫ������ַ� ��ֳ��ֽ�   д���ļ�
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
		osw.write("���");
		osw.flush();
		osw.close();
	
	}

}
