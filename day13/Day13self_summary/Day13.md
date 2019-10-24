# Java Development



## Day 13  容器 Map

[TOC]



### 1. Map 接口

- **public interface Map <K,V>**
- 将键映射到值的对象。 Key--> Value.
- **一个映射不能包含重复的键；每个键最多只能映射到一个值。**



#### 1.1 Map 接口

- **Map用户保存具有映射关系的数据，因此Map集合里保存着两组数:一组值用户保存Map里的key,另一组值用户保存Map里的value。**
- **key和value都可以是任何引用类型的数据。Map的key不允许重复，即同一个Map对象的任何两个key通过equals方法比较总是返回false。**
- key和value之间存在单向一对一关系，**即通过指定的key,总能找到唯一的、确定的value。从Map中取出数据时，只要给出指定的key，就可以取出对应的value。**



#### 1.2  Map集合与Set集合、List集合的关系

- **与Set集合的关系**
  - 如果 把Map里的所有key放在一起看，它们就组成了一个Set集合（所有的key没有顺序，key与key之间不能重复），实际上Map确实包含了一个keySet()方法，用户返回Map里所有key组成的Set集合。
- **与List集合的关系**
  - 如果把Map里的所有value放在一起来看，它们又非常类似于一个List：元素与元素之间可以重复，每个元素可以根据索引来查找，只是Map中索引不再使用整数值，而是以另外一个对象作为索引



#### 1.3 HashMap 

- 特点：

  - Key无序、唯一（Set）
  - Value无序、不唯一（Collection）

  > ​        HashMap是一个最常用的Map，它根据键的hashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度。HashMap最多只允许一条记录的键为NULL，允许多条记录的值为NULL。
  >
  > ​        HashMap不支持线程同步，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致性。如果需要同步，可以用Collections的synchronizedMap方法使HashMap具有同步的能力。

- **HashMap的测试代码**

  ```java
  import java.util.HashMap;
  import java.util.Map;
  
  public class TestMap {
  
  	public static void main(String[] args) {
  		Map<Integer,String> map = new HashMap<Integer,String>();
  		Map<Integer,String> map2 = new HashMap<Integer,String>();
  		 
  		 	//1.返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
  		 	map.put(2, "wangcai");
  			map.put(3, "daniu");
  			map2.put(1,"一");
  			map2.put(2, "二");
  			
  			//从指定映射中将所有映射关系复制到此映射中（可选操作）。
  			map.putAll(map2);
  			System.out.println(map);
  			
  			//2，存储键值对。如果键相同，会出现值覆盖。
  			System.out.println(map.put(4, "xiaoqiang"));
  			System.out.println(map.put(4, "erhu"));
  			System.err.println("********");
  			
  			//3.如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
  			System.out.println(map.remove(2));
  			//4.返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
  			System.out.println(map.get(3));
  
  			//5.如果此映射包含指定键的映射关系，则返回 true。
  			System.out.println(map.containsKey(2));
  			// 如果此映射将一个或多个键映射到指定值，则返回 true。
  			System.out.println(map.containsValue("daniu"));
  			
  			//6.返回此映射中包含的映射关系的 Set 视图。
  			System.out.println(map.entrySet());
  			
  			//7.返回此映射中包含的键的 Set 视图。
  			System.out.println(map.keySet());
  			
  			//8.返回此映射中包含的值的 Collection 视图。
  			System.out.println(map.values());
  			
  			//从此映射中移除所有映射关系（可选操作）。
  			//map.clear();
  			//System.out.println(map);
  		}
  }
  
  ```

  

#### 1.4 LinkedHashMap 

- 特点：
  - 有序的HashMap

> LinkedHashMap保存了记录的插入顺序，当Iterator遍历LinkedHashMap，先得到的记录肯定是先插入的。

#### 1.5 TreeMap

- 特点：
  - 有序，但速度没有hash快。





### 2 . 练习



#### 2.1 练习1 Email

> **Q：假如有以下email数据 “aa@sohu.com,bb@163.com,cc@sina.com” 。现需要把email中的用户部分和邮件地址部分分离，分离后以键值对应的方式放入HashMap，便遍历显示出来。**

- **测试代码** 

  ```java
  import java.util.HashMap;
  import java.util.Map;
  import java.util.Set;
  
  public class Test {
  
  	public static void main(String[] args) {
  		String str = "aa@sohu.com,bb@163.com,cc@sina.com";
  		String []strA = str.split(",");//用split()来分割字符串并赋值给一个数组
  		HashMap<String, String> map = new HashMap<String, String>();
  
  		for (String string : strA) {
  			String [] emails = string.split("@");
  			map.put(emails[0], emails[1]);
  		}
  		
  		//创建一个set 来获取key
  		Set<String> set = map.keySet();
  		for (String string : set) {
  			//输出 键ke y+@+ 值Value
  			System.out.println(string+"@"+map.get(string));
  		}
  	}	
  }
  ```

  

#### 2.2 练习2 Worker

> **定义一个Worker类, 属性:name:String,age:int,salary:double** 
>
>   **a).把若干Worker对象放在List中,排序并遍历输出,按照age升序排列**
>
>   **b).把若干Worker对象放在Set中并遍历,要求没有重复元素**
>
>   **c).把若干Worker对象放在Map中并按照三种方式分别遍历,要求以Worker的姓名作为key。**

- **测试代码**  

  - **a) 要求。**   （用到的代码文件：Worker01.java  Test01.java）
    - Worker01.java

  ```java
  public class Worker01 implements Comparable<Worker01> {
  
  	private String name;
  	private int age;
  	private double salary;
  	public Worker01() {
  		super();
  	}
  	public Worker01(String name, int age, double salary) {
  		super();
  		this.name = name;
  		this.age = age;
  		this.salary = salary;
  	}
      //属性 set get 方法省略...
      //重写toString 方法省略...
  	
  	@Override     //通过age来决定对象的大小关系
  	public int compareTo(Worker01 arg0) {
  		// TODO Auto-generated method stub
  		return this.age - arg0.age;
  	}
  
  }
  
  ```

  - Test01.java

  ```java 
  import java.util.ArrayList;
  import java.util.Collections;
  
  public class Test01 {   //实现a要求
  
  	public static void main(String[] args) {
  		ArrayList<Worker01> ls = new ArrayList<Worker01>();
  		ls.add(new Worker01("旺财1", 20, 3000.0));
  		ls.add(new Worker01("旺财2", 21, 3000.0));
  		ls.add(new Worker01("旺财3", 30, 3000.0));
  		ls.add(new Worker01("旺财4", 29, 3000.0));
  		
  
  		//为什么还需要Collection的排序呢？？
  		Collections.sort(ls);
  		System.out.println(ls);
  	}
  }
  ```

  - ​	
  - **b）、c） 要求**  （用到的代码文件：Worker02.java  Test02.java）
  - Test02.java

  ``` java
  import java.util.HashSet;
  
  public class Test02 {
  
  	public static void main(String[] args) {
  		HashSet<Worker02> hs = new HashSet<Worker02>();
  		hs.add(new Worker02("旺财1", 20, 3000.0));
  		hs.add(new Worker02("旺财2", 21, 3000.0));
  		hs.add(new Worker02("旺财3", 30, 3000.0));
  		hs.add(new Worker02("旺财1", 20, 3000.0));
  		System.out.println(hs);
          
          HashMap<String, Worker02> hm = new HashMap<String, Worker02>();
  		hm.put("旺财1", new Worker02("旺财1", 20, 3000.0));
  		hm.put("旺财2", new Worker02("旺财2", 20, 3000.0));
  		hm.put("旺财3", new Worker02("旺财3", 20, 3000.0));
  		hm.put("旺财4", new Worker02("旺财4", 20, 3000.0));
  		
  		//以名字作为key,通过keySet方法将得到的key 赋值给 set集合
  		Set<String> set = hm.keySet();
  		//遍历set集合中的key，通过get方法得到对应的value并输出
  		for (String string : set) {
  			System.out.println(hm.get(string));
  		}
  		
  		//通过迭代器来遍历set中的key
  		Iterator<String> it = set.iterator();
  		while(it.hasNext())
  		{
  			System.out.println(hm.get(it.next()));
  		}
  		
  		//通过 values方法将hm里的values都赋值给 Collection
  		Collection<Worker02> cln = hm.values();
  		for (Worker02 worker02 : cln) {
  			System.out.println(worker02);
  		}
  	}
  
  }
  
  /*
  b要求输出：
  [Worker01 [name=旺财2, age=21, salary=3000.0], Worker01 [name=旺财3, age=30, salary=3000.0], Worker01 [name=旺财1, age=20, salary=3000.0]]
  */
  
  /*
  c要求输出（三遍）：
  Worker02 [name=旺财1, age=20, salary=3000.0]
  Worker02 [name=旺财2, age=20, salary=3000.0]
  Worker02 [name=旺财3, age=20, salary=3000.0]
  Worker02 [name=旺财4, age=20, salary=3000.0]
  
  */
  ```

  - Worker02.java

  ```java
  public class Worker02 {
  
  	private String name;
  	private int age;
  	private double salary;
  	public Worker02() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public Worker02(String name, int age, double salary) {
  		super();
  		this.name = name;
  		this.age = age;
  		this.salary = salary;
  	}
  	//属性 set get 方法省略...
      //重写toString 方法省略...
      
  	@Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + age;
  		result = prime * result + ((name == null) ? 0 : name.hashCode());
  		long temp;
  		temp = Double.doubleToLongBits(salary);
  		result = prime * result + (int) (temp ^ (temp >>> 32));
  		return result;
  	}
  	@Override
  	public boolean equals(Object obj) {
  		if (this == obj)
  			return true;
  		if (obj == null)
  			return false;
  		if (getClass() != obj.getClass())
  			return false;
  		Worker02 other = (Worker02) obj;
  		if (age != other.age)
  			return false;
  		if (name == null) {
  			if (other.name != null)
  				return false;
  		} else if (!name.equals(other.name))
  			return false;
  		if (Double.doubleToLongBits(salary) != Double
  				.doubleToLongBits(other.salary))
  			return false;
  		return true;
  	}
  }
  ```










### 3.集合总结

![01.png](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day13/Day13self_summary/01.png)

![02.png](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day13/Day13self_summary/02.png)

