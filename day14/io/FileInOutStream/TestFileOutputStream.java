package day14.io.FileInOutStream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {

	public static void main(String[] args) throws IOException {
		//����һ�������ļ����ֽ������
		//�����Ĳ���ֵ�������ǹ涨   �Ƿ����ļ�ԭ�е����ݺ���׷������
		FileOutputStream fos = new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/1.txt",true);
		
		//���ֽ����������д����   ��������д���ļ�������Ĭ��ֱ�Ӹ����ļ���ԭ�е�����
		//fos.write(98);  
		
		//һ��д��һ���ֽ�����
		//fos.write("�Һ��������".getBytes());
		//���ֽ������е�һ����д���ļ�
		fos.write("�Һ��������".getBytes(),2,4);  //���ļ������� �� ����
		
	}

}
