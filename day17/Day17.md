# Java Development



## Day 17 网络编程

[TOC]

> 转载：https://www.cnblogs.com/midiyu/p/7875574.html

### 1. 计算机网络

> ​		把分布在不同地理区域的计算机与专门的外部设备用通信线路互连成一个规模大、功能
> 强的网络系统，从而使众多的计算机可以方便地互相传递信息，共享硬件、软件、数据信息
> 等资源。



#### 1.1  	计算机网络的主要功能

- **资源共享；**
- **信息传输与集中处理；**
- **均衡负荷与分布处理；**
- **综合信息服务**。



#### 1.2 	网络通信协议

> ​		计算机网络中实现通信必须有一些约定即通信协议，对速率、传输代码、代码结构、传 输
> 控制步骤、出错控制等制定标准。 



#### 1.3 	网络通信接口

> ​		为了使两个结点之间能进行对话，必须在它们之间建立通信工具(即接口)，使彼此之间 能
> 进行信息交换。接口包括两部分：
> ​		**1）硬件装置: 实现结点之间的信息传送。**
> ​		**2）软件装置: 规定双方进行通信的约定协议。** 

#### 1.4 	`IP`地址

> ​		`IP`，全称互联网协议地址，是指`IP`地址，意思是分配给用户上网使用的网际协议（英语：`InternetProtocol,IP`）的设备的数字标签。常见的`IP`地址分为`IPv4`与`IPv6`两大类。
>
> ​		`IP协议`中还有一个非常重要的内容，那就是给因特网上的每台计算机和其它设备都规定了一种地址，叫做`“IP 地址`”。由于有这种地址，才保证了用户在连网的计算机上操作时，能够高效而且方便地从千千万万台计算机中选出自己所需的对象来。

#### 1.5 	端口

> ​		QQ, msn, 迅雷/电驴/360. 通过端口，可以在一个主机上运行多个网络应用程序。端口是虚
> 拟的概念，并不是说在主机上真的有若干个端口。 

#### 1.6 	`URL`

> ​		在 WWW 上，每一信息资源都有统一的且唯一的地址，该地址就叫 `URL (Uniform ResourceLocator）`，它是 WWW 的统一资源定位符。 `URL 由 4 部分组成： 协议 、存放资源的主机域名、资源文件名和端口号`。如果未指定该端口号，则使用协议默认的端口。例如， http协议的默认端口为 80。
> ​		在 Java.net 包中提供了 `URL` 类，该类封装了大量复杂的涉及从远程站点获取信息的细节。 



------





### 2. 计算机网络层次模型



##### 2.1.1 	`OSI`参考模型

- **`OSI`参考模型的7个层次及其功能。**

![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day17/01.png)

- **物理层**

> ​		物理层处于`OSI`的最底层，是整个开放系统的基础。物理层涉及通信信道上传输的原始比特流(bits)，它的功能主要是为数据端设备提供传送数据的通路以及传输数据。

- **数据链路层**

> ​		数据链路层的主要任务是实现计算机网络中相邻节点之间的可靠传输，把原始的、有差错的物理传输线路加上数据链路协议以后，构成逻辑上可靠的数据链路。需要完成的功能有链路管理、成帧、差错控制以及流量控制等。其中成帧是对物理层的原始比特流进行界定，数据链路层也能够对帧的丢失进行处理。

- **网络层**

> ​		网络层涉及源主机节点到目的主机节点之间可靠的网络传输，它需要完成的功能主要包括路由选择、网络寻址、流量控制、拥塞控制、网络互连等。

- **传输层**

> ​		传输层起着承上启下的作用，涉及源端节点到目的端节点之间可靠的信息传输。传输层需要解决跨越网络连接的建立和释放，对底层不可靠的网络，建立连接时需要三次握手，释放连接时需要四次挥手。

- **会话层和表示层**

> ​		会话层的主要功能是负责应用程序之间建立、维持和中断会话，同时也提供对设备和结点之间的会话控制，协调系统和服务之间的交流，并通过提供单工、半双工和全双工3种不同的通信方式，使系统和服务之间有序地进行通信。
>
> ​		表示层关心所传输数据信息的格式定义，其主要功能是把应用层提供的信息变换为能够共同理解的形式，提供字符代码、数据格式、控制信息格式、加密等的统一表示。

- **应用层**

> ​	应用层为`OSI`的最高层，是直接为应用进程提供服务的。其作用是在实现多个系统应用进程相互通信的同时，完成一系列业务处理所需的服务。



##### 2.1.2 	`TCP/IP`参考模型

- (**传输控制/网际协议 **`Transfer Controln Protocol/Internet Protocol`)

![02](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day17/02.png)

> ​		`OSI`参考模型的初衷是提供全世界范围的计算机网络都要遵循的统一标准，但是由于存在模型和协议自身的缺陷，迟迟没有成熟的产品推出。`TCP/IP`协议在实践中不断完善和发展取得成功，作为网络的基础，`Internet`的语言，可以说没有`TCP/IP`协议就没有互联网的今天。
>
> ​		`TCP/IP`协议是一个开放的网络协议簇，它的名字主要取自最重要的网络层IP协议和传输层TCP协议。`TCP/IP`协议定义了电子设备如何连入因特网，以及数据如何在它们之间传输的标准。`TCP/IP`参考模型采用4层的层级结构，每一层都呼叫它的下一层所提供的协议来完成自己的需求，这4个层次分别是：`网络接口层、互联网层(IP层)、传输层(TCP层)、应用层`。



------



### 3. 网络协议



#### 3.1 	`TCP`协议



##### 3.1.1 	TCP协议概要

> ​		`TCP（Transmission Control Protocol ，传输控制协议）`是面向连接的传输层协议。`TCP层是位于IP层之上，应用层之下的中间层`。不同主机的应用层之间经常需要可靠的、像管道一样的连接，但是IP层不提供这样的流机制，而是提供不可靠的包交换。
>
> ​		**TCP协议采用字节流传输数据**。
>
> ​		TCP是面向连接的，所谓面向连接，就是当计算机双方通信时必需先建立连接，然后数据传送，最后拆除连接三个过程 。



##### 3.1.2 	三次握手与四次挥手

> https://www.cnblogs.com/midiyu/p/7875574.html



#### 3.2 	`UDP`协议



------





### 4.  Java 网络编程



> ​		Java的网络编程主要涉及到的内容是Socket编程，那么什么是Socket呢？简单地说，Socket，套接字，就是两台主机之间逻辑连接的端点。TPC/IP协议是传输层协议，主要解决数据如何在网络中传输，而HTTP是应用层协议，主要解决如何包装数据。Socket，本质上就是一组接口，是对TCP/IP协议的封装和应用(程序员层面上)。



#### 4.1 	基于 TCP 协议的 `SOCKET` 编程和通信 

> ​		`Socket编程主要涉及到客户端和服务器端两个方面`，首先是在服务器端创建一个服务器套接字`(ServerSocket)`，并把它附加到一个端口上，服务器从这个端口监听连接。端口号的范围是0到65536，但是0到1024是为特权服务保留的端口号，我们可以选择任意一个当前没有被其他进程使用的端口。
>
> ​		客户端请求与服务器进行连接的时候，根据服务器的域名或者IP地址，加上端口号，打开一个套接字。当服务器接受连接后，服务器和客户端之间的通信就像输入输出流一样进行操作。

![03](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day17/03.png)

##### 4.1.1 	"请求-响应"模式

- `Socket` 类 ：发送 TCP 消息。
- `ServerSocket`类 ： 创建服务器。



##### 4.1.2 	套接字 （`Socket`）

> ​		`套接字`是一种进程间的数据交换机制。这些进程可以在同一机器上，也可以在通过网络连接的不同机器上。 
>
> ​		**换句话说，套接字起到通信端点的作用。 单个套接字是一个端点，而一对套接字则构成一个双向通信信道，使非关联进程可以在本地或通过网络进行数据交换。 一旦建立套接字连接，数据即可在相同或不同的系统中双向或单向发送，直到其中一个端点关闭连接。**
>
> ​		套接字与主机地址和端口地址相关联。主机地址就是客户端或服务器程序所在的主机的 ip 地址。端口地址是指客户端或服务器程序使用的主机的通信端口 。
>
> ​		在客户端和服务器中，分别创建独立的 Socket，并通过 Socket 的属性，将两个 Socket 进行连接，这样，客户端和服务器通过套接字所建立连接使用输入输出流进行通信。**`TCP/IP `套接字是最可靠的双向流协议，使用 `TPC/IP`可以发送任意数量的数据。**
>
> ​		实际上，套接字只是计算机上已编号的端口。 如果发送方和接收方计算机确定好端口，他
> 们就可以通信了。 



##### 4.1.3 	`TCP/IP`通信连接的简单过程

> ​		位于 A 计算机上的 `TCP/IP `软件向 B 计算机发送包含端口号的消息， B 计算机的 `TCP/IP `软件接收该消息，并进行检查，查看是否有他知道的程序正在该端口上接收消息。如果有，他就将该消息交给这个程序。		**要使程序有效地运行，就必须有一个客户端和一个服务器。** 



- **通过 `Socket` 的编程顺序**：
  - 1） 创建 `服务器 ServerSocket`，在创建时，定义 `ServerSocket` 的监听端口（在这个端口接收
    客户端发来的消息！）
  - 2）`ServerSocket` 调用 `accept()`方法，**使之处于阻塞状态。**
  - 3）创建`客户机 Socket`，**并设置服务器的 IP 及端口。**
  - 4）客户机发出连接请求，建立连接。
  - 5）分别取得服务器和客户端`Socket 的 InputStream 和 OutputStream`。
  - 6）利用 `Socket 和 ServerSocket `进行数据传输。 



##### 4.1.4  测试代码

> （一） 客户端和服务端相互通信（交换数据和对象）

- **服务端**

  ```java
  public class Server {
  
  	public static void main(String[] args) throws IOException, ClassNotFoundException {		
  		//服务端
  		ServerSocket server = new ServerSocket(8080);
          
  		System.out.println("等待接收");
  		Socket client = server.accept();
  		//读取客户端发过来的字节流信息
  		InputStream is = client.getInputStream();
  		//			byte []bs = new byte[1024];
  		//			int len = is.read(bs);
  		//			System.out.println(new String(bs,0,len));
  
  		//读取客户端发过来的对象流
  		ObjectInputStream ois = new ObjectInputStream(is);
  
  		User user = (User)ois.readObject();
  		System.out.println(user.getName()+user.getPsw());
  
  		//向客户发生信息
  		OutputStream os = client.getOutputStream();
  		os.write("客服：在的".getBytes());
          
          is.close();
  		ois.close();
  		os.close();
  	}
  }
  ```

- 客户端 + User

  ```java
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.ObjectOutputStream;
  import java.io.OutputStream;
  import java.net.Socket;
  import java.net.UnknownHostException;
  
  public class Client {
  
  	public static void main(String[] args) throws UnknownHostException, IOException {
  		
  		//客户端
  		Socket clinet = new Socket("Localhost",8080);
  		User  user = new User("旺财","123");
  		
  		//向服务端发送字节流信息
  		OutputStream os = clinet.getOutputStream();
  //		os.write("客户：在吗".getBytes());
  //		os.write("这是我的信息：".getBytes());
  //		clinet.shutdownOutput();
  		
  		//向服务端发生对象流信息
  		ObjectOutputStream oos = new ObjectOutputStream(os);
  		oos.writeObject(user);
  		
  		clinet.shutdownOutput();
  		
  		//从服务端接收字节流信息
  		InputStream is = clinet.getInputStream();
  		byte bs[] = new byte[1024];
  		int len = is.read(bs);
  		System.out.println(new String(bs,0,len));
  
  		//关闭获取
  		oos.close();
  		os.close();
  		clinet.close();
  
  	}
  }
  
  import java.io.Serializable;
  
  public class User implements Serializable{
  	private String name;
  	private String psw;
  	public User() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public User(String name, String psw) {
  		super();
  		this.name = name;
  		this.psw = psw;
  	}
  	//省略 set get
  }
  ```



> （二）  利用多线程实现多客户端同时对服务端进行信息交互

- **服务端**

  ```java
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.ObjectInputStream;
  import java.io.OutputStream;
  import java.net.ServerSocket;
  import java.net.Socket;
  
  public class Server {
  	public static void main(String[] args) throws IOException, ClassNotFoundException {
  		
  		//服务端
  		ServerSocket server = new ServerSocket(8080);
  		//循环接收客户端发来的信息
  		while(true)  
  		{
  			Socket client = server.accept();
  			new ServerThread().run(client);
  		}
  	}
  
  }
  ```

- **接口**

  ```java
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.ObjectInputStream;
  import java.io.OutputStream;
  import java.net.ServerSocket;
  import java.net.Socket;
  
  public class ServerThread extends Thread{
  	public void run(Socket client) {
  		try {
  			
  			//读取客户端发过来的字节流信息
  			InputStream is = client.getInputStream();
  			//读取客户端发过来的对象流
  			ObjectInputStream ois = new ObjectInputStream(is);
  			User user = (User)ois.readObject();
  			System.out.println(user.getName()+user.getPsw());
  
  		} catch (IOException | ClassNotFoundException e) {
  			e.printStackTrace();
  		}
  	}
  }
  ```

  

- **客户端+User**

  ```java
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.ObjectOutputStream;
  import java.io.OutputStream;
  import java.net.Socket;
  import java.net.UnknownHostException;
  public class Client {
  
  	public static void main(String[] args) throws UnknownHostException, IOException {
  		
  		//客户端
  		for(int i=0;i<5;i++)
  		{
  			Socket clinet = new Socket("Localhost",8080);
  			User  user1 = new User("旺财1","123");
  
  			//向服务端发送字节流信息
  			OutputStream os = clinet.getOutputStream();	
  			//向服务端发生对象流信息
  			ObjectOutputStream oos = new ObjectOutputStream(os);
  			oos.writeObject(user1);
  			//关闭获取
  			clinet.shutdownOutput();
  			oos.close();
  			os.close();
  			clinet.close();
  		}
  	}
  }
  /---------User-----------/
  import java.io.Serializable;
  
  class User implements Serializable{
  	
  	private String name;
  	private String psw;
  	public User() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public User(String name, String psw) {
  		super();
  		this.name = name;
  		this.psw = psw;
  	}
     	//省略 set get
  	}
  }
  ```

  

#### 4.2 UDP 通信的实现



##### 4.2.1 UDP

- 



##### 4.2.2 	`DatagramSocket` 

- `DatagramSocket`：用于发送或接收数据包 

> ​		当服务器要向客户端发送数据时，需要在服务器端产生一个 `DatagramSocket 对象`，在客户端产生一个 `DatagramSocket 对象`。服务器端的 `DatagramSocket `将 `DatagramPacket` 发送到网络上，然后被客户端的` DatagramSocket` 接收。
>
> ​		**`DatagramSocket` 有两种构造函数。一种是无需任何参数的，常用于客户端。 另一种需要指定端口，常用于服务器。**
> ​		**常用方法： send,receive, close** 



##### 4.2.3 	`DatagramPacket `

- `DatagramPacket`：数据容器（封包）的作用 

> ​		**常用方法：构造函数、 getAddrress(获取发送或接收方计算机的 Ip 地址)、 getData(获取发送或接收的数据)， setData(设置发送的数据)** 



##### 4.2.4 	测试代码

> UDP 通信编程基本步骤：
> 1. 创建客户端的 `DatagramSocket`，创建时，定义客户端的监听端口
> 2. 创建服务器端的 `DatagramSocket`，创建时，定义服务器端的监听端口
> 3. 在服务器端定义 `DatagramPacket 对象`，封装待发送的数据包。
> 4. 服务器端将数据包发送出去
> 5. 客户端接收数据包 

- **一端接收一端发送  **

 `OneSend.java`

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class OneSend {
	public static void main(String[] args) throws IOException {
		//创建一个udp的套接字，并指定该套接字监听的端口
		DatagramSocket  ds = new DatagramSocket(9000);
		//创建数据包  往外丢数据
		DatagramPacket dp = new DatagramPacket("在吗".getBytes(), "在吗".getBytes().length, InetAddress.getLocalHost(),8000);
		//发生到指定的ip地址和端口
		ds.send(dp);
		//关闭套接字
		ds.close();
	}
}
```

`OneReceive.java`

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
public class OneReceive {
	public static void main(String[] args) throws IOException {
		//接收数据
		DatagramSocket ds = new DatagramSocket(8000);
		//创建一个数据包
		byte [] bs = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bs, bs.length);
		//用数据包接收数据
		ds.receive(dp);
		//输出数据
		System.out.println(new String(dp.getData(),0,dp.getData().length));
		System.out.println(new String(dp.getData(),0,dp.getLength()));
        //获取发送方的ip地址
		//System.out.println(dp.getAddress());
		ds.close();
	}
}
```



- **两端都可以接收和发生信息**

   `TwoSend.java`

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class OneReceive {

	public static void main(String[] args) throws IOException {
		//接收数据
		DatagramSocket ds = new DatagramSocket(8000);
		//创建一个数据包
		byte [] bs = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bs, bs.length);
		//用数据包接收数据
		ds.receive(dp);
		//输出数据
		System.out.println(new String(dp.getData(),0,dp.getData().length));
		System.out.println(new String(dp.getData(),0,dp.getLength()));
		ds.close();
	}
}
```

   `TwoReceive.java`

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class TwoReceive {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds =new DatagramSocket(8000);
		//创建一个数据包
		byte [] bs = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bs, bs.length);
		ds.receive(dp);
		//输出接受的信息
		System.out.println(new String(dp.getData(),0,dp.getLength()));
		//回复信息
		dp = new DatagramPacket("滚!".getBytes(),"滚!".getBytes().length,InetAddress.getLocalHost(),9000);
		ds.send(dp);
		ds.close();
	}
}
```

