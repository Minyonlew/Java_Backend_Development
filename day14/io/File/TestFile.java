package day14.io.File;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) throws IOException {
		
		//ͨ��File�Ĺ��췽������һ������
		File file = new File("G:/0ASXTJAVA/Code/IOTest/test.jpg");
		
		//�ж�·��ָ����ļ��Ƿ����
		if(!file.exists())
		{
			//����һ�����ļ�
			file.createNewFile();
			//����һ��Ŀ¼ ��ǰ��Ҫ����Ҫ������Ŀ¼��·��������ڣ����·���������򴴽�ʧ��
			//file.mkdir();
			
			//����һ��Ŀ¼�����·�������ڣ���·������Ҫ��Ŀ¼һ�𴴽�����
			file.mkdirs();
		}
		
		//�ж��ļ��ɶ���д
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		
		//��ȡ�ļ��ľ���·��
		System.out.println(file.getAbsolutePath());
		//��ȡ�ļ������·��
		System.out.println(file.getCanonicalPath());
		//��ȡ�ļ��ĳ���
		System.out.println(file.length());
		//����һ����ʾ�˳���·������ file: URI
		System.out.println(file.toURI());
	}

}
