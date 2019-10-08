public class SxtStu {

	int id ; 
	String sname ;
	int age ;
	
	Computer comp;
	
	void play(){
		System.out.println("在玩");
		
	}
	void study(){
		System.out.println("在学习，使用的电脑是："+comp.brand);
		
	}

	public static void main(String[] args) {
			
			SxtStu stu1 = new SxtStu();
			
			stu1.age = 18;
			stu1.id  = 01;
			stu1.sname = "lew";
			
			Computer pc = new Computer();
			pc.brand = "战神";
			stu1.comp=pc;
			
			stu1.play();
			stu1.study();
	｝
	

}

class Computer{
	
	String brand ;
	
}