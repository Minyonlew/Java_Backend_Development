package test;

import java.util.Arrays;

/**
 * ʹ������ ���ֶ���װһ��ArrayList
(1)���Ԫ��
(2)ɾ��Ԫ��(��������ɾ��,�����±�ɾ��)
(3)����Ԫ��
(4)����Ԫ��(ͨ���±����,ͨ��Ԫ�����ݲ���)
(5)�Զ�����

 * @author tang
 *
 */
public class MyArrayList {
	private Object [] objs = new Object[10];
	private int size = 0;
	
	/**
	 * ���ݵķ���
	 */
	private void  addLen(){
//		�����������ŵ�Ԫ�غ�����ĳ�����һ����ʱ��     ����Ҫ������
		if (size == objs.length) {
			Object [] arr = Arrays.copyOf(objs, objs.length*2);
			objs = arr;
		}
	}
	/**
	 * ���Ԫ��
	 * 
	 */
	public void add(Object obj) {
//		�ж��Ƿ���Ҫ�Զ�����
		addLen();
		if (obj != null) {
			objs[size] = obj;
			size ++;
		}else {
			System.out.println("������ӿ�Ԫ��");
		}
	}
	
	/**
	 * ͨ���±���ɾ��Ԫ��
	 * 
	 */
	public void delete(int index) {
//		�ж��±�ĺϷ���
		if (index >= 0 && index < size) {
			objs[index] = null;
			for (int i = index; i < size-1; i++) {
				objs[i] = objs[i+1];
			}
			objs[size-1] = null;
			size --;
		}
	}
	
	/**
	 * ����Ԫ��������ɾ��Ԫ��
	 * 
	 */
	public void delete(Object obj) {
		int index = -1;
		for (int i = 0; i < objs.length; i++) {
			Object o = objs[i];
			if(o == null){
				break;
			}
			if (o.equals(obj)) {
				index = i;
				break;
			}
		}
		
		if (index >= 0) {
			delete(index);
		}else{
			System.out.println("��Ҫɾ����Ԫ�ز�����");
		}
	}
	
	/**
	 * ����Ԫ��
	 */
	public void insert(int index,Object obj) {
		addLen();
		if (index >= 0 && index < size) {
			for (int i = size; i > index; i--) {
				objs[i] = objs[i-1];
			}
			objs[index] = obj;
			size ++;
		}else {
			System.out.println("�±겻�Ϸ�");
		}
		
	}
	
	/**
	 * ͨ���±�����ȡԪ��
	 */
	public Object get(int index) {
		if (index >= 0 && index < size) {
			return objs[index];
		}else {
			System.out.println("�±겻�Ϸ�");
			return null;
		}
		
	}
	
	/**
	 * ͨ��Ԫ���������±�
	 */
	public int indexOf(Object obj) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (obj.equals(objs[i])) {
				index = i;
			}
		}
		
		return index;
	}
	
	@Override
	public String toString() {
		String str = "MyArraylist";
		for (Object object : objs) {
			if (object != null) {
				str += ",";
				str += object.toString();
				
			}
		}
		return str;
	}
	
	

}
