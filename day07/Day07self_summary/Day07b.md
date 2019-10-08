# Java Development

### Day 07 封装  访问控制符



## 面对对象三大特征之一：封装 encapsulate

 

### 1、为什么需要封装，封装的作用

- 在使用电视机时，只需要懂得使用遥控器上的按钮就能使用，不用懂得然后使用显示管等内部结构。

- 采用 **封装 ** 可以隐藏对象内部的复杂性，只对外公开简单的接口，便于外界调用，从而提高系统的可扩展性、可维护性。
- 程序设计要追求 **高内聚，低耦合**。
  - 高内聚就是类的内部数据操作细节自己完成，不允许外部干涉；
  - 低耦合：仅暴露少量的方法给外部使用。 



### 2、使用访问控制符，实现封装

- **public 公共的**    

  - 可以被项目中所有的类访问。(项目可见性)

   

- **protected 受保护的**

  - 可以被这个类本身访问；

  - 同一个包中的所有其他的类访问；

  - **被它的子类（同一个包以及不同包中的子类）访问**。

    

- **default／friendly 默认的/友好的（包可见性）** 

  - 被这个类本身访问；
  - 被同一个包中的类访问；
  - **其他包中的类不能被访问**。

-  **private 私有的**    

  - 只能被这个类本身访问，**其他类都不行**。（类可见性） 

![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day07/Day07self_summary/b01.png)



- 测试代码：

  - EncapsulationTest/...

    

### 3、封装的使用细节

- 通常来说，成员变量都设置为private私有的，不让外界直接初始化成员变量，既然不能通过外部来初始化，那么系统提供了工具——set、get方法来给成员变量赋值。

```java
//Person4.java
public class Person4 {
	private int id;
	private String name;
	private int age;
	private boolean man;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
```



```java
//TestSetGet.java
public class TestSetGet {

	public static void main(String[] args) {
		
		Person4 t = new Person4();
		
		//t.age = 10;  //私有的成员变量不能直接被调用了
		
		t.setId(10);         //通过set 方法来对成员变量进行赋值
		t.setName("你好");

		System.out.println(t.getId());   //通过get 方法得到成员变量
		System.out.println(t.getName());
	}

}
```

- set 、 get 方法可以在eclipse 上 **右键 选择 Source-> Generate Getter and Setter...**

  就会自动生成每个成员变量的get和set方法。

