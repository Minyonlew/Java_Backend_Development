# Java Development



### Day 05 面向对象程序设计(OOP)



### 1、类 （Class）



- 定义
  - **类** **是构造对象的模板或蓝图**。
  - **由类构造(construct)对象的过程称为 创建类的 实例(instance).**



### 2、对象



- 想要使用OOP，一定要清楚对象的三个主要特性：

  - **对象的行为**  ----> 可以对对象施加那些操作，或可以对对象施加哪些方法？

  - **对象的状态**  ----> 当施加那些方法时，对象如何响应？

  - **对象的标识**  ----> 如何辨别具有相同行为与状态的不同对象？

    

- **类和对象的关系**

  - 特殊到一般，具体到抽象。
  - 类可以看成一类对象的模板，对象可以看成该类的一个具体实例。
  - 类是用于描述同一类形的对象的一个抽象的概念，类中定义了这一类对象所应具有的静态和动态属性。
  - JDK提供了很多类供编程人员使用，编程人员也可定义自己的类。



- **注意**：  ******************
  - 静态的描述声明为类的成员变量,成员变量描述对象有什么.
  - 动态的描述声明为成员方法,成员方法描述对象可以做什么.
  - 成员方法可以直接使用成员变量。
  - 每个对象都有属于自己的一套成员变量。

### 3、类和对象的总结

- **定义类**  （Pet.java）

  - ```java
    /*
    定义类（类的组成）
    	属性 field
    	方法 method
    	构造方法 construtor
    	其他：代码块 静态代码块 内部类
    */
    Class Pet
    {
    	//成员变量（属性）
    	String name；
    	String brand；
    	int	   health;
    	
    	//成员方法（行为）
    	public void say()
    	{
    		System.out.print("我的名字叫："+name+"，我是一只快乐的"+brand);
    		System.out.print("，我的健康值是："+health);
    	}
    }
    ```

- **创建对象**   (TestMain.java)

  - ```java
    public class TestMain {
    
    	public static void main(String[] args) {
            
            //类名 对象名 = new 类名();
            Pet dog = new Pet();
            
            //对对象的属性赋值
            dog.name = "旺财";
            dog.brand = "金毛";
            dog.health = 100;
            //调用对象的方法
            dog.say();
            // 输出--->我的名字叫:旺财，我是一只快乐的金毛，我的健康值是：100
        }
    }
    ```

    

### 3、引用类型

- Java 语言中除基本类型之外的变量类型都称之为 **引用类型**。

- Java中的 **对象和数组** 是通过 **引用** 对其操作的.

  - 引用可以理解为一种受限的指针。
- 指针是可以进行与整数做加减运算的，两个指针之间也可以进行大小比较运算和相减运算。但引用不行，只能进行赋值运算。
  - 引用就是一个变量或对象的别名（引用的本质是一个对象）；指针是一个栈内存空间的地址(指向存储一个变量值的空间或一个对象的空间)。

- Java中 ，方法中所有参数都是 **“值传递”** ，也就是说传递的是 **“值的副本“** ，得到的是 **“原参数的复印件，而不是原件”**。 因此，复印件的改变不会影响原件。

- 而 **引用类型指的是 “对象的地址”**。因此，**副本和原参数都指向了同一个 “地址”，改变“副本指向地址对象的值”，也意味着原参数指向对象的值也发生了改变** 。

- 代码：

  ```java
  package 参数传值机制;
  
  /*
   * 测试参数传值机制
   * */
  
  public class User4 {
  
  	int id;
  	String name;
  	String pwd;
  	
  	public User4 (int id , String name) {
  		this.id = id;
  		this.name = name;
  	}
  	public void  test01(User4 u) {
  		u.name = "小一";
  	}
  	public void  test02(User4 u) {
  		u = new User4(200,"小二");
  	}
      
      
  	public static void main(String[] args) {
  		
  		User4 u1 = new User4(100, "小零");
  		u1.test01(u1);
  		System.out.println(u1.name);    // 输出小一
  		
  		u1.test02(u1);
  		System.out.println(u1.name);    // 输出小一
  	}
  }
  
  /**
   * 易知 u1刚开始通过构造方法，初始化的 name是 小零
   * 在调用 test01(u1)之后，由于u这个新对象也是指向 u1.name的地址，所以u.name = "小一"，也    相当于 u1.name = "小一";
   * 
   * 而 调用u1.test02()时，u是新创建的对象，u.name 跟 u1.name 的地址不一样，指向的不是同一  	 个东西，所以u.name的改变不影响 u1.name
   * 
   */
  ```

  
