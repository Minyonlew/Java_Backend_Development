# Java Development

### Day 06   static关键字 this关键字 构造方法



### 1、Static 关键字

- **static** 是一个关键字 ，意思是静态的。

- **作用**

  - 可以修饰 **属性（成员变量）**，修饰的属性叫 **静态变量** 或者 **类变量**。
  - 可以修饰 **方法，叫做静态方法，也叫类方法**。
  - 可以修饰 **代码块，叫做静态代码块。** 
  - 可以修饰 **类，叫做静态内部类。**

- **为什么要使用static**

  - 每个对象的属性都是独立的，也就是在使用某对象的属性时都要先赋值，由于有些对象中的某些属性的值是一样的，如果每次都重复赋值同样的值，这样会出现大量的重复代码，浪费内存空间。**为此，对于这样相同的对象属性，可以同static关键字来修饰，称为 静态属性，存在共享区（方法区），这里的属性可以被所有的对象共用。**

  

- **Static 定义静态变量 、 静态方法以及静态代码块 **

  ``` java
  // Staticdemo.java
  /*
   * static
   * 作用1，修饰一个成员变量
   * 		该成员变量就成为了静态成员变量
   * 		静态成员变量属于整个类所有，被这个类创建出来的所有的对象所共享
   * 		静态成员变量 保存在共享区
   * 作用2，修饰一个方法
   * 		该方法就变成了静态方法
   * 		静态方法可以用类名直接调用
   * 		静态成员方法只能使用静态成员变量，不能使用非静态成员变量
   * 
   * 作用3，修饰代码块
   * 		该代码块就成为了静态代码块
   * 		当需要使用一个类的时候，系统会将该类加载带内存中，当这个类被成功加载到内存以后会自  		   动执行静态代码块
  ```
 * 		创建一个对象系统就会自动执行一次普通代码块
   */
    public class Staticdemo {

  	String name;
  	int num ;
  	
  	static String area;
  	
  	public static void  say() {
  		
  		System.out.println("我是静态方法");
  	}

  }
  ```
  
  ```java
  //TestMain.java
  public class TestMain {
  
  	public static void main(String[] args) {
  		
  		Staticdemo st1 = new Staticdemo();
  		
  		st1.name = "wo";
  		st1.num = 1;
  		//声明静态变量
  		st1.area = "gz";
          
  		System.out.print("name="+st1.name+" "+"num="+st1.num);
  		System.out.println(" "+"area="+st1.area);
  		
	        
  		Staticdemo st2 = new Staticdemo();
  		st2.name = "ni";
  		st2.num = 2;
  		
  		System.out.print("name="+st2.name+" "+"num="+st2.num);
  		System.out.println(" "+"area="+st2.area);
  		
  		//静态方法 不需要创建对象来调用
  		Staticdemo.say();
  	}
  
  }
  
  /*
  	输出：
      name=wo num=1 area=gz
  	name=ni num=2 area=gz
  	我是静态方法
  
  */
  
  
  ```

- **利用static 进行 单例模式**-

  - 单例模式的特点
    - **1、单例类确保自己只有一个实例。**
    - **2、单例类必须自己创建自己的实例。**
    - **3、单例类必须为其他对象提供唯一的实例。**
  - 例子
    - 如在访问页面时，需要登录账户，要输入账户密码。这时若跳转页面，则需要将该用户的信息（账户密码）都要“转移”到跳转的页面，如果每次跳转页面都要重新赋值，就显得不安全且不方便。**为此，通过单例模式，确保只有一个实例，则每次调用的对象及其属性都是唯一的，当需要调用的时候直接访问即可，不需一遍一遍的赋值。**
    - **代码：Danli/Login.java**  Pay.java  **UseInof.java ** TestMain.java



- **this 关键字**

  - **代表当前对象的引用**

  - 应用场景

    ```java
    //当局部变量和成员变量重名时，使用this ，用来表示当前对象的引用。
    class Dog{
        
        String name;
        int age;
        
        public void  say(String name,int age)
        {
    		this.name = name;//this引领的是当前对象的成员变量 （成员变量与形参重名）
            this.age  = age;
            System.out.println("name =："+this.name);
            System.out.println("age =："+this.age);
        } 
    }
    ```

    ```java
    //调用方法
    class Dog{
        
        String name;
        int age;
        
        public void  test01()
        {
            System.out.println("test01");
            this.test02();   //调用该对象的方法
        }
        public void test02() {
    		System.out.println("test02");
    	}   
    }
    ```

    ```java
    //调用构造方法
    /*
    	一般如果构造方法需要很多不同的构造方法，且每个构造方法都有一些相同的形参
    	则可以通过this来调用拥有重复形参的构造方法来减少代码量
    */
    public class Dog {
    	String name;
    	int age;
        
    	public  Dog() {    //构造方法
    		name = "";
    		age = 1;
    		System.out.println(123);
    	}
    	public Dog(String name,int age) { //构造方法（重载）
    		this(name);    //通过this 来调用构造方法
    		this.age = age;
    	}
    	public  Dog(String name) {    //构造方法（重载）
    		this.name = name;
    	}
    
    }
    ```



- **构造方法 ： constructor（构造器）**

  - 定义
    - **一个在创建对象时被自动调用的特殊方法。**
  - 特点
    - **构造器的方法名必须和类名一致。**
    - 构造器虽然有返回值，但是不能定义返回类型(返回值的类型肯定是本类)，不能在构造器里调用return。 
    - **通过new关键字调用**。
    - 如果没有定义构造器，则系统会自动定义一个无参的构造方法。如果已定义则编译器不会添加无参数构造方法。
    - **与普通方法一样，构造方法也可以重载。**
  - **作用**
    - 为对象进行 **初始化（成员变量）**。

  ```java
  //构造方法
  public class Dog {
  	String name;
  	int age;
      
  	public  Dog() {    //无参构造方法
  		name = "";
  		age = 1;
  		System.out.println(123);
  	}
  	public Dog(String name,int age) {  //带参数构造方法（构造方法的重载）
  		this(name);
  		this.age = age;
          System.out.print("name =："+this.name);
          System.out.println("age =："+this.age);
  	}
  	
  	public  Dog(String name) {   //带参数构造方法（构造方法的重载）
  		this.name = name;
  	}
  }
  
  public class Test {
  	public static void main(String[] args) {
  		Dog  dog1 = new Dog();   //一般常规的定义对象  输出-->123
          
          Dog  dog2 = new Dog("hi",2); //通过构造方法来对该对象的成员变量进行赋值
          //输出： name = hi age = 2
          
  	}
  
  }
  ```

  