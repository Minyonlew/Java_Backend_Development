# Java Development



## Day 20 SQL 函数学习

[TOC]



### 1. 函数学习

> 概念： 是oracle提供的用来进一步修饰或者处理数据的方法。
>
> 使用：在书写SQL语句时直接使用即可。
>
> 函数学习 （单行、多行函数，转换函数，其他函数）



#### 1.1 and or 优先级

> 例子： 查询工作为SALESMAN,MANAGER 并且工资大于2500 的员工信息
>
> ```sql
> select * from emp where job ='SALESMAN' or job = 'SALESMAN'  and sal >2500
> ```
>
> ​	这个题目是要求不管是SALESMAN还是MANAGER 的工资都要大于2500的员工的信息，但答案却出现了工资是1600的，问题出现在哪？  **and 关键字的执行级别高于or！！！**

```sql
--可以使用小括号提升条件的执行级别，使用小括号的级别是最高的。
select * from emp where (job ='SALESMAN' or job = 'SALESMAN')and sal >2500
```



#### 1.2 单行函数

- **使用：select 字段名 ，函数名（字段名），字段名...from 表名**
  
  - 特点1：不改变真实数据，只是对数据做了进一步修饰或者处理显示.
  
  - 特点2：可以和字段混合使用。  
  
    
  
- **字符函数**

> 1. 查询所有员工信息，员工姓名小写显示。
>
> ``` sql
> select empno,ename,lower(ename),job,mgr,sal,low('HH') from emp
> ```
>
> 2. 查询所有员工信息，员工姓名首字母大写。
>
> ```sql
> select empno,INITCAP(ename) 首字母大写的姓名,lower(ename),job from emp
> ```

- **数值函数**

>  --数值函数：对数值类型的数据进行运算
>  --伪表：真实存在的表，是为了方便进行数据的验证而临时存在的表。表名为：dual
>
> ```sql
> select abs(-1),ceil(2.2),floor(3.3),power(2,3),mod(5,2),round(4.55),trunc(10/3,2) from dual
> ```

- **日期函数**

> 1.返回两个日期间的月份数
>
> ```sql
> select months_between('01-1月-2018','24-6月-2017') from dual   
> ```
>
> 2.返回指定月数后的日期
>
> ```sql
> select add_months('01-4月-2018'，-4) from dual 
> ```
>
> 3.查询最近的星期的日期
>
> ```sql
>  select next_day('16-4月-2018','星期二') from dual
> ```
>
> 4.返回当月的最后一天的日期
>
> ```sql
> select last_day('16-4月-2018') from dual
> ```
>
> 5.按照星期进行四舍五入  
>
> ```sql
> select round(to_date('19-4月-2018'),'DAY') from dual
> ```
>





#### 1.2 多行函数（组函数）

> - 多行函数`(max,min,avg,sum,count)`很重要
> - 作用：对查询的数据进行统计
> - 使用：`select`  `多行函数名(字段名)` , `多行函数名(字段名)`...`from 表名`
> - 注意：**多行函数不能和普通字段以及单行函数混用，除非分组**
>   - `max（字段名）`  返回该字段的最大值
>   - `min(字段名) `    返回该字段的最小值
>   - `sum(字段名)`    返回该字段的和
>   - `avg(字段名) `   返回该字段的平均值
>   - `count`
>     - `count(*) ` 返回表的记录数
>     - `count(字段名) ` 返回非空值的数量
>     - `count(distinct 字段名)`  去除重复后的字段值的数量

```sql
--查看员工的最高工资
select max(sal) from emp--多行函数不能和字段直接混用，除非分组。
select lower(ename)，max(sal) from emp--多行函数 不能和单行函数混用，除非分组
--查看员工的最低工资
select min(sal) from emp
--查看员工的平均工资
select avg(sal) from emp
--查看所有的员工工资之和
select sum(sal) from emp
--查询公司有多少员工
select count(*) from emp--查询表的记录数
--查询有津贴的员工人数
select count(comm) from emp--查询字段的值的数量，null会自动过滤
--查询公司有多少工作种类     
select distinct job from emp
select count(distinct job) from emp
select count(*),sum(sal),avg(sal),max(sal),min(sal) from emp 
```



#### 1.3 转换函数

> - 转换函数：
>   - `to_number(数值类型的字符)`:将字符转换为数值
>   - `to_char(数值或者是日期)`:将数值或者日期转换为字符
>   - `to_date(日期格式的字符)`：将字符转换为日期

- **字符转为数字char----->number**

```sql
select to_number('123')+2 from dual
```

- **数字转为字符number---->char**

```sql
--指定显示格式:
    --9表示位置占位，例如999,999,999会将数字按照三个一组使用逗号隔开。
    --L表示人民币符号，$表示美元符号
  	--0可以进行占位分组，但是如果真实数据位数不足，会使用0进行补位。
    select to_char(12345,'$999,999,999') from dual
    select to_char(12345,'L999,999,999') from dual
    select to_char(12345678,'000,000,000,000.000') from dual
    --查询工资大于2000的员工信息
    --数值和字符之间的转换可以隐式转换。to_number可以省略不写.
    select * from emp where sal>'2000';
    select * from emp where sal>to_number('2000');
```

- **日期和字符的互转**

```sql
--一般使用方式：新增数据使用to_date(),查询数据使用to_char()
--字符转换为日期 char--->date
 --使用to_date('要转换的字符',日期格式)函数将字符转换为日期
 --注意1：字符必须符合日期格式
 --注意2:oralce默认的转换格式为日月年，例如'01-1月-2018' oracle认为是一个日期
    --常用日期格式：
       --    yyyy-mm-dd
       --    yyyy/mm/dd
    --查询员工入职日期在82年后的信息
    select * from emp where hiredate >to_date('1982-01-01','yyyy-mm-dd')
    select * from emp where hiredate >to_date('1982/01/01','yyyy/mm/dd')      
    select * from emp where to_char(hiredate,'yyyy-mm-dd') >'1982-01-01'
    
--日期转换为字符  date--->char
  --使用to_char('要转换的日期',转换格式)
  --注意1：如果不指名转换格式，则使用默认格式，日月年例如:'01-1月-81'
  --常用转换格式：
    -- yyyy-mm-dd
    -- yyyy/mm/dd
    --'yyyy"年"mm"月"dd"日"'
   select to_char(hiredate) from emp--使用默认格式将日期转换为字符
   select to_char(hiredate,'yyyy-mm-dd') from emp--使用指定格式yyyy-mm-dd
   select to_char(hiredate,'yyyy/mm/dd') from emp--使用指定格式yyyy/mmm/dd
   
   select to_char(hiredate,'yyyy"年"mm"月"dd"日"') 
   from emp--使用指定格式 'yyyy"年"mm"月"dd"日"'
```



- **其他函数**

```sql
--nvl()：nvl(字段名，新的值)
   --如果字段值不为null，则返回该字段的值。如果为null则返回新的值
   
--nvl2()：nvl2(字段名，处理1，处理2)
   --如果字段值不为null，则执行处理1，为null执行处理2
   
--decode()：decode(字段名,值1，处理1，值2，处理2，值3，处理3,...,公共处理)
   --如果字段的值和decode中的条件值相同则执行对象的处理。如果都没有则执行公共处理
   ---查询员工的工资信息
   select ename,job,sal from emp
   --查询员工的薪水信息
   select ename,job,sal+nvl(comm,0),sal+comm,sal from emp
   select ename,job,nvl2(comm,sal+comm,sal) from emp
   
   --显示员工的职称
   select ename,job,decode(job,'MANAGER','经理','PRESIDENT','董事长','SALESMAN','销售','普通员工') from emp
   
   
--- decode  解决特定值问题  与switch case 差不多
--  部门编号为10 则加薪10%    部门编号为20加薪20%   部门编号为30 则加薪30%
--  其他部门加薪15%
select e.ename,e.deptno,
       e.sal,
       decode(e.deptno,
              10,
              e.sal * 1.1,
              20,
              e.sal * 1.2,
              30,
              e.sal * 1.3,
              e.sal * 1.15) 加薪以后的薪水
  from emp e

-- case when 
/* 
  薪水 500-1500   返回贫穷群众
  1500-2000       返回贫困群众
  2000-3000       小康群众
  3000-           大康群众
  
  */
select e.ename,
       e.sal,
       case
         when e.sal < 1500 then
          '贫穷群众'
         when e.sal >= 1500 and e.sal <= 2000 then
          '贫困群众'
         when e.sal >= 2000 and e.sal < 3000 then
          '小康群众'
         when e.sal >= 3000 then
          '大康群众'
       end 身份
  from emp e

```





#### 1.4 分组函数&筛选

> - 关键字：`group by` 分组字段名 , 分组字段名....
>   - 注意1：使用了分组后，在`select语句`中只允许出现`分组字段`和`多行函数`。
>   - 注意2：如果是`多字段分组`，则先按照第一字段分组，然后每个小组继续按照第二个字段继续分组，以此类推。 
>   - **注意3：在where子句中不允许出现多行函数。**
>   - **注意4：除组函数语句外，`select语句`中的每个列都要在`group by`子句中给出。**
> - 分组筛选
>   - 关键字：`having`
>   - **作用：针对分组进行分组后的数据筛选，允许使用多行函数。**
>   - 注意：
>     - **`having关键字`必须和分组结合使用。不允许单独使用。**   
>     - `where`和`having`的比较：
>     - **where子句不允许出现多行函数，having允许出现多行函数**
>     - **where子句和having都可以使用普通字段直接进行筛选，但是where的效率高于having**
>     - where执行顺序: from--->where--->group by-->select-->order by
>     - having执行顺序:from--->group by-->select--->having--->order by
>   - **结论：在分组语句中，使用where进行字段级别的筛选，使用having进行多行函数的筛选。**

- **例子：**

```sql
--查询最高工资和员工数
select max(sal),count(*) from emp
--查询不同部门的最高工资
select deptno,max(sal) from emp group by deptno
select * from emp

--查询不同工作岗位的员工数
select job, count(*) from emp group by job
--查询不同部门的不同工作岗位的人数
select deptno,job,count(*)
from emp 
group by deptno,job
order by deptno
--查询不同部门的不同工作岗位的并且人数大于1的信息
select deptno ,lower(job),count(*)    （3）
from emp  							  （1）
group by deptno,job 				  （2）
having count(*)>1 					  （4）
order by deptno                       （5）
--having比select执行顺序还要低

--查询部门号大于10的不同部门的不同工作岗位的人数
--使用having关键字
select deptno,job,count(*)
from emp
group by deptno,job
having deptno>10
order by deptno

--使用where关键字
select deptno,job,count(*) 		(4)
from emp						(1)
where deptno>10                 (2)
group by deptno,job  			(3)
order by deptno					(5)

---SQL查询语句的结构
--select 子句          要查询的数据(oracle函数，别名，连接符，去除重复，逻辑运算)
--from语句             决定要查询的表(表名)             
--where子句            筛选数据（筛选条件，关键字）
--group by子句         分组     （分组字段）
--having子句           分组筛选   (多行函数筛选条件)
--order by子句         排序       （排序）
--from-->where--->group by-->select--->having--->order by
```







### 注意：

> 各种函数实例代码 以及 API 尽在day20文件夹中！！！

