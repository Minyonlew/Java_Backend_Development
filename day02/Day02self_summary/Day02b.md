# JAVA Development



### Day 02 b



### 1、整型

![b01](C:\Users\Minyon\Desktop\b01.png)



-  **byte**

  ``` Java
  byte age = 100；    
  ```

- **short**

  ```java
  short sal = 30000；
  ```

- **int**

  ```java
  int num = 300000;
  ```

- **long**

  ```Java
  long jackMa = 30000000000L;
  ```

- **注意：**

  - 整型常量默认为 **int** 型， 声明 **long**型常量要加 **‘ L ’**



### 2、浮点型

![b02](G:\0ASXTJAVA\Lesson\day02\day02\Day02self_summary\b02.png)



- **float**   **单精度**

  ``` java
  float p = 3.14F；
  /*
   *	单精度类型，尾数可以精确到7位有效数字，在很多情况下，float类型的精度很难满足需求。
   */
  ```

- **double   双精度**

  ```java
  double  d = 3.14;
  double  d1 = 314e2;  //314*10^2-->31400.0
  double  d3 = 314e-2; //314*10^(-2)-->3.14
  
  /*
   *双精度类型  精度是float类型的两倍，绝大部分应用程序都采用double类型。
   */
  ```

- **注意：**

  - 浮点常量默认为  **double**。要变为**float**，需在后面增加**F/f.**  如： 3.14F
  - **浮点数存在舍入误差，很多数字不能精确表示。如果需要进行不产生舍入误差的精确数字计算，需要使用**BigDecimal**类。**



### 3、字符型 （2个字节）

-  **char**

  ```java
  char c = 'a' ;
  ```

- **注意：**

  - **char类型** 用来表示在 **Unicode** 编码表中的字符。

  - **char类型** 在内存中存储的是该字符的 **Unicode编码值** ，**所以char类型可以当做int类型来处理**。

    ```java 
    char c = 'a' ;
    System.out.print((int)c);      // 输出-> 97
    ```

- Java 语言中还允许使用 **转义字符 ‘\’**  来将其后的字符转变为其它的含义。

  - ``` java
    char c2 = '\n';  //代表换行符
    ```

    

  ​          ![b03](C:\Users\Minyon\Desktop\b03.png)





### 4、布尔类型 （1位）

- **boolean**

  - **true**     **false**
  - **boolean类型** 用来判断逻辑条件，一般用于程序流程控制 。

  ``` java
  boolean done = true ；
  ```



### 5、命名规范

- **变量、方法名**

  - 首字母小写，驼峰原则
    - 方法名：run() 、 runRun() 。
    - 变量名：userName 。
- **常量**
- 大写字母和下划线
    - MAX_VALUE、AGE_NEW
- **类名**

  - 首字母大写，驼峰原则

    - Man、GoodMan

- s

### 6、运算符

- 算术运算符

  - **+，-，*，/，%**

  ```java
  int a = 2 ;
  int b = 3 ;
  // System.out.print(a+b);    输出-> 5
  // System.out.print(b-a);    输出-> 1
  // System.out.print(a*b);    输出-> 6
  // System.out.print(a/b);    输出-> 0    整除 求商
  // System.out.print(a%b);    输出-> 5    求模 求余数
  ```

  

  - **++，--**

    ```java
    int a = 2 ;
    System.out.print(a++);    // 输出-> 2  从左到右 ，先输出a ，a再自加
    System.out.print(a);	  // 输出-> 3  上一条代码 a自加1 
    System.out.print(++a);	  // 输出-> 5  从左到右 ，a先自加 ，再输出
    ```



- 扩展赋值运算符

  - **+=，-=，*=，/=** 

    ```java
    int a = 2 ;
    a += 3 ;		//输出 -> 5  相当于 a = a + 3 ;	
    ```



- 关系运算符

  - **>，<，>=，<=，==，!=**

    ```
    int a = 2 ;
    int b = 3 ;
    System.out.print(a>b);    // 输出-> false
    System.out.print(a<=b);	  // 输出-> true 
    System.out.print(a==b);	  // 输出-> false
    System.out.print(a!=b);   // 输出-> true
    

    //对于引用数据类型，==并不能判断两边的内容是否相等   
    //例如 字符串
    ```
    
    

- 逻辑运算符

  - **短路 （与 &&） 、 （或||）、 (非！)  ** 

    ```java
    int a = 2 ;
    int b = 3 ;
    System.out.println(a>b&&b/0>0);    // 输出-> false    不会报错
    System.out.println(a<b&&b/0>0);    // 报错
    /*
     * 所谓逻辑运算符，就是当 符号前后都是表达式时，符号充当 逻辑运算符
     * 所谓短路，就是如果 符号前面的表达式能够决定结果，那么不需要考虑后面的表达式
     * 短路（或||）、 (非！)   同理
     */
    
    ```

  - **逻辑 （与&）、（或|）**

    ```java
    int a = 2 ;
    int b = 3 ;
    System.out.println(a>b&&b/0>0);    // 报错  
    //短路逻辑运算符 是要通过符号两边才能决定输出的结果
    ```

  

- 位运算符

  - **(按位与&)，（按位或|），（按位异或 ^），(左移<<)，(右移>>)**

    ```java
    int a = 4 ;     // 4 的二进制 -> 0100  
    int b = 6 ;		// 6 的二进制 -> 0110
    
    System.out.println(a&b);    // 输出-> 4    
    System.out.println(a|b);	// 输出-> 6
    System.out.println(a^b);	// 输出-> 2
    System.out.println(a<<1);   // 输出-> 8  0100 -> 1000
    ```

    

- 条件运算符 

  - **三目运算符 ？： **

    ```java
    int a = 2 ;
    int b = 3 ;
    System.out.println((a<b)?"小":"大");    // 输出-> 小   
    /*
     *格式:  (逻辑表达式)？输出1:输出2
     *如果表达式是true 则输出1，否则输出2
     */
    
    ```

  

- 运算符的优先级

  ![b04](G:\0ASXTJAVA\Lesson\day02\day02\Day02self_summary\b04.png)



### 7、基本数据类型之间的转换

- **自动类型转换 (左边>右边)**

  ```java
  byte a = 10 ;
  int b = a ;
  System.out.print(b)   // 输出-> 10   
  
  /*
   * 类型转换的方向
   * 低------------------------------------------->高
   * byte —> short,char—>int —>long—>float —>double
   */
  ```

- **强制类型转换 (左边<右边)**

  ```java
  int a = 270 ;
  byte b = (byte)n;
  System.out.print(b)   // 输出-> 14   
  
  /*
   * 强转时，可能会丢失数据或失真
   * 当将一种类型强制转换成另一种类型，而又超出了目标类型的表示范围，
   * 就会被截断成为一个完全不同的值。
   * 00000000 00000000 00000001 00001110
   *								 ↓
   *                            00001110
   */
  ```

- **特例**

  - 可以将整型常量 **直接赋值** 给 byte,short, char等类型变量，**而不需要进行强制类型转换**，只要 **不超出** 其表数范围即可。

    ```java
    short  b = 12;	    //合法
    short  b = 1234567;	   //非法
    ```

    

### 8、Scanner的用法

- 从键盘上获取想输入的信息。

- ```java
  import java.util.Scanner;   //Scanner 在util包内
  
  Scanner sc = new Scanner(System.in);
  int a = sc.nextInt();         //输入int型
  double b = sc.nextDouble();   //输入double型
  String s = sc.next();         //输入String型
  
  ```

  