package day10.Commonly_used_class;

import java.nio.charset.Charset;
import java.util.Arrays;

public class TestString {

	public static void main(String[] args) {
		
		//new �������ַ������ڶ���
		String str01 = new String();
		
		//˫���ű�ǵ��ַ������󱣴��ڹ�����
		//���������Ѿ���һ����ͬ���ݵ��ַ�����ʱ����ȥ�������ַ�����ϵͳ�Ͳ����ٴ���һ���µ��ַ���
		//����ֱ��ʹ�����е��ַ�������
		
		//ʹ��һ���ֽ�����������һ���ַ���  Unicode ÿ���ַ�ռ2���ֽ�
		String str02 = new String(new byte[]{97,98,99});
		System.out.println(str02);
		
		//����ָ���ı����ʽ����һ���ַ�����ֳ�һ���ֽ�����
		String str03 = new String("��������");
		byte [] bs  = str03.getBytes();
		
		//���ֽ����鰴��ָ���ı����ʽת��Ϊ�ַ���
		String str04 = new String(bs,Charset.forName("GBK"));
		//System.out.println(str04);   //�������������   �����GBK��ΪUTF-8����������
		
		//���ֽ������е�ָ����Χ�ڵ��ֽ�ת��Ϊ�ַ���
		str02 = new String(bs,2,4);
		//System.out.println(str02);   //����� ����  (byte[],��һ��Ҫ�����������Ҫ�����byte��)
		
		
		//*********************�ַ����ĳ��÷���************************
		String st01 = "���������ַ���";
		
		// One. ͨ���±��ȡ�ַ����е�ĳ���ַ�
		System.out.println(st01.charAt(0));  //��� ��
		
		// Two. ��ȡָ���±���ַ���Unicode����ֵ
		System.out.println(st01.codePointAt(1));
		
		//�ַ����Ƚϴ�С
		//����ǰ���� ����  ����  С��  ��������   ����ֱ𷵻�--> ����   0   �������
		String st03 = "abcde";
		String st04 = "abcdg";
		String st05 = "ABCDE";
		System.out.println(st03.compareTo(st04));
		//��������ĸ��Сд�Ƚ�
		System.out.println(st03.compareToIgnoreCase(st05));
		
		//��ԭ�ַ�����׷��һ���µ��ַ��� ���õ��Ķ����������ɵģ�������
		String st06 = st03.concat("hhhh");
		System.out.println(st06);
		
		//�ж�Ŀ���ַ����Ƿ�����ڵ�ǰ�ַ�����
		System.out.println(st03.contains("abc"));   //�����true
		
		
		//���ַ�����ָ����Χ�ڵ��ַ��������ַ������У��������ĳ���±꿪ʼ���
		char [] ch = new char[10];
		String st07 ="����������";
		//src��ʼ�±� 2 , src���� 5 �� Ŀ������dst ch�� Ŀ�����鿪ʼ�±� 3
		st07.getChars(2, 5, ch, 3);     //getChars(srcBegin, srcEnd, dst, dstBegin)
		System.out.println(Arrays.toString(ch));
		//��� ��[ , , , ��,��,��, , , , ]
		
		//�ַ����Ĳ���  ��Ŀ���ַ�����ָ����λ�� ���ҵ�һ�γ��ֵ�λ�õ��±�
		int index = st07.indexOf("��",1);
		System.out.println(index);     //�����1
		
		//��ĸ�滻     ���뱻�滻���ֵ� �� ���滻����
		System.out.println(st07.replace("��","��"));
		
		//����һ���µ��ַ�������ָ�������������ַ���ָ��Ϊ��β���ַ�����
		String st08 = st07.substring(2, 5);   //substring(beginIndex, endIndex)  [2,5)
		System.out.println(st08);
		
		//�����ַ���ת��Ϊһ���µ��ַ�����
		char c2 [] = st07.toCharArray();
		for (char c : c2) {
			System.out.print(c);
		}
		
		//�����µ��ַ������Ѿ�ȥ��ǰ���հ׺�β���հף�
		String st09 = " Hi,my name is Lau!  ";
		System.out.println("{"+st09.trim()+"}");
		
		//����double�������ַ�����ʾ��ʽ
		String st11 ,st10="3.141";
		st11 = st10.valueOf("3.14");
		System.out.println(st11+" "+st10);
		
	}

}
