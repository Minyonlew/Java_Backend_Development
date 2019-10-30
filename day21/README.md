# Java Development



## Day 21 多表查询 92/99语法 子查询 分页查询

[TOC]

### 1. 多表联合查询

> - **多表联合查询：**
>   - 当需要获取的数据分布在多张中，考虑使用联合查询
>     - `SQL92方式`
>     - `SQL99方式`



#### 1.1 `SQL` 92语法

- `笛卡尔积`: 将多个表的数据进行一 一对应，所得到结果为多表的笛卡尔积。

> - 结果的数量为所有表的数量的乘积。
>
> ```sql
>  select * from emp,dept where emp.deptno=dept.deptno 
> ```



##### 1.1.1 	等值连接筛选

> - 概念：先做表的笛卡尔积，然后筛选，筛选条件为等值筛选。
> - 注意：条件为字段的值相同来进行筛选，字段的名字可以不同
>
> - 查询员工姓名，工作，薪资，部门名称
>
> ```sql
> select * from emp,dept where emp.deptno=dept.deptno
> ```
>
> - 可以直接在select子句中使用字段直接获取数据，但是效率比较低。建议字段前加上表名
>
> ```sql
> --注意：如果是公共字段，则必须声明表名
> select ename,job,sal,dname 
> from emp,dept 
> where emp.deptno=dept.deptno  --等值连接筛选
> 
> select emp.ename,emp.job,emp.sal,dept.dname,emp.deptno 
> from emp,dept 
> where emp.deptno=dept.deptno
>                 
> select e.ename,e.job,e.sal,d.dname 
> from emp e,dept d 
> where e.deptno=d.deptno and sal>2000  --给表使用别名
> ```



##### 1.1.2 	非等值连接筛选

> - 查询员工姓名，工作，工资，工资等级
>
> ```sql
> select e.ename,e.job,e.sal,sg.grade
> from emp e, salgrade sg
> where e.sal between sg.losal and sg.hisal
> ```



##### 1.1.3 	自连接

> - 本表的一条数据使用本表中另外一条数据
> - 查询员工姓名，工作，薪资，及上级领导姓名
>
> ```sql
> select e1.ename,e1.job,e1.sal,e2.ename
> from emp e1, emp e2
> where e1.empno = e2.ename
> ```



##### 1.1.4 	外连接

> - **加号在那边   那边为补充的数据**
>
>   - **左外连接**：**加在右边**，显示左边对应字段没有值的数据
>
>     - 查询员工姓名，工作，薪资，部门名称及没有部门的员工信息
>
>     ```sql
>     select *
>     from emp e,dept d
>     where e.deptno = d.deptno(+)
>     ```
>
>   - **右外连接 **: **加在左边**，显示右边边对应字段没有值的数据
>
>     - 查询员工姓名，工作，薪资，部门名称及没有部门的员工信息
>
>     ```sql
>     select *
>     from emp e,dept d
>     where e.deptno(+) = d.deptno
>     ```



#### 1.2  `SQL` 99语法

> - 注意1：依然可以给表添加别名
> - 注意2：如果使用`on` 或者`usering` 关键对结果进行筛选，必须使用`inner join` 作用表与表的连接，其中`inner`可以省略
> - 注意3:外连接的 `outer关键字`可以省略不写
> - 注意4：依然可以继续使用分组，`having` ，排序等



##### 1.2.1 	交叉连接 

- **关键字** :`cross join`

> ```sql
> --select 内容 from 表名 cross join 表名
> select * from emp cross join dept
> 
> --与92 select * from emp，dept 效果一样
> ```



##### 1.2.2  	自然连接

- **关键字** :`natural join`

> - **使用**：`select` 内容 `from` 表名 `natural join` 表名
>               --**特点1**：底层先笛卡尔积，然后按照所有的同名同值字段自动进行等值筛选。
>               --问题1：如果只想按照部分字段结果筛选怎么办？
>               --问题2：如果想按照字段名不同，但是值相同进行等值筛选怎么办？
> - 查询员工姓名，工作，薪资，部门名称
>
> ```sql
> select * from emp natural join dept
> ```
>
> - **解决1：使用using关键字**
>           --**作用1**：指明使用指定的字段对联合查询的结果进行等值筛选。
>           --注意：指明的字段必须是两表的同名同值字段。
>           --使用:`select` 内容`from` 表名 `inner join` 表名 `using(字段名，字段名,....)`
>
> ```sql
> select * from emp inner join dept using(deptno)
> ```
>
> - **解决2：使用`on关键字`进行自定义连接条件筛选(等值筛选，不等值筛选)**
>           --**注意**：普通筛选条件使用`where`进行筛选，不要使用`on`进行。
>
>   ​        --好处：`SQL语句`的阅读性变强。
>   ​        --使用：`select` 内容 `from` 表名 `inner join` 表名 `on `连接条件 `where` 普通筛选条件
>
> ```sql
> select * from emp inner join dept on emp.deptno=dept.deptno where sal>2000
> ```



##### 1.2.3  	外连接

- **关键字：** `left outer  join on ` /   `right outer  join on` /   `full  outer  join on`
- **左外连接**

> - **使用**：`select `内容 `from` 表名 `left outer join` 表名 `on` 连接条件 
> - 查询员工姓名，工作，薪资，部门名称及没有部门的员工信息
>
> ```sql
> select * from emp e left outer  join dept d on e.deptno=d.deptno
> ```

- **右外连接**

> - 使用**：`select `内容 `from` 表名 `right outer join` 表名 `on` 连接条件 
> - 查询员工姓名，工作，薪资，部门名称及没有部门的员工信息
>
> ```sql
> select * from emp e right outer  join dept d on e.deptno=d.deptno
> ```

- **全外连接**

> - 使用**：`select `内容 `from` 表名 `right outer join` 表名 `on` 连接条件 
> - 查询员工姓名，工作，薪资，部门名称及没有部门的员工信息
>
> ```sql
> select * from emp e full  outer join dept d on e.deptno=d.deptno
> ```



##### 1.2.4 	自连接

- **关键字** :  `inner join`

> - 查询员工及其上级领导姓名
>
> ```sql
> select  e1.*,e2.ename from emp e1 inner join emp e2 on e1.mgr=e2.empno
> ```





### 2. 子查询

> - **单表查询**：
>   - 当需要的数据在一张表中，考虑使用单表查询
> - **多表联合查询**：
>   - 当需要查询的数据分布在多张表中，考虑使用多表联合
> - **子查询学习**：
>   - `SQL`允许多层嵌套。**子查询，即嵌套在其他查询中的查询。**
>   - **理解子查询的关键在于把子查询当作一张表来看待。外层的语句可以把内嵌的子查询返回的结果当成一张表使用。**
>   - 使用时机：当查询的筛选条件不明确时，考虑使用子查询。
>   - 单行子查询
>   - 多行子查询



#### 2.1 单行子查询

> - **使用时机**：筛选条件不明确需要执行一次查询，并且查询结果一个字段并值只有一个。
> - **注意**：where子句中允许出现查询语句，该查询语句称为子查询。
> - **使用**：select 内容 from 表名 where 字段名 比较运算符 子查询语句。



```sql 
--查询所有比雇员“CLARK”工资高的员工信息
select * from emp 
where sal>(select sal from emp where ename ='CLARK')
--查询工资高于平均工资的员工的名字和工资
select ename,sal 
from emp 
where sal>(select avg(sal) from emp )
--查询和soctt属于同一部门且工资比他低的员工资料
select * from emp 
where deptno=(select deptno from emp where ename='SCOTT') 
and sal<(select sal from emp where ename='SCOTT')
--查询工资最高的员工资料
select * from emp 
where sal=(select max(sal) from emp)
--查询职务和scott相同，雇佣时间早的员工信息
select * from emp 
where job=(select job from emp where ename='SCOTT') 
and hiredate <(select hiredate from emp where ename='SCOTT')
--查询工资比scott高或者雇佣时间早的员工编号和名字
select empno,ename from emp 
where job=(select job from emp where ename='SCOTT')
or hiredate <(select hiredate from emp where ename='SCOTT')
```



#### 2.2 多行子查询

> - **使用:子查询的结果只有一个字段但是字段有n个值，考虑使用多行子查询，其实就是使用关键字**
> - 关键字1:`any 任意`
>   - `selec`t 内容 `from` 表名 `where` 字段名 `比较运算符 `  `any ` 子查询语句
> - 关键字2：`all` 所有
>   - `select` 内容 `from` 表名 `where`字段名 `比较运算符`  `all` 子查询语句
> - 关键字3：`in `表示任意存在,相当于 = `any  `
>   - `select` 内容 `from`表名 `where` 字段名 `in`子查询语句   
>   - `select` 内容 `from` 表名 `where` 字段名 `not in` 子查询语句



```sql
--查询工资高于任意一个CLERK的所有员工信息
select * from  emp 
where sal> any (select sal from emp where job='CLERK')
--查询工资高于所有SALESMAN的员工信息
select * from emp 
where sal> all (select sal from emp where job='SALESMAN')
--查询部门20中同部门10的雇员工作一样的雇员信息
select job from emp where deptno=10

select *from emp 
where (job='MANAGER' or job='PRESIDENT' or job='CLERK') and deptno=20

select * from emp 
where job  in (select job from emp where deptno=10) and deptno=20

select * from emp 
where job = any (select job from emp where deptno=10) and deptno=20
```



### 3. 分页查询

> **【1】 取前XX条数据   直接使用 rownum <= XX**
>
> ``` sql
> --查询前5名员工的信息
> select e.* from emp e where rownum <= 5
> ```
>
> 【2】取出XX ~ XX条数据  查询中间的多少条数据
>
> ```sql
> select *
> from (select e.*, rownum r from emp e) t01
> where t01.r >= 6
> and t01.r <= 10
> ```
>
> 【3】排序 取出前几条数据
>
> ```sql
> -- 查询薪资最高的前五名员工的信息
> -- 先通过薪资  对员工信息进行排序
> select *
> from (select e.* from emp e order by nvl(e.sal, 0) desc) t01
> where rownum <= 5
> ```
>
> 【4】排序 并且查询中间几条数据
>
> ```sql
> -- 查询薪资排名6~10名的员工
> select t02.*
> from (select t01.*, rownum r
> 	from (select e.* from emp e order by nvl(e.sal, 0) desc) t01) t02
> where t02.r >= 6
> and t02.r <= 10
> ```
>



### 4. 13道练习和笔试题

> 测试代码...