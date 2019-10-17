package test;

public class Test {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		
		list.delete("a");
//		list.insert(1, "*");
		System.out.println(list.indexOf("d"));
	}
}
