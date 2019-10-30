--查询工作为SALESMAN，MANAGER并且工资大于2500的员工信息
  --and关键字的执行级别高于or
  --可以使用小括号提升条件的执行级别，使用了小括号的级别是最高的
select * from emp where (job='SALESMAN' or job='MANAGER') and sal>2500
----------------------------------------------------------------------------
--Oracle函数学习(单行函数，多行函数，转换函数，其他函数)
   --单行函数学习(字符函数，数值函数，日期函数)
       --特点1：不改变真实数据，只是对数据做了进一步修饰或者处理显示。
      --特点2：可以和字段混合使用
      --使用:select 字段名， 函数名(字段名)，字段名....from 表名
      --字符函数：
          --查询所有的员工信息，员工姓名小写显示。
          select empno,ename,lower(ename),job,mgr,sal，lower('HH') from emp
         --查询所有的员工信息，员工姓名首字母大写。
         select empno,INITCAP(ename) 首字母大写的姓名,lower(ename),job from emp
      --数值函数：对数值类型的数据进行运算
           --伪表：真实存在的表，是为了方便进行数据的验证而临时存在的表。表名为：dual
          select abs(-1),ceil(2.2),floor(3.3),power(2,3),mod(5,2),round(4.55),trunc(10/3,2) from dual
      --日期函数：
          select months_between('01-1月-2018','24-6月-2017') from dual --返回两个日期间的月份数  
          select add_months('01-4月-2018'，-4) from dual --返回指定月数后的日期
          select next_day('16-4月-2018','星期二') from dual--查询最近的星期的日期
          select last_day('16-4月-2018') from dual--返回当月的最后一天的日期
          select round(to_date('19-4月-2018'),'DAY') from dual--按照星期进行四舍五入
   --多行函数(max,min,avg,sum,count)很重要
      --作用：对查询的数据进行统计
      --使用：select 多行函数名(字段名),多行函数名(字段名)..from 表名
          --注意：多行函数不能和普通字段以及单行函数混用，除非分组
      --max（字段名） 返回该字段的最大值
      --min(字段名) 返回该字段的最小值
      --sum(字段名) 返回该字段的和
      --avg(字段名) 返回该字段的平均值
      --count
              --count(*) 返回表的记录数
              --count(字段名) 返回非空值的数量
              --count(distinct 字段名) 去除重复后的字段值的数量
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
      select * from emp 
      
      
