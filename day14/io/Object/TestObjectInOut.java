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
	 * 1.将对象写入到文件（序列化）再读出（反序列化）
	 * 2.读出的顺序与写入保持一致
	 * */

	public static void main(String[] args) throws  IOException, ClassNotFoundException {
		//写入文件 --> 序列化
		ObjectOutputStream  oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		
		//写入 操作数据类型 + 数据
		oos.writeUTF("你好");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		
		//写入对象
		oos.writeObject("字符串对象");
		Employee emp = new Employee("大黄",2000);
		oos.writeObject(emp);
		oos.flush();
		oos.close();
		
		// 读取 -->反序列化
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		// 顺序与写出一致
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		// 对象的数据还原
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
