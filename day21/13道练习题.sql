-- 1.求部门中薪水最高的人
-- 92
select e.ename, e.sal, e.deptno
  from emp e,
       (select e.deptno, max(e.sal) maxsal from emp e group by e.deptno) t01
 where e.sal = t01.maxsal
   and e.deptno = t01.deptno
-- 99 
select e.ename, e.sal, e.deptno
  from (select e.deptno, max(e.sal) maxsal from emp e group by e.deptno) t01
  join emp e
    on e.sal = t01.maxsal
   and e.deptno = t01.deptno
--2.求部门平均薪水的等级
-- 92
select t01.deptno, t01.vsal, sg.grade
  from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01,
       salgrade sg
 where t01.vsal between sg.losal and sg.hisal
 
 
 -- 99
 select t01.deptno, t01.vsal, sg.grade
   from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01
   join salgrade sg
     on t01.vsal between sg.losal and sg.hisal
 
--3.求部门平均的薪水等级
-- 92
select t01.deptno, avg(t01.grade)
  from (select e.deptno, sg.grade
          from emp e, salgrade sg
         where e.sal between sg.losal and sg.hisal) t01
 group by t01.deptno
 -- 99 
 select t01.deptno, avg(t01.grade)
   from (select e.deptno, sg.grade
           from emp e
           join salgrade sg
             on e.sal between sg.losal and sg.hisal) t01
  group by t01.deptno
--4.雇员中有哪些人是经理人
select e.* from emp e where e.empno in (select distinct e.mgr from emp e)

 
-- 5.不准用组函数，求薪水的最高值
select e.* from emp e where e.sal >= all (select e.sal from emp e)
 
--6.求平均薪水最高的部门的部门编号
--[1]先按照部门分组  求平均薪水
select avg(e.sal) from emp e group by e.deptno
--[2]查找最高
select e.deptno, avg(e.sal)
  from emp e
 group by e.deptno
having avg(e.sal) >= all (select avg(e.sal) from emp e group by e.deptno)
  
--7.求平均薪水最高的部门的部门名称
select t01.deptno, t01.vsal, d.dname
  from (select e.deptno, avg(e.sal) vsal
          from emp e
         group by e.deptno
        having avg(e.sal) >= all (select avg(e.sal)
                                   from emp e
                                  group by e.deptno)) t01,
       dept d
 where d.deptno = t01.deptno
 
-- 8.求平均薪水的等级最低的部门的部门名称
-- 92
select t02.deptno, t02.grade, d.dname
  from (select t01.deptno, t01.vsal, sg.grade
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


-- 99 
select t02.deptno, t02.vsal, t02.grade, d.dname
  from (select t01.deptno, t01.vsal, sg.grade
          from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01
          join salgrade sg
            on t01.vsal between sg.losal and sg.hisal) t02
  join dept d
    on t02.deptno = d.deptno
 where t02.grade <= all
 (select sg.grade
          from (select e.deptno, avg(e.sal) vsal from emp e group by e.deptno) t01
          join salgrade sg
            on t01.vsal between sg.losal and sg.hisal)

 
--9.求部门经理人中平均薪水最低的部门名称
-- [1]查询那些人是经理
select e.* from emp e where e.empno in (select nvl(e.mgr, 0) from emp e)
-- [2] 按照部门编号，对经理人进行分组，求平均薪资
select t01.deptno, avg(t01.sal)
  from (select e.*
          from emp e
         where e.empno in (select nvl(e.mgr, 0) from emp e)) t01
 group by t01.deptno
 --[3] 求平均薪资最低的部门
 
select t02.deptno, t02.vsal
  from (select t01.deptno, avg(t01.sal) vsal
          from (select e.*
                  from emp e
                 where e.empno in (select nvl(e.mgr, 0) from emp e)) t01
         group by t01.deptno) t02
 where t02.vsal <= all
 (select avg(t01.sal) vsal
          from (select e.*
                  from emp e
                 where e.empno in (select nvl(e.mgr, 0) from emp e)) t01
         group by t01.deptno)

--[4]和部门表关联查询
select t02.deptno, t02.vsal, d.dname
  from (select t01.deptno, avg(t01.sal) vsal
          from (select e.*
                  from emp e
                 where e.empno in (select nvl(e.mgr, 0) from emp e)) t01
         group by t01.deptno) t02,
       dept d
 where t02.vsal <= all
 (select avg(t01.sal) vsal
          from (select e.*
                  from emp e
                 where e.empno in (select nvl(e.mgr, 0) from emp e)) t01
         group by t01.deptno)
   and t02.deptno = d.deptno

 
-- 10.求比普通员工的最高薪水还要高的经理人名称(not in)
   --[1]查询出来所有普通员工  并且查询出来最高的薪水
   select max(e.sal) from emp e where e.empno not in (select nvl(e.mgr,0) from emp e)
   --[2]查询那些人是经理   并且薪资大于【1】中的薪资
   select e.*
     from emp e
    where e.empno in (select nvl(e.mgr, 0) from emp e)
      and e.sal >
          (select max(e.sal)
             from emp e
            where e.empno not in (select nvl(e.mgr, 0) from emp e))
--11.求薪水最高的前5名雇员
select *
  from (select e.* from emp e order by e.sal desc) t01
 where rownum <= 5
 
--12.求薪水最高的第6到第10名雇员(important)
select t02.*
  from (select t01.*, rownum r
          from (select e.* from emp e order by e.sal desc) t01) t02
 where t02.r >= 6
   and t02.r <= 10
--13.求最后入职的5名员工
select *
from 
(select e.*
from emp e 
order by e.hiredate desc) t01
where rownum <= 5
 
