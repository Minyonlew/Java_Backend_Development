# Java Development

## Day 25 反射





### 1. 反射的概念和作用

> ​		**JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。**
>
> ​	    **功能：在运行时判断任意一个对象所属的类；在运行时构造任意一个类的对象；在运行时判断任意一个类所具有的成员变量和方法；在运行时调用任意一个对象的方法；生成动态代理。**
>
> 

#### **1.1 概念**

> **Q : 为什么要使用反射？**
>
> **A：** 1. 传统方式创建对象：new 类名(); 
>
> ​		2. 要创建对象前提是要知道使用的类的类型是什么，但是如果无法确定类的类别的时候怎么办？
>
> 		3. 使用反射能解决这个问题。



#### 1.2 作用

>- **反射的作用**
>  - 获取类的对象。
>  -  操作类属性、方法、构造器。



### 2.  反射操作类



#### 2.1 反射获取类对象

> - **反射获取类对象的三种方式：**
>   - `Class.forName(); `  //根据全限定路径获取
>   - `对象名.getClass();` //根据对象获取
>   - `类名.class ` //根据类名获取
> - **测试代码**
>
> ```java
> //第一种方式--->创建类对象
> Class cla01=Class.forName("com.bjsxt.pojo.Person");
> //第二种方式---->调用底层使用反射封装的方法
> Class cla02=Person.class;
> //第三种方式---->调用底层使用反射封装的方法
> Class cla03=new Person().getClass();
> ```
>
> - **常用的方法**
>
> ```java
> System.out.println("获取类对象的包名---->"+cla01.getPackage());
> System.out.println("获取类的修饰符----->"+cla01.getModifiers());
> System.out.println("获取类的名称(全限定)----->"+cla01.getName());
> System.out.println("获取类的名称(类名)----->"+cla01.getSimpleName());
> System.out.println("获取类的父类的类对象----->"+cla01.getSuperclass());        
> //注意:  通过反射创建的类对象只有一个
> ```



#### 2.2 反射操作元素属性

>```java
>//操作属性:
>//获取类对象
>//获取类属性
>getFields()         //获取所有的公共字段包括父类   返回Field[]
>getDeclaredFields() //获取所有声明的字段(不包括父类) 返回Field[]
>getField(String name) //获取指定的公共字段包括父类   返回Field
>getDeclaredField(String name) //获取指定的声明的字段(不包括父类)  返回Field
>    
>//操作类属性
>//操作静态属性
>	类属性对象.get(null)                     //返回静态属性的值
>	类属性对象.set(null,"值")                //赋值
>//操作非静态属性
>	类属性对象.get(Object obj);
>	类属性对象.set(Object obj,"值");
>```
>
>- **测试代码**
>
>```java
>public static void operField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
>   //获取类对象
>   Class cla=Class.forName("com.bjsxt.pojo.Student");
>   //获取反射类属性
>   //获取类及其父类的公共字段
>   Field[] fds = cla.getFields();
>   for(Field f:fds){
>       System.out.println("获取属性名------>"+f.getName());
>       System.out.println("获取修饰符------>"+f.getModifiers());
>       //返回的是类型的Class对象
>       System.out.println("获取类型------>"+f.getType());
>   }
>   System.out.println("******************************");
>//获取类声明的所有字段
>   Field[] fds2=cla.getDeclaredFields();
>   for(Field f:fds2){
>       System.out.println("获取属性名----->"+f.getName());
>       System.out.println("获取修饰符------>"+f.getModifiers());
>       //返回的是类型的Class对象
>       System.out.println("获取类型------>"+f.getType());
>   }
>   System.out.println("******************************");
>//获取指定的字段
>   Field f=cla.getField("pname");//指定获取类及其父类的公共字段
>   System.out.println(f.getName());
>   Field f2=cla.getDeclaredField("money");//指定获取类的所有字段
>   System.out.println(f2.getName());
>   //指定获取父类声明的字段
>   Field f3=cla.getSuperclass().getDeclaredField("pname");
>   System.out.println(f3.getName());
>//操作字段值
>   System.out.println("************操作静态字段**********************");
>   //操作静态属性
>   Field fs=cla.getDeclaredField("money");
>   fs.set(null,2000);
>   System.out.println(fs.get(null));
>   System.out.println("************操作非静态字段**********************");
>   //操作非静态属性
>   Field fd=cla.getDeclaredField("sname");
>   Object obj=cla.newInstance();
>   fd.set(obj, "李四");
>   System.out.println(fd.get(obj));        
>   //暴力反射操作私有化属性(了解)
>   Field fd2=cla.getDeclaredField("ssex");
>   fd2.setAccessible(true);//暴力反射,操作私有化属性,不安全
>   Object obj2=cla.newInstance();//获取实例化对象
>   System.out.println(fd2.get(obj2));
>
>```
>
>