package day14.io.FileInOutStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

	public static void main(String[] args) throws IOException {
		//��1����ܵ�  ��������Դ��Ŀ�ĵ�
		FileInputStream fis = new FileInputStream("G:/0ASXTJAVA/Code/IOTest/1.txt");
		
		//��2�� ��ȡ����
		//һ�ζ�һ���ֽ�
//		int n = -1;
//		while((n=fis.read())!=-1){   //read() ���أ���һ�������ֽڣ�����ѵ����ļ�ĩβ���򷵻� -1��
//			System.out.println((char)n);
//			
//		}
		
//		//һ���Խ��ļ��������ֽڶ�����һ���ֽ�������
//		byte [] bs = new byte[1024];
//		int len = fis.read(bs);  //read(byte[] b)  ���أ����뻺�������ֽ������������Ϊ�Ѿ������ļ�ĩβ��û�и�������ݣ��򷵻� -1
//		System.out.println(new String(bs,0,len));
		
		/*
		 * �����е�һЩ���ݶ����ֽ�������
		 * ���ֽ��������ж������ֽ�
		 * ���ҽ��������ֽ� ���������д��±�Ϊ3��λ�ÿ�ʼ���
		 * */
		byte [] bs2 = new byte[1024];
		//����ȥn���ֽڲ���ȡ
		fis.skip(3);
		int len2 = fis.read(bs2, 3, 2);
		System.out.println(new String(bs2,3,len2));
		
//		//��ȡ�ı��ļ�������
//		int len3 = 0;
//		while((len3=fis.read())!=-1)
//		{
//			//...
//		}
		
		
		//�ر�������
		fis.close();
		
		
		
	}

}
