package day13.Map.practice01;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		Map<Integer,String> map2 = new HashMap<Integer,String>();
		 
	
		 	//1.����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻� null��
		 	map.put(2, "wangcai");
			map.put(3, "daniu");
			map2.put(1,"һ");
			map2.put(2, "��");
			
			//��ָ��ӳ���н�����ӳ���ϵ���Ƶ���ӳ���У���ѡ��������
			map.putAll(map2);
			System.out.println(map);
			
			//2���洢��ֵ�ԡ��������ͬ�������ֵ���ǡ�
			System.out.println(map.put(4, "xiaoqiang"));
			System.out.println(map.put(4, "erhu"));
			System.err.println("********");
			
			//3.�������һ������ӳ���ϵ������Ӵ�ӳ�����Ƴ�����ѡ��������
			System.out.println(map.remove(2));
			//4.����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻� null��
			System.out.println(map.get(3));

			//5.�����ӳ�����ָ������ӳ���ϵ���򷵻� true��
			System.out.println(map.containsKey(2));
			// �����ӳ�佫һ��������ӳ�䵽ָ��ֵ���򷵻� true��
			System.out.println(map.containsValue("daniu"));
			
			//6.���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
			System.out.println(map.entrySet());
			
			//7.���ش�ӳ���а����ļ��� Set ��ͼ��
			System.out.println(map.keySet());
			
			//8.���ش�ӳ���а�����ֵ�� Collection ��ͼ��
			System.out.println(map.values());
			
			//�Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ��������
			//map.clear();
			//System.out.println(map);
		}
}
