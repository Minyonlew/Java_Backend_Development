# Java Development

### Day 05 内存分析详解 栈 堆 方法区 程序执行的内存变化过程



### 1、栈

![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day05/Day05self_summary/01.png)



### 2、堆

![02](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day05/Day05self_summary/02.png)



### 3、方法区

![03](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day05/Day05self_summary/03.png)



### 4、程序执行的内存变化过程

- **代码 -> SxtStu.java**

- 内存分析

  ![04](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day05/Day05self_summary/04.png)



- **栈 ** 是 方法执行的内存模型，每个方法被调用时都会创建一个栈帧，用来存储 如 **局部变量、操  		作数、方法出口等**。

  - 这里存储的是main方法，以及在其里面声明的 **stu引用变量、c1 引用变量。**
  - 可以看到 **引用变量存储的只是对象在堆里面的地址而不是实际的内容。**

  

- **堆是一个不连续的内存空间**

  - 这里绿色的 就是创建好的 **对象的属性和方法**。

    

- **方法区** 也是堆，存放着 **类、常量等相关信息**。

  - 这里存放的是 **SxtStu类的信息，以及字符串。**

  