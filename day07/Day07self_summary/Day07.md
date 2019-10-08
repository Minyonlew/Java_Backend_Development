# Java Development

### Day 07  Package import



### 1、包 Package

- **包机制是Java中管理类的重要手段。**

  - 开发中会遇到大量的同名类，通过包就很容易对解决类重名的问题，也能实现对类的有效管理。

  - 对于类，相当于文件夹对应文件的作用。

    ```java
    package my.day07.packagetest
    
    //这样创建出来的包在文件上 是这样的： E/.../src/my/day07/packagetest
    //用于分类
    ```

    

### 2、导入包 import

- 当想调用其他包的类时，可以使用import关键字来调用该类的包

  ```java
  import my.day07.packagetest.User;  //调用my.day07.packagetest包里的 User类
  import my.day07.packagetest.*;    //调用my.day07.packagetest包里的 所有类
  
  public class Test{
  	public static void main(String agrs[])
      {
          User u = new User();   //直接就可以使用User类
      }
  }
  
  ```

  