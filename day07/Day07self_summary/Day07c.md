# Java Development

### Day 07 继承 重写override   super关键字   final关键字 



## 面对对象三大特征之一：继承 inheritance



### 1、为什么要继承，继承可以做什么

- **继承：** 基于已存在的类构造一个新类，继承已存在的类就是复用（继承）这些类的方法和域。在此基础上还可以添加一些新的方法和域，以满足新的需求。



- **例子：**经理和普通员工的待遇存在一些差异，也有很多相同的地方。例如，他们都领取薪水。只是普通员工在完成本职任务之后仅仅是领取薪水，而经理在完成了预期的业绩后还能得到奖金。而这个时候就需要使用 **继承** ，需要定义一个新类 **Manager** ,以便增加新功能。易知 **Manager可以重用Employee类中的部分代码，并将其中的所有域保留下来，二者存在“is-a”的关系——每个经理都是一面雇员。**

  - 定义子类测试代码

    ```java
    public class Manager extends Employee
    {
    	private double bonus;
    	//...
    	public void setBonus(double bonus)   //经理可以设置自己的奖金
    	{
    		this.bonus = bonus;
    	}
    }
    ```

  - **关键字 extends :** 表面正在构造的新类派生与一个**已存在的类**。

  - **已存在的类称为超类（superclass）、父类（parent class）。**      

  - **新类称为子类（subclass）。**



- **小结：**

  - **子类继承父类的成员变量和成员方法，但不能继承父类的 <u>构造方法</u> 。**
  - Java中 只有 **单继承**，并没有像 **C++那样的多继承，而是通过  <u>接口</u>  来实现 。**
  - 在定义一个类时，如果没有调用**extends** ，则它的父类是 ： **java.lang.Object** 。
  - 对于父类来说，以下这些不能被子类调用：
    - **private 成员变量**
    - **子类与父类不同包，使用的default（默认访问权限）的成员变量**
    - **构造方法**

  

### 2、覆盖（重写 override）

- **在父类中有些方法对应子类来说不一定适用。**

  - 具体来说，**Manager类中的 getSalary方法应该返回薪水和奖金的总和。**为此，需要提供一个新方法来 <u>**覆盖**</u> 。

    ```java
    public class Manager extends Employee
    {
    	
    	//...
    	public double getSalary()   //经理可以设置自己的奖金
    	{
    		double baseSalary = super.getSalary();  //只有父类对象才能访问getSalary（）
    		return baseSalary + bonus;
    	}
    }
    ```



- **重写方法必须和被重写方法具有相同的方法名、参数列表和返回类型**。



### 3、super关键字

- 回忆一下，关键字 **this** 有两个用途：**一是引用隐式参数，二是调用该类其他的构造方法**。

- 同样，**super关键字** 也有两个用途：**一是调用父类的方法，二是调用父类的构造方法**，在调用构造器的时候，这两个关键字的使用方法很相似。**调用构造器的语句只能作为另一个构造方法的第一条语句出现。**构造参数既可以传递给本类 **this** 的其他构造器，也可以传递给超类 **（super）**的构造器。

  - ```java
    public Manager(String name,double salary,int year,int mouth,int day)
    {
        super(name,salary,year,mouth,day);
        bonus = 0;
    }
    
    ```

  - **注意：**

    - 如果子类的构造方法没有显示地调用父类的构造方法，则将自动地调用父类默认（没有参数）的构造方法。
    - 如果父类没有不带参数的构造方法，并且在子类的构造方法中有没有显式地调用父类的其他构造方法，则Java编译器将报告错误。



###  4、final关键字

- **final可以用来修饰变量，方法，类。**

  - **变量一旦被定义，则不能再改变**

    - ``` java
      final int x = 3;
      x = 4 ; //报错
      ```

  - **final 方法是再子类中不能被重写的方法**。

  - **final类无法被任何类继承。**