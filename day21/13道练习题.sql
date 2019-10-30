-- 1.������нˮ��ߵ���
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
--2.����ƽ��нˮ�ĵȼ�
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
 
--3.����ƽ����нˮ�ȼ�
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
--4.��Ա������Щ���Ǿ�����
select e.* from emp e where e.empno in (select distinct e.mgr from emp e)

 
-- 5.��׼���麯������нˮ�����ֵ
select e.* from emp e where e.sal >= all (select e.sal from emp e)
 
--6.��ƽ��нˮ��ߵĲ��ŵĲ��ű��
--[1]�Ȱ��ղ��ŷ���  ��ƽ��нˮ
select avg(e.sal) from emp e group by e.deptno
--[2]�������
select e.deptno, avg(e.sal)
  from emp e
 group by e.deptno
having avg(e.sal) >= all (select avg(e.sal) from emp e group by e.deptno)
  
--7.��ƽ��нˮ��ߵĲ��ŵĲ�������
select t01.deptno, t01.vsal, d.dname
  from (select e.deptno, avg(e.sal) vsal
          from emp e
         group by e.deptno
        having avg(e.sal) >= all (select avg(e.sal)
                                   from emp e
                                  group by e.deptno)) t01,
       dept d
 where d.deptno = t01.deptno
 
-- 8.��ƽ��нˮ�ĵȼ���͵Ĳ��ŵĲ�������
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

 
--9.���ž�������ƽ��нˮ��͵Ĳ�������
-- [1]��ѯ��Щ���Ǿ���
select e.* from emp e where e.empno in (select nvl(e.mgr, 0) from emp e)
-- [2] ���ղ��ű�ţ��Ծ����˽��з��飬��ƽ��н��
select t01.deptno, avg(t01.sal)
  from (select e.*
          from emp e
         where e.empno in (select nvl(e.mgr, 0) from emp e)) t01
 group by t01.deptno
 --[3] ��ƽ��н����͵Ĳ���
 
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

--[4]�Ͳ��ű������ѯ
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

 
-- 10.�����ͨԱ�������нˮ��Ҫ�ߵľ���������(not in)
   --[1]��ѯ����������ͨԱ��  ���Ҳ�ѯ������ߵ�нˮ
   select max(e.sal) from emp e where e.empno not in (select nvl(e.mgr,0) from emp e)
   --[2]��ѯ��Щ���Ǿ���   ����н�ʴ��ڡ�1���е�н��
   select e.*
     from emp e
    where e.empno in (select nvl(e.mgr, 0) from emp e)
      and e.sal >
          (select max(e.sal)
             from emp e
            where e.empno not in (select nvl(e.mgr, 0) from emp e))
--11.��нˮ��ߵ�ǰ5����Ա
select *
  from (select e.* from emp e order by e.sal desc) t01
 where rownum <= 5
 
--12.��нˮ��ߵĵ�6����10����Ա(important)
select t02.*
  from (select t01.*, rownum r
          from (select e.* from emp e order by e.sal desc) t01) t02
 where t02.r >= 6
   and t02.r <= 10
--13.�������ְ��5��Ա��
select *
from 
(select e.*
from emp e 
order by e.hiredate desc) t01
where rownum <= 5
 
