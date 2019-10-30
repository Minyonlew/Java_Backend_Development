
--1、查询10号部门中编号最新入职的员工，工龄最长的员工的个人信息。
--工龄最长的
select min(e.hiredate) from emp e where e.deptno = 10;
-- 最新入职的
select max(e.hiredate) from emp e where e.deptno = 10;

select e1.*
  from emp e1
 where e1.hiredate in
       ((select min(e.hiredate)
          from emp e
         where e.deptno = 10),
         (select max(e.hiredate) from emp e where e.deptno = 10)
        );
--2、从“software”找到‘f’的位置，用‘*’左右填充到15位，去除其中的‘a’。
select instr ('software','f')  from dual;
select lpad('software',15,'*') from dual;
select rpad('software',15,'*') from dual;
select replace('software','a') from dual;


--3、查询员工的奖金，如果奖金不为NULL显示‘有奖金’，为null则显示无奖金
select e.ename ,nvl2(e.comm,'无奖金'，'有奖金') from emp e;
select decode(e.comm,null,'无奖金','有奖金') from emp e

--4、写一个查询显示当前日期，列标题显示为Date。
select sysdate "date"  from dual;
--显示六个月后的日期，
select sysdate "date",next_day(add_months(sysdate,6),2) from dual;
--该月最后一天的日期。
select trunc(last_day(sysdate)) from dual;
--  下一个星期 日的日期， trunc 截断，只显示日期
select  trunc( next_day(sysdate,1)) from dual;

--5、查询EMP表按管理者编号升序排列，如果管理者编号为空则把为空的在最前显示   
 select e.* from emp e order by nvl(e.mgr,0); 
 select e.* from emp e order by e.mgr nulls first; 
--6、求部门平均薪水
select e.deptno, avg(e.sal) from emp e group by e.deptno;
--7、按部门求出工资大于1300人员的 部门编号、平均工资、最小佣金、最大佣金,并且最大佣金大于100
select e.deptno, avg(e.sal), min(e.comm), max(e.comm)
  from emp e
 where e.sal > 1300
 group by e.deptno having max(e.comm) > 100;
--8、找出每个部门的平均、最小、最大薪水
select avg(e.sal) ,min(e.sal),max(e.sal) from emp e group by e.deptno;
--9、查询出雇员名，雇员所在部门名称， 工资等级
select e.ename, d.deptno, sg.grade
  from emp e, dept d, salgrade sg
 where e.deptno = d.deptno
   and e.sal between sg.losal and sg.hisal;
-- 按照部门查询出来最新入职和工龄最大的人员
select min(e.hiredate), max(e.hiredate), e.deptno
  from emp e
 group by e.deptno

--1
