--1.  求部门中薪水最高的人
select * from emp e ,
 (select max(e.sal) msal ,e.deptno from emp e group by e.deptno) t1
 where e.sal = t1.msal;
 
--2.  求部门平均薪水的等级
select  t01.deptno,t01.vsal,sg.grade from
(select e.deptno ,avg(e.sal) vsal  from emp e group by e.deptno) t01, salgrade sg
where t01.vsal between sg.losal and sg.hisal;
 
--3.  求部门平均的薪水等级
select avg(t01.grade), t01.deptno
  from (select *
          from emp e
          left join salgrade sg
            on e.sal between sg.losal and sg.hisal) t01
 group by t01.deptno;
 
-- 4.  雇员中有哪些人是经理人
select * from emp e where e.empno in (select e2.mgr from emp e2);
 
-- 5.  不准用组函数，求薪水的最高值
-- 组函数 : max min count avg sum
select *
  from (select e.sal, e.deptno, e.ename from emp e order by sal desc) t01
 where rownum < 2;
 
-- 6.  求平均薪水最高的部门的部门编号
select t01.deptno,t01.vsal,rownum from
(select avg(e.sal) vsal,e.deptno from emp e group by e.deptno order by vsal desc) t01
where rownum < 2;
 
--7.  求平均薪水最高的部门的部门名称
select * from emp e;
select * from dept;

select *
  from dept d,
       (select t01.deptno, t01.vsal, rownum
          from (select avg(e.sal) vsal, e.deptno
                  from emp e
                 group by e.deptno
                 order by vsal desc) t01
         where rownum < 3) t02
 where d.deptno = t02.deptno;
 
--8.  求平均薪水的等级最低的部门的部门名称
select *
  from dept d,
       (select t01.deptno, t01.vsal
          from (select avg(e.sal) vsal, e.deptno
                  from emp e
                 group by e.deptno
                 order by vsal) t01
         where rownum < 2) t02
 where d.deptno = t02.deptno;
 

 
-- 9.  求部门经理人中平均薪水最低的部门名称
select * from emp e;
select * from dept;
-- 先找出那些人是部门经理
-- 再按照部门分类 求出部门项目经理的平均薪水

select t03.vsal,t03.deptno,d.dname from
(select vsal, t02.deptno
  from (select avg(t01.sal) vsal, t01.deptno
          from (select *
                  from emp e
                 where e.empno in (select e2.mgr from emp e2)) t01
         group by deptno
         order by vsal desc) t02
 where rownum < 2) t03 ,dept d where t03.deptno = d.deptno


 
--10. 求比普通员工的最高薪水还要高的经理人名称(not in)
--先找出所有非经理人的员工中工资最高的
select *
  from (select * from emp e where e.empno in (select e2.mgr from emp e2)) t02
 where t02.sal >
       (select max(e0.sal)
          from emp e0
         where e0.empno not in
               (select e.empno
                  from emp e
                 where e.empno in (select e2.mgr from emp e2)));
 
--11. 求薪水最高的前5名雇员
select * from 
(select * from emp e order by sal desc) t01 where rownum <6

 
12. 求薪水最高的第6到第10名雇员(important)
select *
  from (select t01.*, rownum r
          from (select * from emp e order by sal desc) t01) t02
 where t02.r > 5 and t02.r<11;

 
--13. 求最后入职的5名员工
select t01.*, rownum r
  from (select e.* from emp e order by e.hiredate desc) t01
 where rownum < 6
