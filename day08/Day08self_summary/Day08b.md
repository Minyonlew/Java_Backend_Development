# Java Development

### Day 08 多态 **引用数据类型的类型转换** 



## 面对对象三大特征之一：多态  Polymorphism   

### 1、什么是多态

- **一个对象变量，可以指出多种实际类型的现象被称为  <u>多态</u>  **。
- **在运行时能够自动地选择那个方法的现象称为 <u>动态绑定</u>  。**
- **程序的最终状态只有在执行过程中才被决定而非在编译期间就决定了。** **这对于大型系统来说能提高系统的灵活性和扩展性。**

### 2、java中如何实现多态?使用多态的好处?

- 引用变量的两种类型：

  - **编译时类型**（模糊一点，一般是一个父类）

    ```java
    public  void (Pet pet);  //由声明时的类型决定。
    ```

  - **运行时类型**（运行时，具体是哪个子类就是哪个子类）

    - 由实际对应的对象类型决定。

- **多态的存在要有3个必要条件：**

  - <u>要有继承，要有方法重写，父类引用指向子类对象</u>



### 3、引用数据类型的类型转换

- **子类转换为父类：自动转换**

  - 上转型对象不能操作子类新增的成员变量和方法。

  - 上转型对象可以操作子类继承或重写的成员变量和方法

  - 如果子类重写了父类的某个方法，上转型对象调用该方法时，是调用的重写方法。

    ```java
    /*有抽象父类 Pet类。 抽象方法：eat(),bark().
    *
    * 子类： Cat类 与 Dog类  其中，方法都进行了重写 且内容不一样
    *	
    * 测试类： Test */
    
    Cat miao = new Cat();   
    Pet p = miao;    //父类引用指向子类对象  （自动转换）
    
    		  
    ```

- **父类转换为子类：强制转换**

  - 绝不是做手术，而是父类的真面目就是一个子类，否则会出现类型转换错误。

  - 为了防止转换出错可以先用instanceof判断类型,再去转换。

    ```java
    // 先通过 instanceof 判断 p 是 Dog类型，还是 Cat类型。然后再强制类型转换
    if (p instanceof Dog) {
    			Dog dog = (Dog) p;  //强制类型转换
    			dog.bark();
    		}else if (p instanceof Cat) {
    			Cat cat = (Cat)p;	//强制类型转换
    			cat.bark();
    		}
    ```

    

### 4、总结

- 下面练习的测试代码：Auto/...

![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day08/Day08self_summary/b01.png)

- **其中，多态的体现**

  - ```java
    // Customs.java
    
    	public int pay(Auto[]as,int day) {//根据数组中不同的类，调用不同的carPay（）方法
    		int count = 0;
    		for(Auto auto : as)
    		{
    			count += auto.carPay(day);
    		}
    		return count;
    		
    	}
    
    ```

    