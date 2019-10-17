# Java Development



## Day 14 IO流

[TOC]

### 1.  文件以及流的概念



#### 1.1	文件

- **文件可认为是相关记录或放在一起的数据的集合。**
- **文件一般存放在硬盘、光盘等内。**

------



#### 1.2	流的概念

- **流是指一连串流动的字符，是以先进先出的方式发生信息的通道。**

  

  > 数据源																	目的地
  >
  > `InputStream`  ----| F | E | D | C | B | A |---> `OutputStream`



- **输入输出**

  - 所谓的输入输出，**是相对于程序(内存)来说的。**

  - XXX--> 程序  ：   输入

  - 程序--> XXX   :     输出

    

- **数据源**

  - **提供原始数据的原始媒介。常见的：数据库、文件、其他程序、内存、网络连接、IO设备。**

  - **数据源就像水箱，流就像水管中流着的水流，程序就是我们最终的用户。 流是一个抽象、动态的概念，是一连串连续动态的数据集合。**

    

- **流的分类**

  - 输入流、输出流（**数据方向**）；

    - > 输出流 --> `OutputStream` 和 `Writer` 作为基类
      >
      > ---------------------------------------------------------------
      >
      >  输入流 --> `InputStream` 和 `Reader` 作为基类

      

  - 字节流、字符流（**数据类型**）；

    - > 字节流 --> 字节输入流（`InputStream`基类） 、 字节输出流（`OutputStream`基类）。
      >
      > -------------------------------------------------------------------------------------------------------------------------
      >
      > 字符流 --> 字符输入流（`Reader`基类）、字符输出流（`Writer`基类）。
  >
      > 
    >
      > **Tips：通常以stream结尾都是字节流，以Reader、Writer结尾都是字符流。**
  
  ​    

  - 节点流、处理流（**数据功能**）。

    - 节点流：**可以直接从数据源或目的地读写数据。**

    - 处理流（包装流）：**不直接连接到数据源或目的地，是其他流进行封装。目的主要是简化操作和提高性能。**
  
    - > **比如说从某个文件中读取数据把这个文件当做一个大桶，现在用个管道直接连接在这个大桶上进行抽水此时这跟管道就是节点流；当感觉这个管道不够抽水用的了，在其外面套上一个大的抽水管道，此时这个大的管道就相当于处理流。**
  
    

------



#### 1.3	File类

- **在Java中，文件类以抽象的方式代表文件名和目录路径名。该类主要用于文件和目录的创建、文件的查找和文件的删除等。File对象代表磁盘中实际存在的文件和目录。**

 

| **构造方法摘要**                    |                                                              |
| ----------------------------------- | ------------------------------------------------------------ |
| `File(File parent, String child)`   | 根据  parent 抽象路径名和 child 路径名字符串创建一个新 `File` 实例。 |
| `File(String pathname)`             | 通过将给定路径名字符串转换为抽象路径名来创建一个新 `File` 实例。 |
| `File(String parent, String child)` | 根据  parent 路径名字符串和 child 路径名字符串创建一个新 `File` 实例。 |
| `File(URI uri)`                     | 通过将给定的 `file:` URI 转换为一个抽象路径名来创建一个新的 `File` 实例。 |

- **File类主要用法及其测试代码：**

  ```java
  import java.io.File;
  import java.io.IOException;
  public class TestFile {
  	public static void main(String[] args) throws IOException {
  		//通过File的构造方法创建一个对象
  		File file = new File("G:/0ASXTJAVA/Code/IOTest/test.jpg");
  		//判断路径指向的文件是否存在
  		if(!file.exists())
  		{
  			//创建一个新文件
  			file.createNewFile();
  			//创建一个目录 ，前提要求所要创建的目录的路径必须存在，如果路径不存在则创建失败
  			//file.mkdir();
  			
  			//创建一个目录，如果路径不存在，则将路径所需要的目录一起创建出来
  			file.mkdirs();
  		}
  		
  		//判断文件可读可写
  		System.out.println(file.canRead());
  		System.out.println(file.canWrite());
  		
  		//获取文件的绝对路径
  		System.out.println(file.getAbsolutePath());
  		//获取文件的相对路径
  		System.out.println(file.getCanonicalPath());
  		//获取文件的长度
  		System.out.println(file.length());
  		//构造一个表示此抽象路径名的 file: URI
  		System.out.println(file.toURI());
  	}
  }
  ```



------

### 2. 文件的读写



#### 2.1	文件的读写

- **文本文件的读写**
  - 用`FileInputStream `和 `FileOutputStream`读写文本文件；
  - 用`BufferedReader `和 `BufferedWriter`读写文本文件。
- **二进制文件的读写**
  - 使用`DataInputStream` 和 `DataOutputStream`读写二进制文件以及基本数据类型数据的读写。
- **对象的读写**
  - 使用`ObjectInputStream` 和`ObjectOutputStream`读写对象(序列化与反序列化)。

------



#### 2.2	对文件以字节形式进行读操作

##### 2.2.1	`FileInputStream`

- `FileInputStream` 从文件系统中的某个文件中获得输入字节。哪些文件可用取决于主机环境。
- `FileInputStream` 用于读取如图像数据之类的原始字节流。要读取**字符流**，请考虑使用`FileReader`。

 

| **构造方法摘要**                         |                                                              |
| :--------------------------------------- | ------------------------------------------------------------ |
| `FileInputStream (File file)`            | 通过打开一个到实际文件的连接来创建一个 `FileInputStream`，该文件通过文件系统中的  `File` 对象 `file` 指定。 |
| `FileInputStream (FileDescriptor fdObj)` | 通过使用文件描述符 `fdObj` 创建一个  `FileInputStream`，该文件描述符表示到文件系统中某个实际文件的现有连接。 |
| `FileInputStream (String name)`          | 通过打开一个到实际文件的连接来创建一个 `FileInputStream`，该文件通过文件系统中的路径名  `name` 指定。 |



- **`FileInputStream` 类主要用法及其测试代码：**

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

	public static void main(String[] args) throws IOException {
		//【1】搭建管道  链接数据源和目的地
		FileInputStream fis = new FileInputStream("G:/0ASXTJAVA/Code/IOTest/1.txt");
		
		//【2】 读取数据
		//一次读一个字节
		int n = -1;
		while((n=fis.read())!=-1){ //read() 返回：下一个数据字节；如果已到达文件末尾，则返回 -1。
			System.out.println((char)n);
			
		}
		
		//一次性将文件中所有字节都读到一个字节数组中
		byte [] bs = new byte[1024];
		int len = fis.read(bs);  //read(byte[] b)  返回：读入缓冲区的字节总数，如果因为已经到达文									件末尾而没有更多的数据，则返回 -1
		System.out.println(new String(bs,0,len));
		
		/*
		 * 将流中的一些数据读到字节数组中
		 * 从字节输入流中读两个字节
		 * 并且将这两个字节 放在数组中从下标为3的位置开始存放
		 * */
		byte [] bs2 = new byte[1024];
		//跳过去n个字节不读取
		fis.skip(3);
		int len2 = fis.read(bs2, 3, 2);
		System.out.println(new String(bs,3,len2));
        
        //读取文本文件的数据直到末尾
        int len3 = 0;
        while((len3=fis,read())!=-1)
        {
            //...操作
        }
		//关闭流对象
		fis.close();	
	}
}
```

------



#### 2.3	对文件以字节形式进行写操作

##### 2.3.1	`FileOutputStream`

 

| **构造方法摘要**                                        |                                                              |
| :------------------------------------------------------ | ------------------------------------------------------------ |
| **`FileOutputStream(File file)`             **          | 创建一个向指定 `File` 对象表示的文件中写入数据的文件输出流。 |
| **`FileOutputStream(File file,  boolean append)` **     | 创建一个向指定 `File`  对象表示的文件中写入数据的文件输出流。 |
| **`FileOutputStream(FileDescriptor fdObj)` **           | 创建一个向指定文件描述符处写入数据的输出文件流，该文件描述符表示一个到文件系统中的某个实际文件的现有连接。 |
| **`FileOutputStream(String name)`            **         | 创建一个向具有指定名称的文件中写入数据的输出文件流。         |
| **`FileOutputStream(String name,  boolean append)`   ** | 创建一个向具有指定 `name` 的文件中写入数据的输出文件流。     |



- **`FileOutputStream` 类主要用法及其测试代码：**

```java
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {

	public static void main(String[] args) throws IOException {
		//创建一个操作文件的字节输出流
		//参数的布尔值的作用是规定   是否在文件原有的数据后面追加内容
		FileOutputStream fos=new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/1.txt",true);
		
		//向字节输出流里面写数据   数据最终写入文件，并且默认直接覆盖文件中原有的数据
		fos.write(98);  
		//一次写入一个字节数组
		fos.write("我好你好他好".getBytes());
		//将字节数组中的一部分写入文件
		fos.write("我好你好他好".getBytes(),2,4);  //向文件输入了 ： 好你
    }
}
```



##### 2.3.2	练习

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Testpractice {
	/*复制图片
	 * 将G:\盘指定的图片复制到当前项目中
	 * 需求分析：
	 * 使用字节的输入流FileInputStream读取字节
	 * 使用字节的输出流FileOutputStream写入文件
	 * */
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("G:/0ASXTJAVA/Code/IOTest/test.jpg");
		FileOutputStream fos=new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/test02.jpg");
		
		int len = 0;
		byte []bs = new byte[1024];
		while((len=fis.read(bs))!=-1)
		{
			fos.write(bs, 0, len);
		}
		fos.close();
		fis.close();
	}
}
```



------



#### 2.4	对文件以字符流形式进行读操作

##### 2.4.1	`FileReader`  与  `FileWriter`

- **既是节点流也是处理流**

> **Q:如何提高字符流读写取文本文件的效率？**
>
> **A:  -   读：使用`FileReader`类与`BufferedReader`类!!!**-**`BufferedReader`类是`Reader`类的子类，**
>
> ​	  **-   写：使用`FileWriter`类与`BufferedWriter`类!!!-`BufferedWriter`类是`Writer`类的子类。**
>
> 
>
> **将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入！！！**



##### 2.4.2	`BufferedReader` 

 

| **构造方法摘要**                           |                                                    |
| ------------------------------------------ | -------------------------------------------------- |
| **`BufferedWriter(Writer out)` **          | 创建一个使用默认大小输出缓冲区的缓冲字符输出流。   |
| **`BufferedWriter(Writer out,  int sz)` ** | 创建一个使用给定大小输出缓冲区的新缓冲字符输出流。 |

##### 2.4.3	`BufferedWriter`

 

| **构造方法摘要**                          |                                                  |
| ----------------------------------------- | ------------------------------------------------ |
| **`BufferedReader(Reader in)`        **   | 创建一个使用默认大小输入缓冲区的缓冲字符输入流。 |
| **`BufferedReader(Reader in,  int sz)` ** | 创建一个使用指定大小输入缓冲区的缓冲字符输入流。 |

- **`BufferedReader` 类 与 `BufferedWriter`类 主要用法及其测试代码**

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferRW {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("G:/0ASXTJAVA/Code/IOTest/1.txt");
		FileWriter fw = new FileWriter("G:/0ASXTJAVA/Code/IOTest/2.txt");
		
		BufferedReader bfr = new BufferedReader(fr);
		BufferedWriter bfw = new BufferedWriter(fw);
		
		String str = null;
		while((str = bfr.readLine())!=null)  //readLine() 返回：包含该行内容的字符串，不包含任何
		{									 //行终止符，如果已到达流末尾，则返回 null 
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}
		bfw.close();
		bfr.close();
		fw.close();
		fr.close();
	}
}
```



##### 2.4.3	练习(一)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*【1】使用File类的方法去创建一个文本文件，先进行判断
        如果没有则创建，如有有则先删除再创建
【2】使用BufferedWriter将如下文字   
            《虞美人》
          春花秋月何时了?
          往事知多少。
         写入【1】中所创建的文件
【3】再将【2】中写入的文件读取到控制台输出
 
 * */
public class TestPractice07 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("G:/0ASXTJAVA/Code/IOTest02/2.txt");
		if(f.exists())
		{
			f.delete();
		}
		f.createNewFile();

		FileWriter fw = new FileWriter("G:/0ASXTJAVA/Code/IOTest02/2.txt");
		BufferedWriter bfw = new BufferedWriter(fw);
		Scanner sc = new Scanner(System.in);
		
		String str = null;
		while(!"-1".equals(str=sc.next()))
		{
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}
		
		bfw.close();
	
		FileReader fr = new FileReader("G:/0ASXTJAVA/Code/IOTest02/2.txt");
		BufferedReader bfr = new BufferedReader(fr);
		String str2 =null;
		while((str2=bfr.readLine())!=null)
		{
			System.out.println(str2);
		}
	}
}
```

##### 2.4.4	练习(二)

- `Person.java`

```java
/*
【1】创建User类，包含以下属性name:String,age:int,gender String,重写toString方法显示对象的信息
【2】使用BufferedWriter写入文件以“,”分隔
【3】使用BufferedReader读取信息并进行分割，还原成对象，调用对象的toString方法输出对象的信息
 * */
public class Person {
	private String name ;
	private int age;
	private String  gender;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	//省略set get 方法
	@Override
	public String toString() {
		return "Person name=" + name + "," + age + "," + gender;
	}
}
```

- `TestMain.java`

  ```java
  import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.FileReader;
  import java.io.FileWriter;
  import java.io.IOException;
  import java.util.ArrayList;
  
  public class TestMain {
  
  	public static void main(String[] args) throws IOException {
  		
  		ArrayList<Person> list = new ArrayList<Person>();
  		
  		list.add(new Person("旺财1",20,"男"));
  		list.add(new Person("旺财2",20,"男"));
  		list.add(new Person("旺财3",20,"男"));
  		list.add(new Person("旺财4",20,"男"));
  		
  		BufferedWriter bfw = 
            new BufferedWriter(new FileWriter("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
  		for (int i = 0; i < list.size(); i++) {
  			Person p = list.get(i);
  			bfw.write(p.toString());
  			bfw.newLine();
  			bfw.flush();
  		}
  		bfw.close();
          
  	BufferedReader bfr=
         new BufferedReader (new FileReader("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
  		String str = null;
  		while((str=bfr.readLine())!=null)
  		{
  			String [] strs = str.split(",");
  			Person p = new Person(strs[0],new Integer(strs[1]),strs[2]);
  			System.out.println(p);
  		}
  		bfr.close();
  	}
  }
  ```



------



### 3. 转换流



#### 3.1	字节流转换为字符流

> - **首先认识一下字节流与字符流。**程序中的输入输出都是通过流的形式保存的，流中保存的全是字节文件。根据处理数据类型不同可以分为字节流和字符流。字节流是字符流的基础。
> - **字节流**：字节流处理单元为一个字节，操作字节和字节数组。如果是音频、图片等建议用字节流。
> - **字符流**：字符流处理单元为两个字节的UNICODE字符，操作字符家、字符数组和字符串，对多国语言支持性较好，如果是文本建议用字符流。

- 通过 `InputStreamReade`r 和 `OutputStreamWriter` 可以实现 `字节流转换为字符流` 。

------



#### 3.2	读写文件时编码格式问题

> 同样的程序在Mac上可以正常运行而在Windows上返回结果错误，原因就是Linux与Windows的默认编码方式不同，而程序没有设置编码方式自动采用了默认的编码方式，所以会导致错误发生。

- **转换流有一个好处，就是读取和写入的时候都可以指定编码格式，如果需要编码格式就用`InputStreamReader`和`OutputStreamWriter`。如果不用编码格式就用`FileReader` 和`FileWriter`**

```java 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
/*
 * FileReader  只能使用系统默认的编码格式将文件中的字节读成字符
 * FileWriter  只能使用系统默认的编码格式将字符拆分成字节写入文件
 * 
 * 如果使用的编码格式不是系统默认的编码格式   
 * 		需要使用转换流  将读取到的字节流转换为对应编码格式的字符流
 * 		需要使用转换流  将字符流按照对应的 编码格式转换为字节流保存到文件
 * 
 * 		InputStreamReader
 * 		使用指定的编码格式，将文件中的字节读成字符
 * 		OutputStreamWriter
 * 		使用指定的编码格式  将要输出的字符 拆分成字节   写入文件
 * */

public class TestMain {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(
            new FileInputStream("G:/0ASXTJAVA/Code/IOTest/3.txt"),"UTF-8");
		int len = 0;
		while((len=isr.read())!=-1){
			System.out.println((char)len);
		}
		isr.close();
		
		OutputStreamWriter osw = new OutputStreamWriter(
            new FileOutputStream("G:/0ASXTJAVA/Code/IOTest/3.txt"));
		osw.write("你好");
		osw.flush();
		osw.close();
	}
}
```



------



### 4. 不用Scanner 如何获取数据

> **1.5版本产生,目的是方便使用输入流  Scanner 是一个输入流，数据源可以是键盘也可以是文件。**



#### 4.1	练习

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;
import org.omg.CORBA.portable.OutputStream;

/*
 * 使用键盘录入(System.in)，将如下诗歌写入文件
            《虞美人》
          春花秋月何时了?
          往事知多少。

再将写入的文件读取到控制台输出System.out
（不用Scanner里面的System.in 和 system.out 如何实现输入和输出）
*/
public class TestPractice02 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		//转化为字符流
		InputStreamReader isr = new InputStreamReader(is);
		//将字符流转换为缓冲字符流
		//用来代替System.in
		BufferedReader bfr = new BufferedReader(isr);
		
		//将输入的写进文件里
		BufferedWriter bfw = new BufferedWriter(
            new FileWriter("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		
		String str= null;
		
		while(!"-1".equals(str=bfr.readLine()))
		{
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}
		bfw.close();
		bfr.close();
		isr.close();
		//以上是写进文件里
		
		//读取文件里的内容
		Scanner sc = new Scanner(new File("G:/0ASXTJAVA/Code/IOTest02/1.txt"));
		//用来代替system.out输出
		BufferedWriter bfw2 = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(sc.hasNextLine()){
			
			bfw2.write(sc.nextLine());
			bfw2.newLine();
			bfw2.flush();
		}
		
		bfr.close();
		bfw.close();
		sc.close();
	}
}
```



### 5. 操作对象的流



#### 5.1	序列化

>   	  简单说就是为了**保存在内存中的各种对象的状态**（也就是实例变量，不是方法），**并且可以把保存的对象状态再读出来。**虽然你可以用你自己的各种各样的方法来保存object states，但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化。



------



#### 5.2	序列化对象: 



> 序列化对象：   `ObjectOutputStream`
>
> 反序列化对象：`ObjectInputStream`
>
> 将对象直接写入到文件中,并且操作的对象必须实现 `Serializable` 的接口

- **常见问题**
  - **类必须实现`Serializable`接口 。**
  - 给类加个序列化编号，给类定义一个标记，新的修改后的类还可以操作曾经序列化的对象。
  - 静态是不能被序列化的，序列化只能对堆中的进行序列化 ，不能对“方法区”中的进行序列化。
  - **不需要序列化的字段前加 `transient`。**


- **测试代码：**

  ```java
  import java.io.BufferedOutputStream;
  import java.io.BufferedInputStream;
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.ObjectInputStream;
  import java.io.ObjectOutputStream;
  import java.io.Serializable;
  
  public class TestObjectInOut {
  	/*
  	 * 1.将对象写入到文件（序列化）再读出（反序列化）
  	 * 2.读出的顺序与写入保持一致
  	 * */
  	public static void main(String[] args) throws  IOException, ClassNotFoundException {
  		//写入文件 --> 序列化
  		ObjectOutputStream  oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
  		
  		//写入 操作数据类型 + 数据
  		oos.writeUTF("你好");
  		oos.writeInt(18);
  		oos.writeBoolean(false);
  		oos.writeChar('a');
  		
  		//写入对象
  		oos.writeObject("字符串对象");
  		Employee emp = new Employee("大黄",2000);
  		oos.writeObject(emp);
  		oos.flush();
  		oos.close();
  		
  		// 读取 -->反序列化
  		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
  		// 顺序与写出一致
  		String msg = ois.readUTF();
  		int age = ois.readInt();
  		boolean flag = ois.readBoolean();
  		char ch = ois.readChar();
  		System.out.println(flag);
  		// 对象的数据还原
  		Object str = ois.readObject();
  		Object employee2 = ois.readObject();
  
  		if (str instanceof String) {
  			String strObj = (String) str;
  			System.out.println(strObj);
  		}
  		if (employee2 instanceof Employee) {
  			Employee empObj = (Employee) employee2;
  			System.out.println(empObj.getName() + "-->" + empObj.getSalary());
  		}
  		ois.close();
  
  	}
  }
  
  class Employee implements Serializable{  //要序列化的对象需要实现Serializable接口
  	private transient String name; //该数据不需要序列化
  	private double salary;
  	public Employee() {
  	}
  	public Employee(String name, double salary) {
  		this.name = name;
  		this.salary = salary;
      }
     //省略get set 方法	
  }
  
  ```

  

### 6. **操作基本数据的流**



#### 6.1 `DataInputStream`

```java
DataInputStream dis=new DataInputStream(new FileInputStream("data.txt"));
int num=dis.readInt();
boolean isFind=dis.readBoolean();
double price=dis.readDouble();
String str=dis.readUTF();
System.out.println(num+"\t"+isFind+"\t"+price+"\t"+str);
```

#### 6.2 `DataOutputStream`

```java
DataOutputStream dos= new DataOutputStream(new FileOutputStream("data.txt"));
dos.writeInt(234);
dos.writeBoolean(false);
dos.writeDouble(9943.00);
dos.writeUTF("中国");
dos.close();

```



### 7. 总结梳理

![01.png](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day14/Day14self_summary/01.png)

