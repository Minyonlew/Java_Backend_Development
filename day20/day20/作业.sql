--1.选择部门30中的所有员工.
  select * from emp where deptno=30
--2.列出所有办事员(CLERK)的姓名，编号和部门编号.
select empno,ename,deptno from emp where job='CLERK'

--3.找出佣金高于薪金的员工.
select * from emp where comm>sal
--4.找出佣金高于薪金的60%的员工.
select * from emp where comm > sal* 0.6
--5.找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK)的详细资料.
select * from emp where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK');
--6.找出部门10中所有经理(MANAGER),部门20中所有办事员(CLERK),既不是经理又不是办事员但其薪金大于或等于2000的所有员工的详细资料.
select * from emp where (job<>'MANAGER' and job<>'CLERK' and sal >= 2000) or(deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK')
--7.找出收取佣金的员工的不同工作.
select distinct job from emp where comm is not null
--8.找出不收取佣金或收取的佣金低于100的员工.
select * from emp where comm is null or comm<100
--10.找出早于12年前受雇的员工.
select * from emp where hiredate <'01-1月-1982'  order by hiredate
--11.以首字母大写的方式显示所有员工的姓名.
--13.显示不带有"R"的员工的姓名.
select * from emp where ename not like '%R%';
--17.显示员工的详细资料,按姓名排序.
select *from emp order by ename
--18.显示员工的姓名和受雇日期,根据其服务年限,将最老的员工排在最前面.
select ename,hiredate from emp order by hiredate
--19.显示所有员工的姓名、工作和薪金,按工作的降序排序,若工作相同则按薪金排序.
select ename,job,sal from emp  order by job desc,sal desc
--20.显示所有员工的姓名、加入公司的年份和月份,按受雇日期所在月排序,若月份相同则将最早年份的员工排在最前面.

--24.显示姓名字段的任何位置包含"A"的所有员工的姓名.
select ename from emp where ename like '%A%'
