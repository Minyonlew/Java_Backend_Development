# Java Development



## Day 22  账户管理 视图`view`  序列 `SQL`增删改 

##  数据类型对象 事务处理  约束  索引 

[TOC]

### 1. Oracle 账户管理



#### 1.1 Oracle 账户管理学习

> **权限**：具备某类事物的操作的能力，此能力称为权限。
> **角色**：一系列权限的集合。
>
> - `oracle`自带账户：
>
>   - `system` 管理账户  
>
>     - 特点：具备大部分`oracle`的操作权限，主要用来管理普通账户及oralce的数据
>     - 使用人：`oracle`数据维护工作人员。
>
>   - `sys` 超级管理员账户 
>
>     - 特点：具备`system`的所有权限，同时又具备其他的权限。
>     - 使用人：`oracle`攻城狮。
>
>     
>
> - 创建账户
>
>   - 使用`system` 账户，并使用`dba`身份，登录`Oracle`管理系统
>
> ``` sql
> --创建用户
> create user bjsxt identified by bjsxt;     --bjsxt 是密码    
> 
> --维护账户
> --赋予权限  grant 权限或者角色名 to 用户名
> grant connect to bjsxt;--给用户赋予登录权限
> grant resource to bjsxt;--给用户资源操作权限
> grant dba to bjsxt;--给用户赋予dba权限
> 
> --查看其它用户的表 使用用户名.表名  
> select * from scott.emp
> 
> --删除权限 revoke 权限或者角色名 from 用户名
> revoke dba from bjsxt;
> 
> --删除账户 drop user 用户名
> drop user bjsxt cascade;
> 
> --查看用户是否创建
> SQL>select username from dba_users;
> 
> --将权限privileges授予用户username
> SQL>grant create session to John;
> 
> --授权：连接权限 登录：
> SQL>conn John/johnpsw@test;
> 
> --将scott用户的emp表所有权限授予John，则使用下列命令：
> SQL>grant all on scott.emp to John;
> select * from scott.emp
> 
> --如果要收回授予用户John的scott用户表emp的所有权限，使用下列SQL语句：
> SQL>revoke all on scott.emp from John;
> 
> --将John用户的口令修改为 newpsw。
> SQL> alter user John identified by newpsw;
> 
> ```



------



### 2.  视图 View



#### 2.1 视图的定义



> - **视图(view)，也称虚表**，不占用物理空间，这个也是相对概念，因为视图本身的定义语句还是要存储在数据字典里的。视图只有逻辑定义。每次使用的时候,只是重新执行`SQL`。
> - 视图是从一个或多个实际表中获得的，这些表的数据存放在数据库中。那些用于产生视图的表叫做该视图的基表。一个视图也可以从另一个视图中产生。
> - **视图的定义存在数据库中，与此定义相关的数据并没有再存一份于数据库中。通过视图看到的数据存放在基表中。**
> - 视图看上去非常象数据库的物理表，对它的操作同任何其它的表一样。当通过视图修改数据时，实际上是在改变基表中的数据；相反地，基表数据的改变也会自动反映在由基表产生的视图中。由于逻辑上的原因，有些`Oracle`视图可以修改对应的基表，有些则不能（仅仅能查询）。



#### 2.2 用`SQL` 实现视图



##### 2.2.1 	创建视图

```sql
-- 视图用来简化查询语句
-- 视图其实存放的就是一个sql查询语句，
-- 视图所有的用法都跟表一样，
-- 但是对视图进行操作就是对基表来操作
-- 视图中所有的数据都是来自于基表
-- 比如从视图中查询数据，是先执行视图中保存的查询语句，再从查询语句的结果中查询数据
create or replace View V$_Emp
as select * from emp e 
```

##### 2.2.2 	查找用户视图

> - 在查询时，不需要再写完全的Select查询语句，只需要简单的写上从视图中查询的语句就可以了。
>
> ```sql
> select * from v$_emp_dept
> ```
>
> - 当视图不再需要的时候，用`drop view`  撤销。删掉视图不会导致数据的丢失，因为视图是基于数据库的表之上的一个查询定义。
>
> ```sql
> drop view  v$_emp_dept；
> ```
>
> - 查找用户视图
>
> ```sql
> select * from user_views
> where view_name = 'V_EMP_DEPT'
> --视图名要大写
> ```

##### 2.2.3 	修改视图里面的数据

> - **向视图中增加删除数据，同样会修改视图对应的表中的数据。**
>
> ```SQL
> insert into v_test01(ename,empno,job,deptno)
> values('cai30',9921,'SALESMAN',10)
> 
> delete from v_test01 where ename='cai30';
> 
> update v_test01 set ename ='cai10'
> where ename = 'cai30';
> ```

##### 2.2.4 	只读视图

> ```SQL
> --创建视图
> create or replace view v_test01 as
> (select * from emp with read only)
> 
> --测试插入数据
> insert into v_test01 (ename,empno,job,deptno)
> values('cai30',9921,'SALESMAN',10)
> ```

##### 2.2.5 	授权视图

> - 使用`system`用户为`scott`增加权限:
>
> ```sql
> grant create view,create table to scott; 
> ```
>
> - 使用`system`用户为`scott`解锁：
>
> ```sql
> alter user  scott  account  unlock; 
> ```

##### 2.2.6	 练习

```sql
--要求平均薪水的等级最低的部门，它的部门名称是什么，我们完全使用子查询
select t02.*, d.dname
  from (select t01.*, sg.grade
          from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01,
               salgrade sg
         where t01.vsal between sg.losal and sg.hisal) t02,
       dept d
where t02.grade <= all
(select sg.grade
          from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01,
               salgrade sg
         where t01.vsal between sg.losal and sg.hisal)
   and t02.deptno = d.deptno
  
-------------------
--使用视图来简化查询
--【1】将查询部门平均薪资的等级的操作   创建成一个视图
create or replace View V$_EMP_SAL as 
(select t01.*, sg.grade
      from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01,
           salgrade sg
     where t01.vsal between sg.losal and sg.hisal)
 


select es.*, d.dname
  from V$_EMP_SAL es, dept d
 where es.grade <= all (select grade from V$_EMP_SAL)
   and es.DEPTNO = d.deptno

```



------



### 3. `SQL` 增删改



#### 3.1  `Insert` 语句

```sql
--插入数据
-- 元组数据插入
/*
当插入的列不是所有的列，则需要在表名后面添加列名
然后values 后面对应的是所要插入的列的值
*/
insert into emp e (empno,ename) values (1001,'wangcai');

--如果插入的数据是所有的列，则不需要声明列名
insert into emp values(1002,'dahuang','CLERK',7782,'10-10月-2019',5000,0,10);
      
--将查询结果插入到一张表中,前提是两张表的表结构必须完全一致
insert into emp001 select * from emp e where e.deptno = 10;
```



#### 3.2  `Delete` 语句

```sql
-- 删除数据
-- 删除该表中全部数据   表结构还在
delete from emp001 e
-- 删除部分数据
delete from emp001 e where e.deptno = 10;
```



#### 3.3  `Update` 语句

``` sql
-- 数据修改
update emp001 set sal = 10000,comm = 1000 where ename ='旺财'
select * from emp001
```



------



### 4. 序列 `sequence`



#### 4.1 序列

> - **序列是oracle专有的对象，它用来产生一个自动递增的数列**。
>
> ``` sql
> --当我们的表中需要一个不重复  并且没有什么实际意义的一列的时候
> --这种情况下我们可以使用序列来生成这个不重复的数列
> create sequence seq_empno start with 2000 increment by 1;
> 
> /*
>        seq_empno.currval   获取当前数列排到了多少数字
>        seq_empno.nextval   获取该序列下一个值
> */
> --使用序列
> select seq_empcopy_id.nextval from dual  //1.
> 
> insert into empcopy (empno,ename)        //2.
> values(seq_empcopy_id.nextval,'TEST');
> 
> --查看序列状态
> select seq_empcopy_id.currval from dual
> --删除序列
> drop sequence seq_emcopy_id;
> ```



------





### 5. 事务处理



#### 5.1 定义

> ​		**事务（Transaction）是一个操作序列**。这些操作要么都做，要么都不做，是一个不可分割的工作单位，是数据库环境中的逻辑工作单位。
>
> ​		**事务是为了保证数据库的完整性，事务不能嵌套**。在`oracle`中，没有事务开始的语句。一个`Transaction `起始于一条 `DML(Insert、Update和Delete )语句`，结束于以下的几种情况：
>
> - 用户显式执行`Commit语句` 提交操作 或 `Rollback语句` 回退。
>
> - 当执行`DDL(Create、Alter、Drop)语句` 事务自动提交。
>
> - 用户正常断开连接时，`Transaction` 自动提交。
> - 系统崩溃或断电时事务自动回退。

#### 5.2 事务的ACID属性

> 1. **原子性（Atomicity）**
>
> ​         一个原子事务要么完整执行，要么干脆不执行。这意味着，工作单元中的每项任务都必须正确执行。如果有任一任务执行失败，则整个工作单元或事务就会被终止。即此前对数据所作的任何修改都将被撤销。如果所有任务都被成功执行，事务就会被提交，即对数据所作的修改将会是永久性的。
>
> 2. **一致性（Consistency）**
>
> ​       一致性代表了底层数据存储的完整性。它必须由事务系统和应用开发人员共同来保证。事务系统通过保证事务的原子性，隔离性和持久性来满足这一要求; 应用开发人员则需要保证数据库有适当的约束(主键，引用完整性等)，并且工作单元中所实现的业务逻辑不会导致数据的不一致(即，数据预期所表达的现实业务情况不相一致)。**例如，在一次转账过程中，从某一账户中扣除的金额必须与另一账户中存入的金额相等。支付宝账号100 你读到余额要取，有人向你转100 但是事物没提交（这时候你读到的余额应该是100，而不是200） 这种就是一致性。**
>
> 3. **隔离性（Isolation）**
>
> ​       隔离性意味着事务必须在不干扰其他进程或事务的前提下独立执行。换言之，在事务或工作单元执行完毕之前，其所访问的数据不能受系统其他部分的影响。
>
> 4. **持久性（Durability）**
>
> ​       持久性表示在某个事务的执行过程中，对数据所作的所有改动都必须在事务成功结束前保存至某种物理存储设备。这样可以保证，所作的修改在任何系统瘫痪时不至于丢失。



#### 5.3 Commit & Rollback 

> ​		`Commit` **表示事务成功地结束**，此时告诉系统，数据库要进入一个新的正确状态，该事务对数据库的所有更新都以交付实施。每个`Commit语句` 都可以看成是一个事务成功的结束，同时也是另一个事务的开始。
>
> ​		`Rollback` **表示事务不成功的结束**，此时告诉系统，已发生错误，数据库可能处在不正确的状态，该事务对数据库的更新必须被撤销，数据库应恢复该事务到初始状态。每个`Rollback语句` 同时也是另一个事务的开始。
>
> ​		**一旦执行了commit语句，将目前对数据库的操作提交给数据库（实际写入DB），以后就不能用rollback进行撤销。**执行一个 `DDL`，`DCL语句` 或从S`QL*Plus` 正常退出，都会自动执行`commit`命令。



#### 5.4 `提交或回滚` 前后的状态

##### 5.4.1 	提交或回滚前数据的状态

> - 以前的数据可恢复
> - 当前的用户可以看到 `DML操作`的结果
> - 其他用户不能看到 `DML操作` 的结果
> - 被操作的数据被锁住,其他用户不能修改这些数据

##### 5.4.2 	提交后数据的状态

> - 数据的修改被永久写在数据库中.
> - 数据以前的状态永久性丢失.
> - 所有的用户都能看到操作后的结果.
> - 记录锁被释放,其他用户可操作这些记录.

##### 5.4.3 回滚后数据的状态

> - 语句将放弃所有的数据修改
> - 修改的数据被回退.
> - 恢复数据以前的状态.
> - 行级锁被释放.



#### 5.5 练习

```sql
-- 事务开始于一条dml语句
insert into emp001 (empno,ename) values(1004,'dahuang');
--手动提交事务
commit;
-- 手动撤销事务
rollback;
-- 执行一个ddl语句  系统也会自动提交事务
create table emp002  as select * from emp where 1=2
-- 退出当前连接  系统也会自动提交事务

--savepoint t; 设置一个保存点，
-- 可以使用 rollback to t; 回滚到当前保存点
insert into emp001 (empno,ename) values(1005,'dahuang');
insert into emp001 (empno,ename) values(1006,'dahuang');
insert into emp001 (empno,ename) values(1007,'dahuang');
savepoint t;
insert into emp001 (empno,ename) values(1008,'dahuang');
insert into emp001 (empno,ename) values(1009,'dahuang');
insert into emp001 (empno,ename) values(1000,'dahuang');

update emp001 set empno = 1010 where empno = 1005

rollback to t;
```



------



### 6. 常用数据类型



#### 6.1 `Oracle` 常用数据类型

| 数据类型                        | 含义                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| `Varchar2(n)`                   | **变长字符串**，存储空间等与实际空间的数据大小，最大为`4K`，长度以字节为单位指定（注意中文字符） |
| ` Char(n)`                      | **定长字符串**，存储空间大小固定                             |
| `Number(p,s) `                  | 整数或小数   ，p是精度（所有数字位的个数，最大38），s是刻度范围（小数点右边的数字位个数，最大127） |
| `Date/timestamp   (精确到毫秒)` | 年、月、日、时、分、秒     `Date 精确到秒`   `timestamp(精确到毫秒) ` |

> `Long` 长字符串，最长`2GB` 。
>
> `CLOB` 最长长度`4G `存储大对象，但是一般都不会将大对象存入数据库 而是保存地址。
>
> `BLOB` 存二进制文件。



------





### 7. 数据库对象

| **对象名称** | **描述**                                                     |
| ------------ | ------------------------------------------------------------ |
| **表**       | **基本的数据存储对象，以行和列的形式存在，列也就是字段，行也就是记录** |
| **约束**     | **执行数据校验，保证了数据完整性的**                         |
| **视图**     | **一个或者多个表数据的逻辑显示**                             |
| **索引**     | **用于提高查询的性能**                                       |
| **Sequence** | **自增序列**                                                 |

> **数据库对象的命名规则：**
>
> - 必须以字母开头。
> - 可包括数字和三个特殊字符 `（#_ $）` 。
> - 不要使用`Oracle` 的保留字。
> - 同一用户下的对象不能同名。



#### 7.1 表的创建

> - 在创建新表时，指定的表名必须不存在，否则将出错。 
> - 使用默认值：当插入行时如果不给出值，`dbms` 将自动采用默认值。
> - `Create` 语句创建基本表时，最初只是一个空的框架，用户可以使用`insert命令` 把数据插入表中。
>
> ```sql
> --设计要求：建立一张存储学生信息的表，表中的字段包含了学生的学号、姓名、年龄、入学日期、年级、班级、email等信息，且为grade指定了默认值为1，如果在插入数据时不指定grade得值，就代表一年级的学生。
> create table stu(
> 	id number(6),
>     name varchar(20) not null unique,
>     sex number(1) not null
>     age number(3)
>     sdate date,
>     grade number(2) default 1,
>     class number(4),
>     email varchar2(50)
> )
> ```
>
> - 使用子查询创建表
> - 新表的字段列表必须与子查询中的字段列表匹配
> - 字段列表可以省略
>
> ```sql
> create table emp2 as select * from emp;
> ```



#### 7.2 表的修改（增加 、修改、删除字段）

> - 在基本表建立并使用一段时间后，可以根据实际需要对基本表的结构进行修改。
> - **增加新的列用。**
> - 新增加的类不能定义为 `not null`, 基本表在增加一列后，原有元组在新增加的列上的值都定义为空
>
> ```sql
> alter table emp add address varchar(20)
> ```
>
> - **删除原有的列用。**
>
> ```sql
> alter table emp drop column address	
> ```
>
> - **修改字段**
>
> ``` sql
> alter table emp modify(job varchar(50))
> ```



#### 7.3 表的删除

> - 在基本表不需要时，可以使用 `drop table` 语句撤消。在一个基本表撤消后，所有的数据都丢弃。所有相关的索引被删除。
>
> ```sql
> drop table emp cascade constraints
> ```



------



### 8. 约束 `constraint`

> - **当我们创建表的时候，同时可以指定所插入数据的一些规则，比如说某个字段不能为空值，某个字段的值（比如年龄）不能小于零等等，这些规则称为约束。约束是在表上强制执行的数据校验规则。**
>
> - **Oracle 支持下面五类完整性约束:**
>
>   ​	1. `NOT NULL`  非空
>
>   ​	2. `UNIQUE Key`  唯一键
>
>   ​	3. `PRIMARY KEY`  主键
>
>   	4. `FOREIGN KEY ` 外键
>       	5. `CHECK`  自定义检查约束
>
> - `Oracle` 使用 `SYS_Cn` 格式命名约束，也可以由用户命名。
>
> - **创建约束的时机**
>   - 在建表的同时创建
>   - 建表后创建
> - 约束从作用上分类，可以分成两大类：
>   - **表级约束**：可以约束表中的任意一列或多列。可以定义除了`Not Null` 以外的任何约束。
>   - **列级约束**：只能约束其所在的某一列。可以定义任何约束。



#### 8.1 列级约束  表级约束

> - 列级约束:  从形式上看，**在每列定义完后马上定义的约束，在逗号之前就定义好了**。
>
> ```sql 
> create table parent(c1 number primary key);
> create table child (c number primary key,c2 number references parent(c1));
> ```
>
> 
>
> - 表级约束:   从形式上可以看出与列级约束的区别了吧。
>
> ```sql
> create table child(c number , c2 number , 
>   primary key(c), foreugn key(c2) references parent(c1));
> ```
>
> 



#### 8.2 `NOT NULL`  非空约束  

> - `NOT NULL ` **约束只能在列级定义，不能在表级定义**。
> - **确保字段值不允许为空**
>
> ```sql
> 
> create table emp01(
> 	eno number(6) NOT NULL,
> 	name varchar2(10) contraint nn_name2 NOT NULL,
>     salary number(6,2)
> );
> ```



#### 8.3 `PRIMARY KEY`  主键约束

> - `主键约束` 是数据库中最重要的一种约束。**在关系中，主键值不可为空，也不允许出现重复，即关系要满足实体完整性规则。**
>   - 主键从功能上看相当于**非空且唯一**。
>   - **一个表中只允许一个主键。**
>   - 主键是表中能够唯一确定一个行数据的字段。
>   - 主键字段可以是单字段或者是多字段的组合。
>   - `Oracle` 为主键创建对应的唯一索引。
> - **主键的定义**
>
> ```sql
> /*主键可用下列两种形式之一定义
> 主键子句
> 	在表的定义中加上 如下子句 primary key(列)
> 主键短语
> 	在主属性的定义之后加 上primary key字样。
> 上述形式Oracle会自动命名约束，可自己给约束起名
> */
> create table t1(
> 	id number(4),
>     constraint t1_pk primary key(id)
> )
> 
> create table t2(
> 	sid number(10),
>     sno varchar2(10),
>     sname varchar2(50) not null,
>     constraint pk_sid_t2 primary key(sid,sno)
> )
> ```



#### 8.4 `FOREIGN KEY` 外键约束

> - **外键是表中的一个列，其值必须在另一表的主键或者唯一键中列出**。
>
> - **作为主键的表称为“主表”，作为外键的关系称为“依赖表”**。
>
> - **外键参照的是主表的主键或者唯一键**。
>
> - 对于主表的删除和修改主键值的操作，会对依赖关系产生影响，
>
>   以删除为例：当要删除主表某个记录（删除一个主键值，那么对依赖的影响可采取下列3种做法）：
>
>   - `RESTRICT方式`：只有当依赖表中没有一个外键值与要删除的主表中主键值相对应时，才可执行删除操作。
>
>   - `CASCADE方式`：将依赖表中所有外键值与主表中要删除的主键值相对应的记录一起删除
>
>   - `SET NULL方式`：将依赖表中所有与主表中被删除的主键值相对应的外键值设为空值
>
>   - FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
>
>     [ON DELETE [CASCADE|SET NULL]] 如省略on短语，缺省为第一中处理方式。



#### 8.5  `UNIQUE` 唯一性约束

> - 唯一性约束条件确保所在的字段或者字段组合不出现重复值。
> - **唯一性约束条件的字段允许出现空值。**
> - `Oracle` 将为唯一性约束条件创建对应的唯一性索引
>
> ```sql
> create table t1(
> 	id number(6),
>     name varchar2(50) NOT NULL UNIQUE,
>     email varchar2(25),
>     salary number(8,2),
>     constraint emp_email_uk UNIQUE(email)
> )
> ```



#### 8.6 `CHECK` 约束

> - `Check约束` **用于对一个属性的值加以限制。**
> - 在 `check` 中定义检查的条件表达式，数据需要符合设置的条件。
>
> ```sql
> --在这种约束下，插入记录或修改记录时，系统要测试新的记录的值是否满足条件
> create table emp3(
> 	id number(4) primary key,
>     age number(2) check(age >0 and age< 100),
>     salary number(7,2),
>     sex char(1),
>     constraint salary_check check(salary > 0)
> )
> ```



------



### 9. 索引

> - **索引是为了加快对数据的搜索速度而设立的**。索引是方案（schema）中的一个数据库对象,与表独立存放。
>
> - **索引的作用：在数据库中用来加速对表的查询,通过使用快速路径访问方法快速定位数据,减少了磁盘的I/O**。
>
> - `SQL` 中的索引是非显示索引，也就是在索引创建以后，在用户撤销它之前不会在用到该索引的名字，但是索引在用户查询时会自动起作用。
>
> - 索引的创建有两种情况：
>   - **自动:** 当在表上定义一个`PRIMARY KEY` 或者`UNIQUE 约束` 条件时,`Oracle数据库`自动创建一个对应的唯一索引。
>   - **手动:** 用户可以创建索引以加速查询。



#### 9.1 索引的要点

> - **开发中使用索引的要点**：
>   - **索引改善检索操作的性能，但降低数据插入、修改和删除的性能。**在执行这些操作时，DBMS必须动态地更新索引。
>   -  索引数据可能要占用大量的存储空间。
>   - 并非所有的数据都适合于索引。唯一性不好的数据（如省）从索引得到的好处不比具有更多可能值的数据（如姓名）从索引得到的好处多。
>   - **索引用于数据过滤和数据排序。**如果你经常以某种特定的顺序排序数据，则该数据可能是索引的备选。
>   - 可以在索引中定义多个列（如省加城市），这样的索引只在以省加城市的顺序排序时有用。如果想按城市排序，则这种索引没有用处。



#### 9.2 创建\删除索引

> - 在一列或者多列上创建索引。
>
> ```sql
> create INDEX index ON table (column[, column]...)
> ```
>
> - 下面的索引将会提高对`EMP表` 基于`ENAME 字段`的查询速度.
>
> ```sql
> create INDEX emp_last_name_idx
> ON emp(ename)
> ```
>
> - 通过`DROP INDEX` 命令删掉一个索引
>
> ```sql
> DROP INDEX index	
> ```
>
> - 删掉`UPPER_LAST_NAME_IDX` 索引
>
> ```sql
> DROP INDEX upper_last_name_idx;
> ```



------



### 10. `rowid`

> - `rowid `是`oracle` 实际存在的值，是唯一的值。
>
> - `rownum `是一个虚拟的顺序值 ，前提是一定要排序。
>
> ```sql
> select emp.* , rowid from emp;
> 
> --删除字段ename中 rowid 最小的值
> delete from emp e where rowid not in 
> (select min(rowid)
>  from emp
>  group by ename
> )
> 
> --如何只显示重复数据，或不显示重复数据
>    --显示重复：
>    select * from tablename group by id having count(*)>1
>    --不显示重复：
>    select * from tablename group by id having count(*)=1
>    
> --删除重复数据原型：
> delete from temp where rowid not in (
> 	select min(rowid) from emp group by ename having count(*) >= 1)	
> and ename='wangcai'
> 
> ```



------



### 11. 三范式 （见word）