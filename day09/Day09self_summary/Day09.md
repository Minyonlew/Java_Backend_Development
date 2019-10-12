# Java Development

### Day 09  **接口** interface  内部类



### 1、接口 interface

- **<u>为什么需要接口？接口和抽象类的区别？</u>**

  - **接口就是比“抽象类”还要“抽象”的“抽象类”**， 可以更加规范的对子类进行约束。**全面地专业地实现了：规范和具体实现的分离。**

  - **接口就是规范，定义的是一组规则，体现了显示世界中 “如果你是...则必须能...-> has...a” 的思想**

  - **项目的具体需求是多变的，我们必须以不变应万变才能从容开发，此处的“不变”就是“规范”。因此，我们开发项目往往都是面向接口编程**

    

- **<u>接口的相关规则</u>**

  - **接口不是类，接口是一种引用数据类型。**

  - **接口中的属性都必须是public static final ,声明的时候可以省略，但是接口中的成员变量必须在声明的时候就进行初始化。**

  - **接口中的方法全部都是public abstract 的方法，可以省略不写（就是意味着<u>实现implements</u>接口的类必须重写接口中的方法。）**

  - **接口不能被实例化，也就是不能创建对象，也不能有构造方法。**

  - **类可以实现多个接口，<u>extends必须位于implements之前</u>。**

  - –可以定义一个新接口，用extends去继承一个已有的接口

    –接口不能继承普通类

    –可以定义一个类，用implements去实现一个接口中所有方法。

    –可以定义一个抽象类，用implements去实现一个接口中部分方法。



- **如何定义接口？**

  ``` java
  /*
  格式：
  	[访问修饰符]  interface 接口名   [extends  父接口1，父接口2…]  {
  		常量定义      //总是public   static  final
  		方法定义       //总是：public   abstract
  }
  */
  public interface UsbInterface {
         public static final int size = 10;//成员变量一定是public static final（可以省略）
          
          public abstract void func();  //方法一定是public abstract （可以省略）
      }
  
  ```



- **如何实现接口**

  ```java
  /*
  	- 子类通过implements来实现接口中的规范
  	- 接口不能创建实例，但是可用于声明引用变量类型。
  	- 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
  	- Java的类只支持单继承，接口支持多继承
  */
  public class Fan implements UsbInterface{
      @Override
      public void func()
      {
          System.out.println("风扇可以用了");
      }
      
  }
      
  ```



- **接口实现多态**
  - 测试代码 interfaceTest/...
  - **接口是一种能力体现在接口的方法上。**
  - **面向接口编程关心实现类有何能力，而不关心实现细节**
  - **面向接口的约定而不考虑接口的具体实现**



### 2、内部类

- **内部类（inner class）是定义在另一个类中的类。为什么需要使用内部类呢？其主要原因有一下三种：**
  - **内部类方法可以访问该类定义所在的作用域中的数据，包括私有数据。**
  - **内部类可以对同一个包中的其他类隐藏起来。**
  - **当想要定义一个回调函数且不想编写大量代码时，使用匿名（anonymous）内部类比较便捷。**



- **类中定义内部类的特点**
  - **内部类作为外部类的成员，可以直接访问外部类的成员（包括private成员），反之则不行。**
  - **内部类成员只有在内部类的范围之内是有效的。**
  - 编译后生成两个类： OuterClass.class 和OuterClass$InnerClass.class
  - **用内部类定义在外部类中不可访问的属性。这样就在外部类中实现了比外部类的private还要小的访问权限。**



- 内部类的分类
  - 成员内部类（静态、非静态成员内部类）
  - 方法内部类（局部内部类）
  - 匿名内部类



- 成员内部类

  - **非静态内部类**

    - 非静态内部类必须寄存在一个外部类对象里，因此，如果有一个非静态内部类对象那么一定存在对应的外部类对象。**非静态内部类对象单独属于外部类的某个对象。**
    - **非静态内部类可以直接访问外部类成员，反之不行。**
    - **非静态内部类不能有静态方法、静态属性和静态代码块。**
    - 外部类的静态方法不能访问非静态内部类，包括不能使用非静态内部类定义变量、创建实例

    ```java
    // 测试非静态内部类
    public class TestInnerClass {
    
    	public static void main(String[] args) {
    		// 创建内部类对象 非静态内部类对象单独属于外部类的某个对象
            Outer.Inner inner = new Outer().new Inner();
    		inner.show();   //输出：外部类的成员变量age:10
    	}
    }
    
    class Outer{
    	private int age = 10;
    	public void testOuter(){}
        
    	class Inner {
            int age = 20;
    		public void show() {
                int age = 30;
                //在内部类调用外部类的外部变量age
    			System.out.println("外部类的成员变量age:"+Outer.this.age); 
                //内部类调用自己的成员变量age
    			System.out.println("内部类的成员变量age:"+this.age);
                //内部类的方法调用局部变量age
                System.out.println("内部类的成员方法的局部变量age:"+age);
    		}
    	}
    }
    ```

  

  - **静态内部类**

    - 当一个静态内部类对象存在，并不一定存在对应的外部类对象。因此，静态内部类的实例方法不能直接访问外部类的实例方法。
    - **静态内部类看做外部类的一个静态成员。因此外部类的方法可以通过：“<u>静态内部类.名字</u>” 的方式访问静态内部类的静态成员，通过new 静态内部类()访问静态内部类的实例**

    ```java
    class Outer{
        //相当于外部类的一个静态成员
        static class Inner{
        }
    }
    public class TestStaticInnerClass {
    
    	public static void main(String[] args) {
    		// 通过 new 外部类名.内部类名（） 来创建
            Outer.Inner inner = new Outer. Inner();
    		
    	}
    }
    ```

  - **匿名内部类**

    - **适合那种只需要使用一次的类。比如：键盘监听器操作等（Android用得较多）**

    - **匿名内部类没有访问修饰符。**

    - **匿名内部类 没有构造方法。因为他连名字都没有何来构造方法。**

      ```java
      //语法
      	new 父类构造器（实参列表）\实现接口（）｛
      		//类体
      	｝
      ```

    - ```java
      public class TestAnonymousInnerClass{
          
          public static void test01(AA A)
          {
              System.out.println("######");
              a.aa();
          }
          
          public static void main(String args[]){
              TestAnonymousInnerClass.test01(new AA(){
                  
                  @Override
                  public void aa(){
      				System.out.println("TestAnonymousInnerClass");
                  }
                  
              });
              
          }
      }
      
      //输出： ######
      //		TestAnonymousInnerClass
      ```

  - **方法中的内部类**

    - 将内部类定义在外部类的方法中。
    - 方法内部类不能在外部类的方法以外的地方使用，**方法内部类不能使用访问控制符和static修饰。**
    - **方法内部类如果想使用方法的参数，那么参数前必须加final关键字。**

