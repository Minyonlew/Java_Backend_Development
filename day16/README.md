# Java Development



## Day 16 多线程技术

[TOC]

### 1.线程状态

> 原文链接：https://blog.csdn.net/wanliguodu/article/details/81005560

#### 1.1	线程状态图

##### ![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day16/01.png)



#### 1.2 	线程的5种状态

- 线程包括5种状态： 
  - 1、**新生（New）：线程对象被创建时，该线程对象就处于新生状态**。它只会短暂地处于这种状态。此时它已经分配了必须的系统资源，并执行了初始化。例如，Thread thread = new Thread()。 
  - 2、**就绪（Runnable）：称为“可执行状态”。线程对象被创建后，其它线程调用了该对象的start()方法，从而来启动该线程。**例如，thread.start()。处于就绪状态的线程，随时可能被CPU调度执行。 
  - 3、**运行（Running）：线程获取CPU权限进行执行。注意：线程只能从就绪状态进入运行状态。**在运行状态的线程执行自己的run方法中代码,直到等待某资源而阻塞或完成任何而死亡；如果在给定的时间片内没有执行结束，就会被系统给换下来回到等待执行状态。
  - 4、**阻塞（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。**直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分为三种： 
    - **（1）等待阻塞：通过调用线程的wait()方法，让线程等待某工作的完成。** 
    - **（2）同步阻塞：线程在获取synchronized同步锁失败（因为锁被其他线程占用），它会进入同步阻塞状态。** 
    - **（3）其他阻塞：通过调用线程的sleep()或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或是超时。或是I/O处理完毕时，线程重新转入就绪状态。** 
  - 5、**死亡（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。**线程死亡的原因有三个：一个是正常运行的线程完成了它的全部工作；另一个是线程被强制性地终止，如通过stop方法来终止一个线程【不推荐使用】；三是线程抛出未捕获的异常。



#### 1.4 	线程操作的相关方法

| **方法名称**                            | **描述**                                                     |
| --------------------------------------- | ------------------------------------------------------------ |
| public static Thread currentThread()    | 返回目前正在执行的线程                                       |
| public final String getName()           | 返回线程的名称                                               |
| public final int getPriority()          | 返回线程的优先级                                             |
| public final void setPriority(int    i) | 设定线程的优先级                                             |
| public final boolean   isAlive()        | 判断线程是否在活动，如果是，返回true,否则返回false           |
| public final void join()                | 调用该方法的线程强制执行，其它线程处于**阻塞**状态，该线程执行完毕后，其它线程再执行 |
| public static void sleep(long millis)   | 使用当前正在执行的线程休眠millis秒,线程处于**阻塞**状态      |
| public static void yield()              | 当前正在执行的线程暂停一次，允许其他线程执行,**不阻塞**，线程进入**就绪状态**,如果没有其他等待执行的线程，这个时候**当前线程就会马上恢复执行。** |
| public final void stop()                | 强迫线程停止执行。已过时。不推荐使用。                       |



#### 1.5 	方法的测试代码

```java
public class TestThreadFunction {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread mt = new MyThread();
		Thread tr = new Thread(mt);
		//得到当前线程   得到当前线程的名字
		System.out.println(tr.currentThread().getName());
		tr.start();
		//获取线程是否处于活跃状态   从调用了start方法就绪状态到死亡状态都属于活跃状态
		System.out.println(tr.isAlive());
		
		for (int i = 0; i < 50	; i++) {
			System.out.println(Thread.currentThread().getName()+"***"+i);
			if (i == 20) {
				//让mt线程强行插队执行，当tr没有执行完之前，其他所有线程都必须等待
				tr.join();
				//让线程礼让一次   让当前线程让出来cpu 的时间片段，让cpu重新去加载线程执行，并且当前线					程不会阻塞，从运行态直接进入就绪态
				Thread.yield();
			}
			Thread.sleep(100);
//			中断线程的休眠
//			mt.interrupt();
		}
	}
}

class MyThread implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {		
			//进程阻塞200毫秒
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}	
	}		
}
```

#### 1.6 	阻塞状态

- 有三种方法可以暂停Thread执行：
  - `sleep`：不会释放锁，`Sleep`时别的线程也不可以访问锁定对象。
  - `yield `: 让出CPU的使用权，**从运行态直接进入就绪态**。让CPU重新挑选哪一个线程进入运行状态。
  - `join `: 让线程强行插队执行，当tr没有执行完之前，其他所有线程都必须等待。



#### 1.7	sleep 与 wait 的区别（未完成！！）

#### 1.8 	[wait、notify/notifyAll 详解](https://www.cnblogs.com/moongeek/p/7631447.html)

------



### 2. 多线程的安全问题



#### 2.1 	`synchronized` 关键字概述

> ​		`synchronized`关键字是为了解决共享资源竞争的问题，共享资源一般是以对象形式存在的内存片段，但也可以是文件、输入/输出端口，或者是打印机。要控制对共享资源的访问，得先把它包装进一个对象。然后把所有要访问的这个资源的方法标记为`synchronized`。
>
> ​		`如果某个任务处于一个对标记为synchronized的方法的调用中，那么在这个线程从该方法返回之前，其他所有要调用类中任何标记为synchronized方法的线程都会被阻塞。所有对象都自动含有单一的锁（也称为监视器）。当在对象上调用其任意synchronized方法的时候，对象都被加锁，这时该对象上的其他synchronized方法只有等到前一个方法调用完毕并释放了锁之后才能被调用`。 
>   在Java中，每个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在的。当我们调用某个对象的`synchronized`方法时，就获得了该对象的同步锁，不同线程对同步锁的访问是互斥的。因为锁语句产生了一种互相排斥的效果，所以这种机制常常称为互斥量（`mutex`）。
> ————————————————————————————————————————————

#### 2.2 	synchronized基本原则和实例

##### 2.2.1 基本原则

- 我们将synchronized的基本规则总结为下面3条，并通过实例对它们进行说明。 
  - 第一条: `当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程对该对象的该synchronized方法或者synchronized代码块的访问将被阻塞`。 
  - 第二条:`当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程仍然可以访问该对象的非同步代码块`。 
  - 第三条`:当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程对该对象的其他的synchronized方法或者synchronized代码块的访问将被阻塞`。
    

##### 2.2.2 测试代码

- https://blog.csdn.net/wanliguodu/article/details/81005560

  

------



#### 2.3 synchronized方法和synchronized代码块



##### 2.3.1 	概述

>   `synchronized`方法是用synchronized修饰方法，这是一种粗粒度锁；这个同步方法（非static方法）无需显式指定同步监视器，同步方法的同步监视器是`this`，也就是调用该方法的对象。 
>   `synchronized代码块`是用`synchronized修饰代码块`，这是一种`细粒度锁`。线程开始执行同步代码块之前，必须先获得对同步监视器的锁定，任何时候只能有一个线程可以获得对同步监视器的锁定，当同步代码块执行完成后，该线程会释放对同步监视器的锁定。`虽然Java允许使用任何对象作为同步监视器，但同步监视器的目的就是为了阻止两个线程对同一个共享资源进行并发访问，因此通常推荐使用可能被并发访问的共享资源充当同步监视器`。
>
> ————————————————————————————————————————————



##### 2.3.2 	同步监视器

- `synchronized(obj){}`中的obj称为**同步监视器**。
- 同步代码块中同步监视器可以是任何对象，但是推荐使用共享资源作为同步监视器。
- **同步方法中无需指定同步监视器，因为同步方法的监视器是this，也就是该对象本身**。



##### 2.3.3	同步监视器的执行过程

- 第一个线程访问，锁定同步监视器，执行其中代码。

- 第二个线程访问，发现同步监视器被锁定，无法访问。

- 第一个线程访问完毕，解锁同步监视器。

- 第二个线程访问，发现同步监视器未锁，锁定并访问。

  

##### 2.3.4    synchronize块（未完成！！！）



#### 2.4 	多线程的安全问题测试

> **需求说明**：
>
> ​		张三和妻子各拥有一张银行卡和存折，可以对同一个银行账户进行存取款的操作，请使用多线程及同步方法模拟张三和妻子同时取款的过程。要求使用同步方法和同步代码块两种方式实现。
>
> **分析**：
>
> ​	定义Account类表示银行帐户。
>
> ​	定义两个线程分别实现张三和妻子取款的操作。



- **测试代码：**

- Account.java

  ```java
  public class Account {
  	private int money;
  
  	public Account(int money) {
  		super();
  		this.money = money;
  	}
  
  	public int getMoney() {
  		return money;
  	}
  
  	public void setMoney(int money) {
  		this.money = money;
  	}	
  }
  ```

- Zhangsan.java

  ```java
  public class ZhangSan extends Thread{
  	private Account account;
  	@Override
  	public void run() {
  		for (int i = 0; i < 5; i++) {
  			synchronized (account) {
  				if (account.getMoney() >= 200) {
  					System.out.println("张三准备取款");
  					try {
  						Thread.sleep(200);
  					} catch (InterruptedException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  					account.setMoney(account.getMoney()-200);
  					System.out.println("张三取款完成，余额是"+account.getMoney());
  				}
  			}
  		}
  	}
  	public ZhangSan(Account account) {
  		super();
  		this.account = account;
  	}
  }
  ```

- ZhangsanWife.java

  ```java
  public class ZhangSanWife extends Thread{
  	private Account account;
  
  	public ZhangSanWife(Account account) {
  		super();
  		this.account = account;
  	}
  	@Override
  	public void run() {
  		for (int i = 0; i < 5; i++) {
  			synchronized (account) {
  				if (account.getMoney() >= 200) {
  					System.out.println("张三妻子准备取款");
  					try {
  						Thread.sleep(200);
  					} catch (InterruptedException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  					account.setMoney(account.getMoney()-200);
  					System.out.println("张三妻子取款完成,余额是"+account.getMoney());
  				}
  			}
  		}
  	}
  }
  ```

-  Test.java

  ```java
  public class Test {
  	public static void main(String[] args) {
  		Account account = new Account(1000);
  		ZhangSan zs = new ZhangSan(account);
  		zs.start();
  		ZhangSanWife zsw = new ZhangSanWife(account);
  		zsw.start();
  	}
  }
  ```



- 注意：同步可以保证资源共享操作的正确性，但是过多同步也会产生死锁。`死锁一般情况下表示互相等待，是程序运行时出现的一种问题`。





### 3.  线程的生产者与消费者

> ​	生产者不断生产，消费者不断取走生产者的产品，但当产品不足、消费者来取走产品时，数据就会出现错误。



- 测试代码

  - Goods.java

  ```java
  public class Goods {
  	
  	private String name;
  	private String brand;
  	//是否有产品
  	private boolean flag = false;
  	public Goods() {
  		super();
  	}
  	public Goods(String name, String brand) {
  		super();
  		this.name = name;
  		this.brand = brand;
  	}
      // set get 省略
  	public synchronized void ct() {
  		if(!flag)
  		{
  			try {
  				wait();
  			} catch (InterruptedException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}
  		
  		try {
  			Thread.sleep(200);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		System.out.println("消费者消费"+getBrand()+getName());
  		flag = false;
  		notifyAll();
  
  	}	
  	public synchronized void pd(int i) {
  		if(flag)
  		{
  			try {
  				wait();
  			} catch (InterruptedException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}
  			if(i % 2 == 0)
  			{
  				setBrand("旺仔");
  				
  				try {
  					Thread.sleep(200);
  				} catch (InterruptedException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  				setName("牛奶");
  				System.out.println("生产者生产"+getBrand()+getName());
  			}
  			else {
  				setBrand("娃哈哈");
  				
  				try {
  					Thread.sleep(200);
  				} catch (InterruptedException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  				setName("矿泉水");
  				System.out.println("生产者生产"+getBrand()+getName());
  			}
  			flag = true;
  			notifyAll();
  	}
  }
  ```

  - Test.java

    ```java
    public class Test {
      	public static void main(String[] args) {
      		Goods gs = new Goods();
      		new Prdc(gs).start();
      		
      		new Cstm(gs).start();
      	}
      }
    ```

  - Customer.java  +   Product.java

    ```java
    public class Customer extends Thread{
    	private Goods gs;
    	public Customer(Goods gs) {
    		super();
    		this.gs = gs;
    	}
    	public void run() {
    		for (int i = 0; i < 10; i++) {
    			gs.ct();
    		}
    	}
    }
    
    
    public class Product extends Thread{	
    private Goods gs;
    	public Product(Goods gs) {
    		super();
    		this.gs = gs;
    	}
    
    	public void run() {
    		for (int i = 0; i < 10; i++) {
    			gs.pd(i);
    		}
    	}
    }
    ```

    

