# Java Development



##  Day 10 常用类：

#### （一）基本数据类型的包装类

- **自动装箱和自动拆箱**   **(auto-boxing & unboxing)**

  - **自动装箱**

    基本类型就自动地封装到与它相同类型的包装中，如：

    ```java
    Integer i = 100;
    ```

    本质上是，编译器编译时为我们添加了：

    ```java
    Integer i = Integer.valueOf(100);
    ```

    

  - **自动拆箱**

    包装类对象自动转换成基本类型数据。如：

    ```java
    int  a = new Integer(100);
    ```

    本质上，编译器编译时为我们添加了：

    ```java
    int  a = new Integer(100).intValue();
    ```

    

  - **与字符串转换的方法**

    ```java
    //字符串 -->Integer 
    Integer(String s) ;
    Integer.parseInt(String s) ;
    Integer.valueOf(String s);
    ```

    ```java
    //Integer -->字符串
    toString() 
    String.valueOf(Object obj) ;
    
    ```

- **测试代码Commonly_use_class/TestInteger.java**     !!!



### （二）字符串相关类

#####             --    **不可变字符序列：String**

- **String类的常用方法**
  - **测试代码Commonly_use_class/TestString.java**



--    **可变字符序列：StringBuffer    StringBuilder**

- **String类的常用方法**
  - **测试代码StringBuffer_StringBuilder/...**



- **练习**：

![02](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day10/Day10self_summary/02.png)

- ​	**测试代码 Practice/...**

