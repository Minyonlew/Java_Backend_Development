# Java Development

## Day 24    JDBC

[TOC]

### 1. JDBC 



#### 1.1 简介

> ​		`JDBC(Java Database Connectivity)` 是基于`JAVA`语言访问数据库的一种技。`JDBC（Java Data Base Connectivity, java数据库连接）`是一种用于执行`SQL语句的Java API`，可以为多种关系数据库提供统一访问，它由一组用`Java语言`编写的`类和接口`组成。
>
> ​		`JDBC`提供了一种基准，据此可以构建更高级的工具和接口，使数据库开发人员能够编写数据库应用程序，同时，`JDBC`也是个商标名。
>
> ​		`JDBC`的设计思,想：由`SUN公司(JCP)`提供访问数据库的接口，由数据库厂商提供对这些接口的实现，程序员编程时都是针对接口进行编程的。
>
> ​		`JDBC`包括一套`JDBC`的`API`和一套程序员和数据库厂商都必须去遵守的规范。

- 总的来说：

>  **`JDBC`的概念**:
>            **问题:**
>                    `java`和数据库之间的沟通不一致        
>            **解决:**
>                    数据库厂商对外提供`java`支持的接口
>            **使用:**
>                    创建类实现接口(操作数据库)
>                    数据库厂商对外提供了数据库操作的驱动包.(翻译官)
>            **结论:**
>          `JDBC`其实就是数据厂商对外提供的能够对自己的数据进行操作的驱动包也就是`jar`文件.



#### 1.2  JDBC 访问数据库的过程

> 1. **驱动管理器**    		作用：  加载 `JDBC` 程序。  
> 2. **连接数据库**            作用：  建立与数据库的连接。
> 3. **发送`SQL`语句**         作用：  向数据库发送`SQL`语句。
> 4. **结果集**                     作用：  得到查询结果。



------



### 2.  `Java.sql`  面向接口编程



#### 2.1  `JDBC` 的常用接口

> 1.  `Java.sql.DriverManger` 用来装载驱动程序，并且为创建新的数据库联接提供支持。
>
> 2. `Java.sql.Connection` 完成对某一指定数据库的联接。
>
> 3. `Java.sql.Statement` 在一个给定的连接中作为`SQL`执行声明的容器，
>
>    ​      他包含了两个重要的子类型
>
>    3.1  `Java.sql.PrepareStatement` 用于执行预编译的`SQL`声明。
>
>    3.2  `Java.sql.CallableStatement` 用于执行数据库中存储过程的调用。
>
> 4. `Java.sql.ResultSet` 对于给定声明取得结果的途径。



------



### 3. JDBC 与数据库的交互



#### 3.1  连接`Oracle` 的 `Jar` 文件

> 1.  先找到`oralce` 的安装目录：`D:\oracle\product\11.2.0\dbhome_1\oui\jlib`
> 2. 里面有个叫 `classes12.jar` 文件。
> 3. 将其复制，并在`eclipse` 中的工程文件下，创建一个叫 `lib`的文件夹然后粘贴。
> 4. 然后右击鼠标，`Build path`  -->`add to ` -->...



#### 3.2  常用数据库的链接方式

> ```java 
> //MySQL：  
> 	 //驱动程序  
>      String Driver="com.mysql.jdbc.Driver"; 
>      //连接的URL,db_name为数据库名      
>      String URL="jdbc:mysql://localhost:3306/db_name";    
> 
>      String Username="username";    //用户名  
>      String Password="password";    //密码  
>      Class.forName(Driver);  
>      //连接
>      Connection con=DriverManager.getConnection(URL,Username,Password);  
> 
> //Oracle:  
>      //驱动程序
>      String Driver="oracle.jdbc.driver.OracleDriver";    
>      String URL="jdbc:oracle:thin:@localhost:1521:orcl";    
>      String Username="username";    //用户名  
>      String Password="password";    //密码  
>      Class.forName(Driver) ;    //加载数据库驱动  
>      Connection con=DriverManager.getConnection(URL,Username,Password); 
> ```



#### 3.3 连接、修改`Oracle`数据库

> - `JDBC`学习:
>    -  1	导入`JDBC`驱动包
>    - 2 	加载驱动
>    - 3 	常见数据库连接
>    - 4 	创建数据库命令对象
>    - 5	创建sql命令
>    - 6	执行sql
>    - 7 	关闭资源
>  - 常见的`JDBC`错误:
>     - `ClassNotFoundException:` 驱动类未找到。
>     - `java.sql.SQLException: No suitable driver found for :thin:@localhost:1521:orcl` : URL错误
>     - `java.sql.SQLException: ORA-01017: invalid username/password; logon denied `  : 用户名或密码错误
>     - `java.sql.SQLSyntaxErrorException: ORA-00900: 无效 SQL 语句`:`Sql`语句错误
>     - `java.sql.SQLIntegrityConstraintViolationException: ORA-00001: 违反唯一约束条件 (SCOTT.PK_DEPT)` : 主键冲突



##### 3.3.1 	连接数据库

- `GetConn.java`

> ```java
> /**
> * 将连接数据库的功能打包成一个类
> */
> import java.sql.Connection;
> import java.sql.DriverManager;
> import java.sql.SQLException;
> 
> public class GetConn {
> 	public static Connection getConnection() {
>         // 连接数据库的方法 
> 		String Driver = "oracle.jdbc.driver.OracleDriver"; 
>         // orcl为数据库的SID
> 		String URL = "jdbc:oracle:thin:@localhost:1521:orcl"; 
> 		String Username = "SCOTT"; // 用户名
> 		String Password = "123"; // 密码
> 		Connection con = null;
> 		try {
>             //加载驱动类
> 			Class.forName(Driver);
>             //获取数据库连接对象(连接指定的数据库)
> 			con = DriverManager.getConnection(URL, Username, Password);
> 		} catch (ClassNotFoundException e) {
> 			e.printStackTrace();
> 		}
> 		catch (SQLException e) {
> 			e.printStackTrace();
> 		}
> 		return con;
> 	}
> }
> ```

##### 3.3.2 	获取数据库的信息

> ```java
> import java.sql.Connection;
> import java.sql.DatabaseMetaData;
> import java.sql.ResultSet;
> import java.sql.SQLException;
> public class Test {
> 	public static void main(String[] args) {
> 		//通过方法获取一个oracle的连接
> 		Connection conn = GetConn.getConnection();
> 		//通过该连接  获取数据库相关的信息
> 		//包含用数据库的版本，驱动的名字版本
> 		//还可以获取用户有哪些数据库的对象
> 		//获取数据库相关信息的对象
> 		try {
> 			// 该对象保存了数据库的相关信息
> 			DatabaseMetaData metaDate = conn.getMetaData();
> 			//获取当前会话中 scott用户有哪些表
> 			ResultSet set = metaDate.getTables(conn.getCatalog(), "SCOTT", null, new String[]{"TABLE"});
> 			while (set.next()) {
> 				System.out.println(set.getString("TABLE_NAME"));
> 			}
> 		} catch (SQLException e) {
> 			e.printStackTrace();
> 		}
> 	}
> }
> ```



##### 3.3.3  	静态处理块 Statement

> 1.创建: `连接.createStatement() `
>
> 2.操作:
>
> - `ddl --> execute(String sql)`
> - `dml --> executeUpdate(String sql)`
> - `select -->executeQuery(String sql)`

- **查询数据库示例**

> ```JAVA
> //创建Statement
> //用户执行sql语句,
>   	Statement stmt=conn.createStatement();
> //执行查询语句
>   	String sql=“select * from emp”
> //executeQuery()一般用于执行一个sql语句,返回一个结果集。
> 	ResultSet rs=stmt.executeQuery(sql);
> //关闭Statement  
> 	stmt.close();
> ```

- **检索结果集**

>- 上面代码如何执行`sql语句` , 返回了`ResultSet类` 的对象,  这里讲如何对`ResultSet对象`进行处理。
>
>- **`ResultSet`的基本处理方法:**
>  - `ResultSet对象` 包括一个由查询语句返回的一个表 , 这个表中包含所有的查询结果，按照 `行和列` 进行处理。
>  - `ResultSet对象` 维持一个指向当前行的指针.最初,这个指针指向第一行之前。
>  - `ResultSet类`的`next()` 方法使这个指针移向下一行。第一次，使用`next()` 方法，将指针指向结果集的第一行。`next()`方法的返回值是一个`boolean值`，若为`true`，则成功移向下一行，若返回`false`则没有下一行。
>  - `getXXX`方法可以从某一列中获得结果。其中 `XXX` 是 `JDBC` 中的`java数据类型`。
>    - 如`getInt()`    `int` 类型。因此，需要制定检索的列，或名称。

​       `TestStatement.java`

> ```java
> import java.sql.Connection;
> import java.sql.ResultSet;
> import java.sql.SQLException;
> import java.sql.Statement;
> 
> public class TestStatment {
> 	public static void main(String[] args) throws SQLException {
> 		//获取数据库的连接
> 		Connection conn = GetConn.getConnection();
> 		//获取一个静态处理快
> 		Statement stmt = conn.createStatement();
>         
> 		//定义sql 语句  删除数据
> 		/*String sql = "delete from emp e where e.ename='旺财'";
> 		//使用静态处理块执行一个删除语句  返回值是删除的数据的条数
> 		int n = stmt.executeUpdate(sql);
> 		System.out.println(n);
> 		*/
> 		
> 		/**
> 		 * 插入数据
> 		 * String sql = "insert into emp (empno,ename) values(1011,'dahuang')";
> 			int n = stmt.executeUpdate(sql);
> 			System.out.println(n);
> 		 */
> 	
> 		/**
> 		 * 查询语句
> 		 */
> 		String sql = "select * from emp";
> 		ResultSet set = stmt.executeQuery(sql);
>         
>         //打印结果集的信息
> 		while (set.next()) {
>             //通过列号来输出每一列的值
> //			System.out.print(set.getInt(1));
> //			System.out.print(set.getString(2));
> //			System.out.print(set.getString(3));
> //			System.out.print(set.getInt(4));
> //			System.out.println(set.getDate(5));
> 			
> 			//通过列的名字来获取每一列的值
> 			System.out.print(set.getInt("empno"));
> 			System.out.println(set.getString("ename"));
> 		}
> 	}
> }
> ```
>



##### 3.3.4  	预处理块 PreparedStatement

> **1.特点** : 动态 `sql语句` 凡是 `Statement ` 能够处理的 `PreparedStatement` 都能处理，反之不一定 
>
> **2.ps**： 参数指值，不是用于关键字和字段上面。
>
> `select -->where sal=?`
>
> `insert  --> values(?)`
>
> `update --> set sal=? where deptno=?`
>
> `delete  --> where sal=?`



> ```java
> import java.sql.Connection;
> import java.sql.PreparedStatement;
> import java.sql.ResultSet;
> import java.sql.SQLException;
> 
> public class TestPreparedStatement {
> 
> 	public static void main(String[] args) throws SQLException {
> 		
> 		//一、连接数据库
> 		Connection con = GetConn.getConnection();
> 		//二、定义SQL语句
> 		//1.插入
> 		String sql01 = "insert into emp(empno,ename) values(?,?)";
> 		//2.删除
> 		String sql02 = "delete  emp where empno = ?";
> 		//3.更新
> 		String sql03 = "update emp set empno = ? where ename = '旺财'";
> 		//4.查询
> 		String sql04 = "select * from emp where ename =?";
> 		
> 
> 		//三、获取预处理块
> 		PreparedStatement pstmt = con.prepareStatement(sql01);
> 		
> 		//四、执行
> 		//1、2、3操作
> 		pstmt.setInt(1, 666);
> 		pstmt.setString(2, "大黄");
> 		//4查询操作
> 		//pstmt.setString(1, "SMITH");
> 
> 		//五、接收结果
> 		//insert update delete 时 用 execuyeUpdate 接收修改了多少条
> 		int n = pstmt.executeUpdate();
> 		System.out.println(n);
> 		
> 		/*查询 select 时使用 executeQuery 
> 		ResultSet rs = pstmt.executeQuery();
> 		while (rs.next())
> 		{
> 			System.out.println(rs.getInt(1));
> 			System.out.println(rs.getString(2));
> 		}
> 		*/
> 		pstmt.close();
> 	}
> }
> ```
>
> 





------



### 4. 批处理

> ​	**多次执行数据更新操作时，可以使用批处理减少连接数据库次数，提高效率。**

#### 

#### 4.1 静态处理块  批处理方式

> ```java
> Statement st = con.createStatement();
> 
> //添加批处理
> st.addBatch(更新语句1);
> st.addBatch(更新语句2);
> st.addBatch(更新语句3);
> //...
> //执行
> st,executeBatch();
> ```



#### 4.2 预处理块  批处理方式

> ```java
> import java.sql.PreparedStatement;
> import java.sql.SQLException;
> import java.util.Arrays;
> 
> public class AddBatchTest {    //批处理
> 
> 	public static void main(String[] args) throws SQLException {
> 		PreparedStatement p = GetConn.getConnection().prepareStatement("delete from emp"
> 				+" where ename = ?");
> 
> 		p.setString(1, "旺财");
> 		//增加批处理
> 		p.addBatch();
> 		
> 		p.setString(1, "大黄");
> 		p.addBatch();
> 		
> 		int [] ns = p.executeBatch();
> 		System.out.println(Arrays.toString(ns));
> 	}
> }
> ```
>
> 