package day10.Commonly_used_class;

import java.nio.charset.Charset;
import java.util.Arrays;

public class TestString {

	public static void main(String[] args) {
		
		//new 出来的字符串放在堆区
		String str01 = new String();
		
		//双引号标记的字符串对象保存在共享区
		//当共享区已经有一个相同内容的字符串的时候，又去标记这个字符串，系统就不会再创建一个新的字符串
		//而是直接使用已有的字符串对象
		
		//使用一个字节数组来创建一个字符串  Unicode 每个字符占2个字节
		String str02 = new String(new byte[]{97,98,99});
		System.out.println(str02);
		
		//根据指定的编码格式，将一个字符串拆分成一个字节数组
		String str03 = new String("我是中文");
		byte [] bs  = str03.getBytes();
		
		//讲字节数组按照指定的编码格式转换为字符串
		String str04 = new String(bs,Charset.forName("GBK"));
		//System.out.println(str04);   //输出：我是中文   如果将GBK改为UTF-8，则是乱码
		
		//将字节数组中的指定范围内的字节转换为字符串
		str02 = new String(bs,2,4);
		//System.out.println(str02);   //输出： 是中  (byte[],第一个要解码的索引，要解码的byte数)
		
		
		//*********************字符串的常用方法************************
		String st01 = "我是中文字符串";
		
		// One. 通过下标获取字符串中的某个字符
		System.out.println(st01.charAt(0));  //输出 我
		
		// Two. 获取指定下标的字符的Unicode编码值
		System.out.println(st01.codePointAt(1));
		
		//字符串比较大小
		//（当前对象 大于  等于  小于  参数对象）   结果分别返回--> 负数   0   整数结果
		String st03 = "abcde";
		String st04 = "abcdg";
		String st05 = "ABCDE";
		System.out.println(st03.compareTo(st04));
		//不考虑字母大小写比较
		System.out.println(st03.compareToIgnoreCase(st05));
		
		//在原字符串后追加一个新的字符串 （得到的对象是新生成的！！！）
		String st06 = st03.concat("hhhh");
		System.out.println(st06);
		
		//判断目标字符串是否包含在当前字符串中
		System.out.println(st03.contains("abc"));   //输出：true
		
		
		//将字符串中指定范围内的字符拷贝到字符数组中，从数组的某个下标开始存放
		char [] ch = new char[10];
		String st07 ="我是中文字";
		//src开始下标 2 , src结束 5 ， 目标数组dst ch， 目标数组开始下标 3
		st07.getChars(2, 5, ch, 3);     //getChars(srcBegin, srcEnd, dst, dstBegin)
		System.out.println(Arrays.toString(ch));
		//输出 ：[ , , , 中,文,字, , , , ]
		
		//字符串的查找  在目标字符串中指定的位置 查找第一次出现的位置的下标
		int index = st07.indexOf("是",1);
		System.out.println(index);     //输出：1
		
		//字母替换     输入被替换的字的 和 想替换的字
		System.out.println(st07.replace("我","这"));
		
		//返回一个新的字符串，从指定的索引处的字符到指定为结尾的字符结束
		String st08 = st07.substring(2, 5);   //substring(beginIndex, endIndex)  [2,5)
		System.out.println(st08);
		
		//将此字符串转换为一个新的字符数组
		char c2 [] = st07.toCharArray();
		for (char c : c2) {
			System.out.print(c);
		}
		
		//返回新的字符串（已经去掉前导空白和尾部空白）
		String st09 = " Hi,my name is Lau!  ";
		System.out.println("{"+st09.trim()+"}");
		
		//返回double参数的字符串表示形式
		String st11 ,st10="3.141";
		st11 = st10.valueOf("3.14");
		System.out.println(st11+" "+st10);
		
	}

}
