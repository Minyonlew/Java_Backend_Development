package day10.StringBuffer_StringBuilder;

public class TestSrtingBuilder {

	public static void main(String[] args) {
		
		String str;
		
		//StringBuilder�̲߳���ȫ��Ч�ʸߣ�һ��������; StringBuffer�̰߳�ȫ��Ч�ʵ�
		StringBuilder sbBuilder = new StringBuilder("abcd");
		
		//���sbBuilder�Ĺ�ϣ������֤�Ƿ�Ϊͬһ����
		System.out.println(Integer.toHexString(sbBuilder.hashCode()));
		System.out.println(sbBuilder);
		
		sbBuilder.setCharAt(2,'m');
		System.out.println(Integer.toHexString(sbBuilder.hashCode()));
		System.out.println(sbBuilder);
		//֤������StringBuilder �ǿ��Ա��޸ĵ�
		
		/*ʹ��String�����ַ���ƴ��   //����������ش������� ����ִ��ʱ��ǳ���������
		String str2 = new String("hi");
		for(int i = 0 ; i<5000;i++)
		{
			str2 = str2 + " ";
		}*/
		
		/*ʹ��StringBuilder�����ַ�����ƴ��*/
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<5000;i++)
		{
			sb.append(i);
		}
		
	}

}
