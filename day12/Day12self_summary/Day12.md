# Java Development



## Day 12 容器 Collection  List  ArrayList  LinkedList   泛型

[TOC]

###  Java集合类（容器类）简介

- **Java集合可用于存储数量不等的对象，并可以实现常用的数据结构（如栈、队列等待），还可以用于保存具有映射关系的关联数组。Java集合就一种容器，可以把多个对象放进容器中，Java集合可以记住容器中的对象的数据类型，从而可以使代码更加简洁和健壮。**



- Java集合大致可以分为**Set、List、Queue、Map**四种体系。
  - **Set**：代表无序、不可重复 ；
  - **List**：代表有序、重复的集合 ；
  - **Queue**：代表一种队列集合实现 ；
  - **Map**：代表具有映射关系的集合。



- **Java集合与数组的区别：**
  - 数组的长度是不可变化的，在数组初始化时指定了数组长度，如果需求要动态添加数据，此时数据就无可为力了，而集合可以保存不确定数量的数据，同时也可以保存具有映射关系的数据。
  -  同一个集合的元素即可是基本类型的值，也可以是对象（实际上保存的是对象的引用变量）；而数组只能保存同一类型的对象。

- **Java 集合框架为不同类型的集合定义了大量接口： **
  - ![01](https://github.com/Minyonlew/Java_Backend_Development/blob/master/day12/Day12self_summary/01.png)
  - **集合有两个基本接口：Collection 和 Map。 而Collection继承了Iterable接口，之后会讲到。**





------

### 1. Collection接口



#### 1.1 Collection

- **Collection接口是Set、List、Queue接口的父接口**，该接口所有的方法可以供其子类调用实现。



#### 1.2 Collection接口的常用方法

- ```Java
  Collection cln = new ArrayList();         //接口不能实例化，只能通过实例类来建立对象
  Collection cln2 = new ArrayList();
  
  //在cln1内增加元素
  cln.add("a");    
  System.out.println(cln);  //输出[a]
  cln2.add("a"); cln2.add("b"); cln2.add("c");
  
  //将cln2当作一个元素，加到cln中
  cln.add(cln2);
  System.out.println(cln);            //输出[[a,b,c]]
  System.out.println(cln.size());     //输出 1
  
  //将cln2全部的元素，加到cln中
  cln.addAll(cln2);
  System.out.println(cln);            //输出[a,b,c]
  System.out.println(cln.size());     //输出 3
  
  //移除cln中所有的元素
  cln.clear();
  System.out.println(cln);       	   //输出 []
  
  //如果此 collection 包含指定的元素，则返回 true。
  System.out.println(cln.contains(cln2));
  //比较此 collection 与指定对象是否相等。
  System.out.println(cln.equals(cln2));
  //如果此 collection 不包含元素，则返回 true。
  System.out.println(cln.isEmpty());
  //从此 collection 中移除指定元素的单个实例，如果存在的话（可选操作）。
  System.out.println(cln.remove(cln2));
  // 返回此 collection 中的元素数。
  System.out.println(cln.size());
  ```

  

#### 1.3 Iterator (迭代器)

- **Iterable 接口是Collection接口的父接口**。

  - 因此Collection集合可以直接调用其方法。 

  - **而Iterable 接口只有一个方法 ： **

  - ```java
    Iterator<T> iterator()  // 返回一个在一组 T 类型的元素上进行迭代的迭代器。
    ```

- **而Iterator也是接口**

  - **其子接口：ListIterator **

  - **Iterator 接口的方法：**

    - ```java
      (boolean) hasNext()；//如果仍有元素可以迭代，则返回 true。
        (E)      next() ;  //返回迭代的下一个元素。
      (void)	   remove(); // 从迭代器指向的 collection 中移除迭代器返回的最后一个元素。
      ```

- **通过Iterator接口遍历集合元素：**

  ```java
  import java.util.ArrayList;
  import java.util.Collection;
  import java.util.Iterator;
  public class TestMain {
   
      public static void main(String[] args) {
          testIterator();
      }
   
       static void testIterator() {
          // 创建集合添加元素
          Collection<Person> personList = new ArrayList<Person>();
          Person p1 = new Person("钟梅", 25);
          Person p2 = new Person("王兴", 34);
          personList.add(p1);
          personList.add(p2);
          // 获取集合的迭代器iterator
          Iterator<Person> iterator = personList.iterator();
           
          while (iterator.hasNext()) {     //hasPrevious  判断前面是否有元素
              // 获取集合中的下一个元素
              Person person = iterator.next();
              System.out.println("person:" + person.name + "--" + person.age);
   
              if (person.name.equals("王兴")) {
                  // 删除上一次迭代器next返回的元素，(删除游标左边的元素)
                  iterator.remove();
              }
   
              // 对person对象中的变量赋值，会改变集合中元素的值
              person.name = "马云";
              person.age = 88;
          }
          System.out.println(personList.toString());
      }
   
      static class Person {
          String name;
          int age;
          public Person(String name, int age) {
              super();
              this.name = name;
              this.age = age;
          }
          @Override
          public String toString() {
              return "Person [name=" + name + ", age=" + age + "]";
          }
   
      }
  }
  ```

  - **输出结果：**

    ```java
    person:钟梅--25
    person:王兴--34
    [Person [name=马云, age=88]]
    ```

  - 可以看出，**对迭代变量person对象进行赋值，当再次输出personList集合时，会看到集合中的元素发生了改变。**可知，**当使用Iteration对集合进行遍历迭代，会把集合元素值传递给迭代变量。**

  - 当使用Iteration迭代变量Collection集合时，不可以在迭代过程中进行对集合添加、删除等操作，否则会引发**java.util.ConcurrentModificationException**异常，只能利用迭代器Iteration的remove方法进行删除上一次的next返回的元素。



#### 1.4 Collection和Collections的不同

- **Collecton 是集合接口，而Collections 是操作类！！！**
-  **一个接口，一个操作类！！！可以想象成  数组 和 Arrays。**



- **Collections提供的静态方法：**
  - addAll();  //批量添加
  - sort();    //排序
  - binarySearch();  //通过二分查找的方式来查找元素
  - fill();  // 使用指定元素替换指定列表中的所有元素。
  - reverse();   //逆序



------

### 2. List 接口



#### 2.1 List 接口

- **List代表是一个元素有序、可重复的集合，集合中每个元素都有对应的顺序索引。**
- **List集合允许使用重复的元素，可以通过索引来访问指定位置的元素。**
- **List集合默认按元素的添加顺序来设置元素的索引，例如第一次添加的元素索引为0，第二次添加的元素索引为1，依次类推下去。**
- **list接口的常用的实现类： ArrayList     LinkedList**。



#### 2.2 ArrayList 实现类

- **ArrayList 是 List接口的一个 实现 <u>类</u> 。**
  - ArrayList实现了长度可变的数组，在内存中分配连续的空间。
  - 优点：遍历元素和随机访问元素的效率比较高。
  - 缺点：添加和删除需要大量移动元素效率低，按照内容查询效率低。



- **ArrayList主要方法：**

  ```java
  ArrayList al = new ArrayList();    //List的实现类   有序，不唯一
  ArrayList a2 = new ArrayList();
  ArrayList a3 = new ArrayList();
  al.add("a");al.add("b");al.add("c"); //将指定的元素添加到此列表的尾部
  a2.add("e");al.add("f");al.add("g");
  
  al.add(3,"d");                      //将指定的元素插入此列表中的指定位置。
  System.out.println(al);
  
  // 从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
  al.addAll(4,a2);					
  System.out.println(al);
  
  //返回此 ArrayList 实例的浅表副本。
  al.clone();      
  al.contains("a");//如果此列表中包含指定的元素，则返回 true。
  al.get(1);       //返回此列表中指定位置上的元素。
  al.indexOf("a");   //返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
  al.isEmpty();     //如果此列表中没有元素，则返回 true
  
  al.lastIndexOf("a"); //返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1
  
  al.remove(1);				// 移除此列表中指定位置上的元素。
  al.remove("a");				// 移除此列表中首次出现的指定元素（如果存在）。
  
  al.set(2, "C");				// 用指定的元素替代此列表中指定位置上的元素。
  
  al.size();  //返回此列表中的元素数
  ```




- **手动实现一个 ArrayList**
  - 测试代码：MyArrayList/... （马）
  - 测试代码：MyArrayList02/... （高）



#### 2.3 LinkedList 实现类

- **LinkedList采用双向链表存储方式**
  - 优点：插入、删除元素时效率比较高。
  - 缺点：遍历和随机访问元素效率低下。



- **LinkedList主要方法：**

  ```java
  LinkedList ll = new LinkedList();    //List的实现类   有序，不唯一
  LinkedList l2 = new LinkedList();
  LinkedList l3 = new LinkedList();
  ll.add("a");ll.add("b");ll.add("c"); //将指定的元素添加到此列表的尾部
  l2.add("e");ll.add("f");ll.add("g");
  
  
  
  ll.add(3,"d");        //将指定的元素插入此列表中的指定位置。
  System.out.println(ll);
  
  ll.addAll(4,l2);		// 从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
  System.out.println(ll);
  
  ll.addFirst("zero");			//将指定元素插入此列表的开头。
  ll.addLast("Last"); 			//将指定元素插入此列表的结尾。
  System.out.println(ll);			//输出[zero, a, b, c, d, e, f, g, Last]
  
  ll.clear();					//从此列表中移除所有元素。
  ll.clone();					//返回此 LinkedList 的浅表副本。
  ll.contains(l2);    			//如果此列表包含指定元素，则返回 true。	
  
  
  .element();   // 获取但不移除此列表的头（第一个元素）。
  
  ll.get(0); 						//返回此列表中指定位置处的元素。 
  ll.getFirst();					//返回此列表的第一个元素。 
  ll.getLast(); 					//返回此列表的最后一个元素。 
  
  ll.indexOf(l2); 	//返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
  ll.lastIndexOf(l2); //返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
  
  ll.offer("z");//将指定元素添加到此列表的末尾（最后一个元素）。
  ll.offerFirst("F");//在此列表的开头插入指定的元素。
  ll.offerLast("L");//在此列表末尾插入指定的元素。
  
  /*剩下的参考API*/
  ```

  

------



### 3. Set 接口

- **Set 接口存储一组 <u>唯一、无序的对象</u>**。 （存入和取出的顺序不一定一致。）

- 操作数据的方法与List 类似，**Set接口没有get()方法。（无法根据下标或者内容去'get'到想要的内容。）**

- **在Set集合中添加相同的元素（注意是同一个对象的引用，并非是两个元素值相同的**），**add方法会操作失败，返回false，新元素是无法被加入的。**

  

#### 3.1 Set 接口中的实现类

- **HashSet **
  - **采用哈希表存储结构。**
    - 优点：添加速度快，查询速度快、删除速度快。
    - 缺点：无序。
- **LinkedHashSet**
  - **采用哈希表结构，同时使用链表维护次序。**
    - 优点：有序。
- **TreeSet**
  - **采用二叉树（红黑树）的存储结构**
    - 优点：有序（排序之后升序），**查询速度比List快（按照内容查询）。**
    - 缺点：**查询速度没有HashSet 快。**



> **Q:  HashSet 是如何保证元素的唯一性？**
>
> **A：**
>
> ​		**通过hashCode值 和 equals()方法 来完成的。如果元素的HashCode值相同，就调用equals()方法。然而，hashSet的equals()方法判断的是两个对象是否相等，而不是对象的内容是否相等，所以要想让两个内容相等的对象不能同时存进hashSet里，需要要重写hashSet里面的equals()方法。**

- **HashSet 代码测试：**

  - **TestMain.java**

  ```java
  import java.util.HashSet;
  import java.util.Iterator;
  public class TestMain {
  
  	public static void main(String[] args) {
  		HashSet<Employee> hs = new HashSet<Employee>();	
          
  		hs.add(new Employee(1002,"李默文",22));   
  		hs.add(new Employee(1001,"王小华",20));
  		hs.add(new Employee(1002,"李默文",22));
  		
  		System.out.println("人数："+hs.size());
  		System.out.println("员工内容：");
  		System.out.println(hs);
  
  	}
  
  }
  
  /*输出：
  	人数：2
  	员工内容：
  	[Employee [id=1001, name=王小华, age=20], Employee [id=1002, name=李默文, age=22]]
  
  */
  ```

  - Employee.java

  ```java
  public class Employee {
  
  	private int id;
  	private String name;
  	private int age;
  	public Employee(int id, String name, int age) {
  		super();
  		this.id = id;
  		this.name = name;
  		this.age = age;
  	}
  	public Employee() {
  		super();
  	}
  	
      //属性的set get 方法省略....
  	@Override
  	public String toString() {
  		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
  	}
      //重写hashCode 和equals方法 使程序根据 id这一属性相同的对象判定为相同的对象。
  	@Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + id;
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
  		Employee other = (Employee) obj;
  		if (id != other.id)
  			return false;
  		return true;
  	}
  }
  
  ```



> **Q：为什么使用TreeSet存放自定义类型的对象时，程序会报错？**
>
> **A：**
>
> - **在使用TreeSet时，存进去的对象需要有明确的大小关系。**
>
>  * （如）存进TreeSet（new Employee（1002,"李默文",22）、(new Employee(1001,"王小华",20) 时，系统无法确定这两个对象的大小关系，所以编译的时候会报错。
>  * **为了决定对象中哪个属性可以用来确定它们之间的大小关系（如用Employee里面的age来决定）**
>  * **有两种方法**：
>     * **创建一个“外部比较器” 来决定 实现Comparator接口 实现compare方法。**
>     * **创建一个“内部比较器”来决定  实现Comparable接口 实现compareTo方法**

- **TreeSet 代码测试**

  - TestTreeSet.java

  ```java
  import java.util.Comparator;
  import java.util.TreeSet;
  
  public class TestTreeSet {
  
  	public static void main(String[] args) {
  		//TreeSet ts = new TreeSet(new AgeCp());   //外部比较器
  		TreeSet  ts2 = new TreeSet();      //内部比较强
          
          //这里举例以age来决定次序（对象的大小关系）
  		ts2.add(new Person(10));
  		ts2.add(new Person(10));
  		ts2.add(new Person(20));
  		System.out.println(ts2);
  	}
  
  }
  /*
  输出：[Person [age=10]]
  */
  ```

  - Person.java

  ```java
  public class Person implements Comparable<Person>{ //内部“比较器” 实现Comparable接口
  
  	private int age ;
  	public Person() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public Person(int age) {
  		super();
  		this.age = age;
  	}
  	 //属性的set get 方法省略....
  	
  	@Override
  	public int compareTo(Person o) {    //重写Comparable接口中的compareTo方法
  										//实现通过age来觉得对象的次序（对象的大小关系）
  		if(this.getAge()==o.getAge())
  			return 0;
  		else if(this.getAge()>o.getAge())
  			return 1;
  		else {
  			return -1;
  		}
  	}
      
      @Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + age;
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
  		Person other = (Person) obj;
  		if (age != other.age)
  			return false;
  		return true;
  	}
      @Override
  	public String toString() {
  		return "Person [age=" + age + "]";
  	}
  }
  
  ```

  - AgeCp.java

  ```java
  import java.util.Comparator;
  
  public class AgeCp implements Comparator<Person>{   //外部“比较器” 实现Comparator接口
  
  	@Override
  	public int compare(Person p1, Person p2) {
  		
  		return p1.getAge()-p2.getAge();
  	}
  
  }
  ```

  