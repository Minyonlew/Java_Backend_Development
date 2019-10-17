package test;

import java.util.Arrays;

/**
 * 使用数组 来手动封装一个ArrayList
(1)添加元素
(2)删除元素(按照内容删除,按照下标删除)
(3)插入元素
(4)查找元素(通过下表查找,通过元素内容查找)
(5)自动扩容

 * @author tang
 *
 */
public class MyArrayList {
	private Object [] objs = new Object[10];
	private int size = 0;
	
	/**
	 * 扩容的方法
	 */
	private void  addLen(){
//		当数组中年存放的元素和数组的长度是一样的时候     就需要扩容了
		if (size == objs.length) {
			Object [] arr = Arrays.copyOf(objs, objs.length*2);
			objs = arr;
		}
	}
	/**
	 * 添加元素
	 * 
	 */
	public void add(Object obj) {
//		判断是否需要自动扩容
		addLen();
		if (obj != null) {
			objs[size] = obj;
			size ++;
		}else {
			System.out.println("不能添加空元素");
		}
	}
	
	/**
	 * 通过下标来删除元素
	 * 
	 */
	public void delete(int index) {
//		判断下标的合法性
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
	 * 按照元素内容来删除元素
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
			System.out.println("所要删除的元素不存在");
		}
	}
	
	/**
	 * 插入元素
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
			System.out.println("下标不合法");
		}
		
	}
	
	/**
	 * 通过下标来获取元素
	 */
	public Object get(int index) {
		if (index >= 0 && index < size) {
			return objs[index];
		}else {
			System.out.println("下标不合法");
			return null;
		}
		
	}
	
	/**
	 * 通过元素来查找下标
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
