package day10.Commonly_used_class;

public class TestInteger {

	public static void main(String[] args) {
		
		//将基本数据类型的变量转换为对应包装类的对象
		int in = 10;
		Integer it = new Integer(in);
		//在java1.5版本以后   基本数据类型和他的包装类的类型之间可以自动转换
		//我们称之为    自动拆装箱
		//基本数据类型可以直接转换为引用数据类型的对象  称之为自动装箱 
		Integer it02 = 10;
		int it02_2 = it02;
		
				
		//******************将字符串转为 Integer *********************************
		String str01 = "270";
		Integer ig2 = new Integer(str01); //将字符串转化为整型
		//System.out.println(ig2.byteValue());   //以byte类型返回该值
		ig2 = Integer.decode("12");    //将String解码为Integer
		//System.out.println(ig2);
		
		int i = Integer.parseInt("123"); //将参数字符串以十进制的方式来解析得到一个int值
		//System.out.println(i);   		//输出 123
		i= Integer.parseInt("100",2);   //将参数字符串以指定的进制来解析得到一个十进制数字
		//System.out.println(i);        //输出 4

		//将字符串以十进制的形式变为 Integer
		Integer it03 = Integer.valueOf("123", 10);
		System.out.println(it);
		//***********************************************************************
		
		
		
		//******************Integer 转字符串**************************************
		int  a = 13;
		String str = Integer.toBinaryString(a);    //将数字转化为二进制的字符串
		//System.out.println(str);

		
		//将10进制的参数转换为2进制的字符串
		System.out.println(Integer.toBinaryString(123));
		//将10进制的参数转换为8进制的字符串
		System.out.println(Integer.toOctalString(123));
		//将10进制的参数转换为16进制的字符串
		System.out.println(Integer.toHexString(123));
		
		//将整型按指定的进制转化为字符串 这里是将整型11以2进制的形式转化为字符串
		String str02= Integer.toString(11,2);  
		System.out.println(str02);    //输出 1011
		
		
		//************************************************************************
	}

}
