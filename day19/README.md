# Java Development



## Day 19 Oracle

[TOC]



### 1. Oracle 安装



#### 1.1 安装

> 参考 `PPT`。



#### 1.2 账户

- **初次登录**

> 通过`PL/SQL`图像界面登录 
>
> 1. 账户：`sys`
> 2. 密码：`123`
> 3.  数据库：`ORCL`
> 4. 连接为：`SYSDBA`

- **解锁**

> 1. 创建一个`SQL窗口`  
>
> 2. 输入语句：
>
>    ```sql
>    alter user scott account unlock;  //解锁scott用户
>    ```

- **重新登录`scott`账户**

> 通过`PL/SQL`图像界面登录 
>
> 1. 账户：`scott`
> 2. 密码：`tiger`
> 3.  数据库：`ORCL`
> 4. 连接为：`NOMAL`
> 5. 重新修改密码：`123`

- **测试**

> ``` sql
> select * from emp;
> ```





### 2. SQL 语句



#### 2.1  `select` 语句

```sql
--检索单个列
select  ENAME  from EMP;
--检索多个列
select  ENAME,EMPNO ,JOB  from EMP;
--检索所有列
select  *  from EMP;
--给检索出的列起个别名
select JOB  "gong zuo" from EMP;
Select e.ENAME,e.EMPNO  from EMP e;
--distinct关键字 去掉字段中重复的值 
select distinct empno from emp;
```

#### 2.2  四则运算

- 字段的逻辑运算
  - select 关键字和from关键字之间的字段可以直接进行四则运算
  - 字段与字段之间也可以直接进行运算
  - **注意：字段值为数值类型**

```sql
select empno,ename,job,sal*2+1000,sal+comm from emp
```



#### 2.3 `where` 语句

- **使用 `where子句` 查询筛选。（单个条件中）**
  - `select`  字段名,字段名,...from 表名 where 筛选条件。
  - 筛选条件：
    - 使用运算符进行筛选`=,>,>=,<=,<,!=` 

```sql
--where

--在emp表中，找到deptno不等于10的ename和sal字段
select ename,sal from emp where deptno <> 10;

--找到emp表里含有大写A中的字段ename
select ename from emp where ename like '%A%'
--找到emp表里第三个字母是A的字段ename
select ename from emp where ename like '__A%'

--查询SMITH的薪资信息，逻辑运算符=
	--这里sal+comm字段 会没东西显示，因为comm是空值，原因后面会讲
select empno,ename,sal,sal+comm from emp where ename="SMITH"   
```

- **多条件中**

  ```sql
  --在emp中找到所有comm中为null的值
  select * from emp where comm is null;
  --在emp中找到所有comm中不为null的值
  select * from emp where comm is not null;
  
  --多个条件使用and关键字来进行连接
  --select * from 表面 where 筛选条件1 and 筛选条件2 and ...
  
  --在emp表中 找到sal在（800，1250，1500，2000）中的然后输出ename和sal
  select ename,sal from emp where sal in (800,1250,1500,2000);
  --在emp表中，找到sal在1000到2500的范围，输出字段ename和sal
  select ename,sal from emp where sal between 1000 and 2500;
  ```



#### 2.4 order by

```sql
-- 排序
select * from emp order by empno asc  --升序（可以省略）
select * from emp order by empno desc，ename desc --降序
--查看入职日期在81年后的员工信息
	-- 先排序 再找  oracle默认的日期格式： 日-月-年
select * from emp where hirdate>='01-1月-1981' order by hirdate
```



### 3. 练习



#### 3.1 练习（一）

```sql
--1、查询部门编号为10的员工信息
select * from emp where deptno = 10;
--2、查询年薪大于3万的人员的姓名与部门编号
select ename,deptno from emp where sal>30000;
--3、查询佣金为null的人员姓名与工资
select ename,sal from emp where comm is null;
--4、查询工资大于1500 且 and 含有佣金的人员姓名
select ename from emp where sal>1500 and comm is not null
--5、查询工资大于1500 或 or含有佣金的人员姓名
select ename from emp where sal>1500 or comm is not null;
--6、查询姓名里面含有 S 员工信息 工资、名称
select ename,sal from emp where ename like '%S%'
--7、求姓名以J开头第二个字符O的员工姓名的与工资
select ename,sal from emp where ename like '%JO%'
--8、求包含%的雇员姓名
select ename from emp where ename like '\%'
--9、使用in查询部门名称为 SALES 和 RESEARCH 的雇员姓名、工资、部门编号
--select ename,sal,deptno from dept where dname  in('SALES','RESEARCH')
--10、使用exists查询部门名称为SALES和RESEARCH 的雇员姓名、工资、部门编号。

```





