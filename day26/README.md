# Java Development

## Day 26  反射的封装

[TOC]

### 1. 封装查询功能

>- SIUDUtil.java
>
>```java
>public class SIUDUtil{
>    public static void main(String[] args) {
>		ArrayList list = select("select * from Emp", "day24.practice.Emp");
>		for (Object object : list) {
>			System.out.println(object);
>		}
>	
>	}
>    
>    /**
>	 * 1.通用查询  
>	 * 		a.查询的表，是以参数的形式传进函数内
>	 * 		b.将表进行数据解析，并将得到的信息赋值给与其同名的对象
>	 * 		c.并将该对象存放在List中，显示
>	 * @parm sql
>	 * 		sql查询语句
>	 * @parm className
>	 * 		将查询结果解析成对象的名字，包括包名	
>	 * 
>	 * */
>	public static ArrayList<Object> select(String sql,String className){
>		Statement stmt = DBUtil.getStatement();
>		ResultSet  rs = null;
>		ArrayList  list = null;
>		
>		try {
>			rs = stmt.executeQuery(sql);
>			//通过ResultSetMetaData 获取 结果集中的信息
>			ResultSetMetaData metaData = rs. getMetaData();
>			//获取查询结果的列数
>			int clmCount = metaData.getColumnCount();
>			//获取每一列的列名（使用字符串数组来记录）
>			String [] clmNames = new String [clmCount];
>			for(int i =1;i<=clmNames.length;i++)
>			{
>				clmNames[i-1] = metaData.getColumnName(i);
>			}
>			
>			//获取所要解析成对象的信息
>			//通过类的名字来获取一个反射
>			Class cls  = Class.forName(className);
>			
>			//通过反射获取到类的所有成员变量
>            //getDeclaredFields()获得类声明的命名的字段		 
>			Field [] fs = cls.getDeclaredFields();	
>			
>			//开始解析查询结果，并将结果解析成指定类型的对象 存放在list中
>			list = new ArrayList();
>			while(rs.next())
>			{
>/*
> * 原理：1. 因为如果想输出 ResultSet rs 得到的结果集里面的内容，需要确定当前列的类型
> * 		 2. 为此，通过反射得到的（对象）成员变量 和 在结果集中查询出来的列名关联起来 
> * 		 3. 从而能够得到 该列的类型 
> * */
>				//循环一次 就能得到一行数据 且 每一行的数据都应该由一个对象来存放
>				Object obj = cls.newInstance();
>				list.add(obj);
>				for(Field fd : fs){
>					//获取该属性的名字
>					String fieldName = fd.getName().toUpperCase();
>					for(String clmName : clmNames){
>						if(clmName.toUpperCase().equals(fieldName))
>						{
>							//找到跟（对象）属性同名的列时
>							//就可以判断该成员变量的类型
>							
>							//1.如果类型是字符串
>           if(fd.getType().getName().equals("java.lang.String")){
>								fd.set(obj, rs.getString(clmName));
>							}
>			else if(fd.getType().getName().equals("int")||
>			    fd.getType().getName().equals("java.lang.Integer")){
>				fd.setInt(obj, rs.getInt(clmName));
>			}else if(fd.getType().getName().equals("java.util.Date"))
>					{
>					fd.set(obj, rs.getDate(clmName));
>					}
>						}
>					}
>				}
>			}	
>		} catch (SQLException e) {
>			e.printStackTrace();
>		} catch (ClassNotFoundException e) {
>			e.printStackTrace();
>		} catch (InstantiationException e) {
>			e.printStackTrace();
>		} catch (IllegalAccessException e) {
>			e.printStackTrace();
>		}
>		return list;
>	}
>}
>```



### 2. 封装插入功能

> - SIUDUtil.java
>
> ```java
> /**
>  *  2.通用插入  (控制台-->对象-->数据库)
>  *  简述： 定义一个通用的插入方法，使一个与数据库表名相同的对象作为参数传入函数里面，
>  *  	  从而实现在eclipse里用java代码之间对数据库进行插入操作。
>  *      思路：
>  *      	a.将传进来的对象进行反射（分析传进来的是什么对象，有什么属性）
>  *      	b.创建SQL语句
>  *      	b.1.期望的SQL:"insert into emp (字段1,字段2,字段3,...)  
>                  values (?,?,?,...)"
>  *      	b.2 关键是如何将对象里的属性  转变成上面 （表里）的 字段。
>  *      		b.2.1 可以通过获取对象里面的属性的类型的名字，然后拼接到sql上。
>  *      		b.2.2 问号可以通过属性的个数， 用for循环来并接到sql上。
>  *      	c.创建完SQL语句后，就要执行SQL语句。
>  *      		c.1 关键就是如何获取这些属性的类型。
>  *      		c.2 获取属性的类型之后，判断其类型是什么，然后分别通过setInt 或    						setString等方法 来执行
>  *          d.最后返回 int 。（执行了多少条指令） 
>  */
> 	
> public static int insert (Object obj) throws IllegalArgumentException, IllegalAccessException, SQLException {
> 		//1.通过反射来获取对象的信息（对象的名字，对象的属性）
>         //注意这里，如果使用的是getName() 将会得到包名.类名，
>         //而我们是想直接得到类名。
> 		String str = obj.getClass().getSimpleName();  
> 												   	  
> 		Class cls = obj.getClass();
> 		//1.2 通过Field数组来获取对象的每个属性
> 		Field [] fs = cls.getDeclaredFields();
> 		//2.拼接sql
> 		String sql = "insert into "+str+ "(";
> 		//3.将对象的属性的名字拼接到sql上（字段的位置）
> 		for(int i=0;i<fs.length;i++)
> 		{
> 			Field fd = fs[i];
> 			sql +=  fd.getName();
> 			if(i!=fs.length-1)
> 			{
> 				sql+=",";
> 			}
> 		}
> 		sql +=  ") values ( ";
> 		
> 		//4.有多少个属性，就将多少个?拼接到sql里面
> 		for(int i=0;i<fs.length;i++)
> 		{
> 			sql+="?";
> 			if (i!=fs.length-1) {
> 				sql+=",";
> 			}
> 		}
> 		sql+=")";
> 		
> 		//5.拼接完sql后，开始执行（PreparedStatement）
> 		PreparedStatement pstmt = DBUtil.getPreparedStatement(sql);
> 		
> 		//5.1 判断当前的属性是什么类型，使其能够匹配相应的setXXX方法
> 		for(int i=0;i<fs.length;i++)
> 		{
> 			Field fd = fs[i];
> 			//如果是字符串
> 			if("java.lang.String".equals(fd.getType().getName()))
> 			{
> 				pstmt.setString(i+1, fd.get(obj).toString());
> 			}
> 			//如果是整型
> 	else if("int".equals(fd.getType().getName())||
>             "java.lang.Integer".equals(fd.getType().getName()))
> 			{
> 				pstmt.setInt(i+1, fd.getInt(obj));
> 			}
> 			//如果是日期
> 			else if ("java.sql.Date".equals(fd.getType().getName())) {
> 				pstmt.setDate(i+1, (java.sql.Date)fd.get(obj));
> 			}
> 			//如果是float型
> 			else if("float".equals(fd.getType().getName()))
> 			{
> 				pstmt.setFloat(i+1, fd.getFloat(obj));
> 			}
> 		}
> 		//6. 执行（获取int）
> 		int n = pstmt.executeUpdate()
> 		return n;
> }
> 	
> 	public static int  insertObject(Object obj) {
> 		//为了让insert()方法的代码好看点，所以把异常都往外抛了
> 		//因此，要用这个方法来捕获一下他的异常
> 		int n = 0;
> 		try {
> 			n = insert(obj);
> 		} catch (IllegalArgumentException e) {
> 			e.printStackTrace();
> 		} catch (IllegalAccessException e) {
> 			e.printStackTrace();
> 		} catch (SQLException e) {
> 			e.printStackTrace();
> 		}		
> 		return n;
> 	}
> 
> /**
> * 批量插入对象
> * @param list
> * @return
> */
> public static int insert(List<Object> list) {
> 	int count = 0;
>     for (int i = 0; i < list.size(); i++) {
>         Object obj = list.get(i);
>         int n = insertObject(obj);
>         count += n;
>     }
>     return count;
> }
> 
> public static void main(String[] args) {
> 		
>     /*
>      * //测试insert 插入一个
>      * int n = insertObject(new Emp(6666, "Minyo", "stu", 5555, new Date(222222), 10000, 10000, 10));
>        * */
>     
>        //测试insert 批量插入对象
>        //list存放在对象  
>        int n = insert(list)
> 		
> 		
> }
> 
> ```



### 3. 封装删除功能

>- SIUDUtil.java
>
>```java
>/**
>	 * 删除数据
>	 * @param args
>	 */
>public static int delOrUpdt(String sql) {
>    Statement stmt = DBUtil.getStatement();
>    int n = 0;
>    try {
>        n = stmt.executeUpdate(sql);
>    } catch (SQLException e) {
>        // TODO Auto-generated catch block
>        e.printStackTrace();
>    }
>    return n;
>}
>
>```
>
>

