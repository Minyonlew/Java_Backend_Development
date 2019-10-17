# Java Development



## Day 11 异常处理

[TOC]



### 导读

- **异常的定义**
  - **对于异常的情况，例如，可能造成程序崩溃的错误输入，Java使用一种称为 <u>异常处理(exception handing)</u>的错误捕获机制处理。**



- **处理错误**

  - 假设在一个 Java 程序运行期间出现了一个错误。**这个错误可能是由于文件包含了错误信息，或者网络连接出现问题造成的，也有可能是因为使用无效的数组下标， 或者试图使用一个没有被赋值的对象引用而造成的。用户期望在出现错误时， 程序能够采用一些理智的行为。** **如果由于出现错误而使得某些操作没有完成， 程序应该：**

    - 返回到一种安全状态，并能够让用户执行一些其他的命令；

    - 或者允许用户保存所有操作的结果，并以妥善的方式终止程序 。

      

  - **某个方法不能够采用正常的途径完整它的任务，就可以通过另外一个路径退出方法。**在这种情况下，**方法并不返回任何值， 而是抛出(throw) 一个封装了错误信息的对象。**需要注意的是，**这个方法将会立刻退出，并不返回任何值。 此外， 调用这个方法的代码也将无法继续执行，取而代之的是， 异常处理机制开始搜索能够处理这种异常状况的 <u>异常处理器 (exception handler)</u>** 。



### 1.1 异常分类

- **在Java中，异常对象都是派生于<u>Throwable</u>类的一个实例。如果Java中内置的异常类不能够满足需求，用户可以创建自己的异常类。**

  

- **Java异常层次结构图**

![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day11/Day11self_summary/01.png)



- -  **所有的异常都是由 Throwable 继承而来，但在下一层立即分解为两个分支：** **<u>Error</u> 和** **<u>Exception</u>**:

    - **Error 类** 层次结构描述了 Java 运行时系统的内部错误和资源耗尽错误。 应用程序不应该抛出这种类型的对象。 如果出现了这样的内部错误， 除了通告给用户，并尽力使程序安全地终止之外， 再也无能为力了。这种情况很少出现。 

    - 在设计 Java 程序时， **需要关注 Exception 层次结构。** 这个层次结构又分解为**两个分支：一个分支派生于 RuntimeException ; 另一个分支包含其他异常。**

      **划分两个分支的规则是：** **由程序错误导致的异常属于 RuntimeException ; 而程序本身没有问题， 但由于像 I/O 错误这类问题导致的异常属于其他异常。**  **<u>（“如果出现 RuntimeException 异常， 那么就一定是你的问题 ”）</u>**。



- Java语言规范将  **派生于 Error 类 或 RuntimeException 类 的所有异常称为 <u>非受查( unchecked ) 异常</u>;** 

  **所有其他的异常称为 <u>受查(checked) 异常</u>** 。

  - **Checked 异常**
    - 这类异常的产生并不是程序本身的问题，通常由外界因素造成的。为了预防这些异常产生时造成程序中断或得不到正确的结果，java要求编写可能产生这类异常的程序代码时，一定要去做异常处理。

### 1.2 声明受查异常

- 在自己编写方法时， **不必将所有可能抛出的异常都进行声明。至于什么时候需要在方法中用 throws 子句声明异常， 什么异常必须使用 throws 子句声明**， 需要记住在遇到下面 4 种情况时应该抛出异常：
  - 1 ) 调用一个抛出受査异常的方法， 例如， FilelnputStream 构造器；
  - 2 ) 程序运行过程中发现错误， 并且利用 throw语句抛出一个受查异常；
  - 3 ) 程序出现错误， 例如，a[-l]=0 会抛出一个 ArraylndexOutOffloundsException 这样的非受查异常；
  - 4）Java 虚拟机和运行时库出现的内部错误。



- **如果出现前两种情况之一， 则必须告诉调用这个方法的程序员有可能抛出异常。因为任何一个抛出异常的方法都有可能是一个死亡陷阱。 如果没有处理器捕获这个异常，当前执行的线程就会结束**。

- **对于那些可能被他人使用的 Java 方法， 应该根据异常规范(exception specification), 在方法的首部声明这个方法可能抛出的异常。** 

  - ```java
    class TestException
    {
    	//...
        public void testFunc(String s) throws FileNotFoundException,EOFException
        {
             //如果一个方法有可能抛出多个受查异常类型， 那么就必须在方法的首部列出所有的异常
             //类。每个异常类之间用逗号隔开。
    	}
    }
    
    ```

- **总之，一个方法必须声明所有可能抛出的受查异常， 而非受查异常要么不可控制(Error),要么就应该避免发生 (RuntimeException)。 如果方法没有声明所有可能发生的受查异常， 编译器就会发出一个错误消息。** 





### 1.3 抛出异常以及创建异常类



- **除了声明异常之外， 还可以捕获异常。这样会使异常不被抛到方法之外，也不需要 throws 规范。** 

  - ```java
    /*
    	假设已经自定义了一个 AgeException类 用来检测 输入的年龄是否大于限定值的异常
        age的范围（0~200）
    */
    public class AgeException extends Exception{
    
    	public AgeException() {
    		super();
    	}
    }
    ```

    

  - ```java
    public Person{
        private int age;
       //... 
        
        public void setAge(int age) throws AgeException {
    		if (age <= 200 && age > 0) {
    			this.age = age;
    		}else {
    			AgeException exp = new AgeException("年龄只能是0~200");
    //			手动产生一个异常，经过这个操作以后系统中就具有了一个异常  所以就要处理该异常
    			throw exp;
    		}
    		
    	}
        
    }
    
    ```



## 

### 2.1 捕获异常

- **如果某个异常发生的时候没有在任何地方进行 <u>捕获</u>，那程序就会终止执行，并在控制台上打印出异常信息， 其中包括异常的类型和堆栈的内容。** 

  - ![02](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day11/Day11self_summary/02.png)

  - ``` java
    //上图为 在 int i = sc.nextInt(); 中输入了字符串出现的异常
    ```

    

- **要想捕获一个异常， 必须设置 <u>try--catch</u> 语句块。最简单的 <u>try--catch</u> 语句块如下所示 :**

  - ```java
    Person person = new Person();
    		try {
    			person.setAge(10);         					 //可能会出现异常的代码
    			person.setGender("hi");
    		} catch (AgeException e) {      				//异常的类型
    			System.out.println("只能是0~200");
    		}
    		catch (GenderException e) {						//异常的类型
    			System.out.println("性别只能是男或女");
    		}
    ```

  - **如果在 try语句块中的任何代码抛出了一个在 catch 子句中说明的异常类， 那么**：

    - 1 ) 程序将跳过 try语句块的其余代码。 
    - 2 ) 程序将执行 catch 子句中的处理器代码。 

- **finally 子句**

  - **当代码抛出一个异常时， 就会终止方法中剩余代码的处理，并退出这个方法的执行。** 

  - 假若有些程序不管是不是发生了异常，都要执行时，就要采用 **finally子句** 。

  - ``` java
    import java.util.InputMismatchException;
    import java.util.Scanner;
    
    public class FinallyDemo {
    	public static void main(String[] args) {
    		Scanner input = new Scanner(System.in);
    		System.out.println("请输入被除数");
    		int n1 = 0;
    		int n2 = 0;
    		try {
    			//可能会产生异常的代码块
    			n1 = input.nextInt();
    			System.out.println("请输入除数");
    			n2 = input.nextInt();
    			System.out.println(n1/n2);
    		} catch (InputMismatchException e) {
    			//一旦发生了异常  并且匹配成功  要么就把异常的信息打印出来   要么就写入到日志文件
    			//e.printStackTrace();
    			System.out.println("输入的必须是数字");
    			return;
    		} catch (ArithmeticException e) {
    			System.out.println("发生了数学运算的异常");
    		} catch (Exception e) {
    			System.out.println("发生了未知异常");
    		}finally{
    			//finally 这个代码块  不管程序是否发生异常  总是会执行
    			//一般做一些关闭数据库连接   关闭io流等一些必须的操作
    			//System.exit(0);  只有手动退出虚拟机的时候   程序不会执行finally模块
    			//当代码块中有return的时候   先执行finally  再return
    			System.out.println("finally");
    		}
    		System.out.println("程序结束");
    	}
    }
    
    ```

    



### 3 throw 与 throws 的区别 

- **throw**

```java
//throw 是语句抛出一个异常  （可以理解为创建了一个异常）
public class demo {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc"; 
	    if(s.equals("abc")) { 
	      throw new InputMismatchException();//如果相等，则新创建一个InputMismatchException()
	    } else { 
	      System.out.println(s); 
	    } 
	}
}

```



- **throws**

  - ```java
    // throws是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常)  
    //当某个方法可能会抛出某种异常时用于throws 声明可能抛出的异常，然后交给上层调用它的方法程序处理
    
    public static void function() throws NumberFormatException{ 
    	    String s = "abc"; 
    	    System.out.println(Double.parseDouble(s)); 
    	  } 
     
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		try { 
    		      function(); 
    		    } catch (NumberFormatException e) { 
    		      System.err.println("非数据类型不能转换。"); 
    		      //e.printStackTrace(); 
    		    } 
    	}
    }
    
    ```



- **区别**

  - 通过上面的两个demo可以得知：

    1、throw用在方法体内，上面代码显示了，是直接在main方法体内；

       throws用在方法声明后面，表示再抛出异常，由该方法的调用者来处理。这个看上面的代码就理解了。

    2、throw是具体向外抛异常的，抛出的是一个异常实例；

       throws声明了是哪种类型的异常，使它的调用者可以捕获这个异常。

    3、throw，如果执行了，那么一定是抛出了某种异常了，而throws表示可能出现，但不一定。

    4、同时出现的时候，throws出现在函数头、throw出现在函数体，两种不会由函数去处理，真正的处理由函数的上层调用处理。

    ```
    
    第3大点转自：
    
    版权声明：本文为CSDN博主「阳光下是个孩子」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/kwy15732621629/article/details/52947963/
    ```

    