/**
课堂练习  PPT 第21页
 1、查询82年员工
  2、查询32年工龄的人员
  3、显示员工雇佣期 6 个月后下一个星期一的日期
  
  4、为所有人长工资，标准是：10部门长10%；20部门长15%；30部门长20%其他部门长18%
*/
--1
select e.* from emp e  where to_char(e.hiredate,'yyyy')='1982'
select e.* from emp e  where to_char(e.hiredate,'yy') like '82';
--2
select  (sysdate-e.hiredate)/365 "time" from emp e where floor((sysdate-e.hiredate)/365)=35
--3
--获取6个月以后的日期
select add_months(e.hiredate,6) ,e.ename,e.hiredate from emp e;
--获取入职后的6个月的下一个星期一
select next_day(add_months(e.hiredate,6),'星期一') ,e.ename,e.hiredate from emp e;
--获取下一个星期日  一  二 
-- next_day(sysdate,1),next_day(sysdate,2),next_day(sysdate,3)
select next_day(sysdate,1) from dual;

--4 
select decode(e.deptno,
              10,
              e.sal * 1.1,
              20,
              e.sal * 1.15,
              30,
              e.sal * 1.2,
              e.sal * 1.18) "newSal",
       e.ename,
       e.sal,
       e.deptno
  from emp e;
