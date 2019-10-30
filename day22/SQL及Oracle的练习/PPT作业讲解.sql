--1、求平均薪水最高的部门的部门编号

--  [1]各个部门的平均薪水
select avg(e.sal), e.deptno from emp e group by e.deptno;
-- [2]取出最大的平均薪水
select max(avg(e.sal)) from emp e group by e.deptno;

-- 将[1]和[2]作为两张表 表一 表二  查出来表一中等于表二中的最大的平均薪水的一条数据的部门编号
select t1.deptno  from
(select avg(e.sal) vsal, e.deptno from emp e group by e.deptno) t1,
(select min(avg(e.sal)) msal from emp e group by e.deptno) t2 
where t1.vsal = t2.msal;

-- 使用rownum 解决  
  select t01.* ,rownum from
  (select avg(e.sal) vsal from emp e group by e.deptno order by vsal desc) t01
  where rownum  = 1;
  
  
-- rownum 加行号
select ename ,rownum from emp;
--取出前五行
select ename ,rownum  from emp where rownum <= 5;
-- rownum 不能直接使用大于号  如何取出 大于 5 的行数
-- 使用子查询
select * from(select ename ,rownum r from emp) t1  where t1.r > 5;


--2、求部门平均薪水的等级
-- 平均薪水
select sg.grade ,t01.deptno ,t01.vsal
  from salgrade sg, (select avg(sal) vsal,deptno from emp e group by e.deptno) t01
 where t01.vsal between sg.losal and sg.hisal
 
--3、求部门平均的薪水等级
select avg(t01.grade),t01.deptno from
(select * from emp e left join salgrade sg on e.sal between sg.losal and sg.hisal) t01 group by t01.deptno



--4、求薪水最高的前5名雇员
select * from emp e order by e.sal desc;
-- select 比order 先执行 导致rownum顺序不对
select e.* ,rownum from emp e order by e.sal desc;
-- 解决
select t01.* ,rownum from 
(select e.*  from emp e order by e.sal desc) 
t01 where rownum <= 5
--5、求薪水最高的第6到10名雇员
select *
  from (select t01.*, rownum r
          from (select e.* from emp e order by e.sal desc) t01) t02
 where t02.r >= 6
   and t02.r <= 10;

-- 优化 
-- 先取出前十条   然后再从前十条取出6~10 条
select *
  from (select t01.*, rownum r
          from (select e.* from emp e order by e.sal desc) t01 where rownum <=10) t02
 where t02.r >= 6;



