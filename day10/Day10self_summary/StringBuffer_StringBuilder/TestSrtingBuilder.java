package day10.StringBuffer_StringBuilder;

public class TestSrtingBuilder {

	public static void main(String[] args) {
		
		String str;
		
		//StringBuilder线程不安全，效率高（一般用它）; StringBuffer线程安全，效率低
		StringBuilder sbBuilder = new StringBuilder("abcd");
		
		//输出sbBuilder的哈希码来验证是否为同一对象
		System.out.println(Integer.toHexString(sbBuilder.hashCode()));
		System.out.println(sbBuilder);
		
		sbBuilder.setCharAt(2,'m');
		System.out.println(Integer.toHexString(sbBuilder.hashCode()));
		System.out.println(sbBuilder);
		//证明了在StringBuilder 是可以被修改的
		
		/*使用String进行字符串拼接   //这样会大量地创建对象 而且执行时间非常长！！！
		String str2 = new String("hi");
		for(int i = 0 ; i<5000;i++)
		{
			str2 = str2 + " ";
		}*/
		
		/*使用StringBuilder进行字符串的拼接*/
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<5000;i++)
		{
			sb.append(i);
		}
		
	}

}
