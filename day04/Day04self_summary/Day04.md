# Java Development



### Day 04  方法   一维数组



### 1、方法

- 封装在一起来执行操作语句对的集合，用来完成某个功能。



 - **定义方法**

   ``` java
   /*
   	[修饰符] 方法返回值类型    方法名 （形参列表）｛
   	
   			方法体 
   
   			return 返回值
       ｝
   */
   ```

   ```java
   public static  int add(int a ,int b , int c){
       
       int k = a + b + c;
       return k;
       
    }
   
   public static void main(String[] args){   //方法的调用
       
       int i = 3 , j = 4 , k = 5 ;
       int result = add(i,j,k);
   }
   /*
   	-修饰符：封装性时再讲，决定了方法的工作范围
   	-返回值类型：必选，如果没有返回值，须写void。方法只能返回一个值
   	-方法名：
   	-参数列表：可以0个、1个、多个，需要同时说明类型。称为形式参数
   	-方法体：完成具体功能。如果有返回值，必须有return语句；如果没有返回值，默认最后一条语句是		 return，可以省略。
   */
   ```

   

-	**方法的重载**

  -	在一个类中，可以定义具有相同名字，但参数类型不同的多个方法。
  -	在调用方法时，会根据不同的参数表选择对应的方法。

  

  - **注意**：

    - 只有 **返回值不同 **  **不能构成方法的重载**

      ```java
      int a (String str){}
      
      void a (String str){}
      ```

    - 带有  **同种类型，但顺序不同的形参** 的方法 不能构成重载

      ```java
      int a (int b,int c){}
      int a (int c,int b){}
      ```

      

  

​		

### 2、一维数组   （引用类型）

- **数组是** **相同类型数据的**  **有序集合**

  - 相同类型的若干个数据，按照一定先后顺序排列组合而成。

  - 每个数据称作为一个 **数组元素**。

  - 每个数组元素可以通过 **下标** 来访问。

  - 数组一旦被创建，其大小就不能被改变，**即长度确定**

  - **数组元素** 必须是相同类型。




- **声明数组**

  ```java
  //type[] arrayName;
  //type arrayName[];
  
  //声明int类型数组
  int arr[] = new int[10];
  int arr[] = {10,20,30};
  ```

  

- **数组内存分析**

  - 数组是 **引用类型**，所以其内存分配跟基本数据类型不一样。

  

![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day04/Day04self_summary/01.png)

- 
  - 由上图易知，在 **栈内存中** 存储的仅仅是 **数组引用变量**，**数组元素和数组变量在内存里是分开存放的。**
  - 引用变量存在 **栈内存** ，而数组对象存在 **堆内存中**。





- 

  - 通过以下例子对 **数组赋值的操作** 进行图解。

    ```java
    //定义并静态初始化数组
    int [] array1={1,2,3};      //大小为 3
    //定义并动态初始化数组
    int []array2=new int[4];    //大小为 4
    
    //此时array2 的长度是多少？
    array2=array1;   			//A：3
    
    ```

    ![02](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day04/Day04self_summary/02.png)



- **增强for循环  （foreach）**

  ```java
  //int  指的是数组中元素的类型
  //i 是迭代变量,就是临时变量array1 是数组的名字
  	for(int i : array1)
      {
          System.out.print(i);    //遍历数组array1，通过i来存储当前遍历的元素，从而将元素逐一打印
      }
  
  ```

  

- **数组常用方法**

  ```java
  int array  [] = new int[]{1,2,3,5,4,7}
  int array1 [] = new int[]{1}
  
  //升序排序   (运用的是快排)
  Arrays.sort(array);
  
  //元素查找  返回要查找的元素的下标，没有则返回-1 （二分查找法）
  int index = Arrays.binarySearch(array,5)   //index = 3
      
  //判断两个数组是否相等 
  boolean b = Arrays.equals(array,array1)     //b = false
   
  //数组的拷贝  长度大于原数组  也不会抛异常  多出来的用0补充，3为新数组长度
  int [] newArray = Arrays.copyOf(array, 3);
  
  ```

  

