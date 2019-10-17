package day14.io.Object;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectInOut {
	/*
	 * 1.������д�뵽�ļ������л����ٶ����������л���
	 * 2.������˳����д�뱣��һ��
	 * */

	public static void main(String[] args) throws  IOException, ClassNotFoundException {
		//д���ļ� --> ���л�
		ObjectOutputStream  oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		
		//д�� ������������ + ����
		oos.writeUTF("���");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		
		//д�����
		oos.writeObject("�ַ�������");
		Employee emp = new Employee("���",2000);
		oos.writeObject(emp);
		oos.flush();
		oos.close();
		
		// ��ȡ -->�����л�
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		// ˳����д��һ��
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		// ��������ݻ�ԭ
		Object str = ois.readObject();
		Object employee2 = ois.readObject();

		if (str instanceof String) {
			String strObj = (String) str;
			System.out.println(strObj);
		}
		
		if (employee2 instanceof Employee) {
			Employee empObj = (Employee) employee2;
			System.out.println(empObj.getName() + "-->" + empObj.getSalary());
		}
		ois.close();
		
		
		
	}
	
		
	

}
