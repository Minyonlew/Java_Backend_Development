package day10.Commonly_used_class;

public class TestInteger {

	public static void main(String[] args) {
		
		//�������������͵ı���ת��Ϊ��Ӧ��װ��Ķ���
		int in = 10;
		Integer it = new Integer(in);
		//��java1.5�汾�Ժ�   �����������ͺ����İ�װ�������֮������Զ�ת��
		//���ǳ�֮Ϊ    �Զ���װ��
		//�����������Ϳ���ֱ��ת��Ϊ�����������͵Ķ���  ��֮Ϊ�Զ�װ�� 
		Integer it02 = 10;
		int it02_2 = it02;
		
				
		//******************���ַ���תΪ Integer *********************************
		String str01 = "270";
		Integer ig2 = new Integer(str01); //���ַ���ת��Ϊ����
		//System.out.println(ig2.byteValue());   //��byte���ͷ��ظ�ֵ
		ig2 = Integer.decode("12");    //��String����ΪInteger
		//System.out.println(ig2);
		
		int i = Integer.parseInt("123"); //�������ַ�����ʮ���Ƶķ�ʽ�������õ�һ��intֵ
		//System.out.println(i);   		//��� 123
		i= Integer.parseInt("100",2);   //�������ַ�����ָ���Ľ����������õ�һ��ʮ��������
		//System.out.println(i);        //��� 4

		//���ַ�����ʮ���Ƶ���ʽ��Ϊ Integer
		Integer it03 = Integer.valueOf("123", 10);
		System.out.println(it);
		//***********************************************************************
		
		
		
		//******************Integer ת�ַ���**************************************
		int  a = 13;
		String str = Integer.toBinaryString(a);    //������ת��Ϊ�����Ƶ��ַ���
		//System.out.println(str);

		
		//��10���ƵĲ���ת��Ϊ2���Ƶ��ַ���
		System.out.println(Integer.toBinaryString(123));
		//��10���ƵĲ���ת��Ϊ8���Ƶ��ַ���
		System.out.println(Integer.toOctalString(123));
		//��10���ƵĲ���ת��Ϊ16���Ƶ��ַ���
		System.out.println(Integer.toHexString(123));
		
		//�����Ͱ�ָ���Ľ���ת��Ϊ�ַ��� �����ǽ�����11��2���Ƶ���ʽת��Ϊ�ַ���
		String str02= Integer.toString(11,2);  
		System.out.println(str02);    //��� 1011
		
		
		//************************************************************************
	}

}
