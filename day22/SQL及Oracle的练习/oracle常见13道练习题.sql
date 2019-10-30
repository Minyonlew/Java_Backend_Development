--1.  ������нˮ��ߵ���
select * from emp e ,
 (select max(e.sal) msal ,e.deptno from emp e group by e.deptno) t1
 where e.sal = t1.msal;
 
--2.  ����ƽ��нˮ�ĵȼ�
select  t01.deptno,t01.vsal,sg.grade from
(select e.deptno ,avg(e.sal) vsal  from emp e group by e.deptno) t01, salgrade sg
where t01.vsal between sg.losal and sg.hisal;
 
--3.  ����ƽ����нˮ�ȼ�
select avg(t01.grade), t01.deptno
  from (select *
          from emp e
          left join salgrade sg
            on e.sal between sg.losal and sg.hisal) t01
 group by t01.deptno;
 
-- 4.  ��Ա������Щ���Ǿ�����
select * from emp e where e.empno in (select e2.mgr from emp e2);
 
-- 5.  ��׼���麯������нˮ�����ֵ
-- �麯�� : max min count avg sum
select *
  from (select e.sal, e.deptno, e.ename from emp e order by sal desc) t01
 where rownum < 2;
 
-- 6.  ��ƽ��нˮ��ߵĲ��ŵĲ��ű��
select t01.deptno,t01.vsal,rownum from
(select avg(e.sal) vsal,e.deptno from emp e group by e.deptno order by vsal desc) t01
where rownum < 2;
 
--7.  ��ƽ��нˮ��ߵĲ��ŵĲ�������
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
 
--8.  ��ƽ��нˮ�ĵȼ���͵Ĳ��ŵĲ�������
select *
  from dept d,
       (select t01.deptno, t01.vsal
          from (select avg(e.sal) vsal, e.deptno
                  from emp e
                 group by e.deptno
                 order by vsal) t01
         where rownum < 2) t02
 where d.deptno = t02.deptno;
 

 
-- 9.  ���ž�������ƽ��нˮ��͵Ĳ�������
select * from emp e;
select * from dept;
-- ���ҳ���Щ���ǲ��ž���
-- �ٰ��ղ��ŷ��� ���������Ŀ�����ƽ��нˮ

select t03.vsal,t03.deptno,d.dname from
(select vsal, t02.deptno
  from (select avg(t01.sal) vsal, t01.deptno
          from (select *
                  from emp e
                 where e.empno in (select e2.mgr from emp e2)) t01
         group by deptno
         order by vsal desc) t02
 where rownum < 2) t03 ,dept d where t03.deptno = d.deptno


 
--10. �����ͨԱ�������нˮ��Ҫ�ߵľ���������(not in)
--���ҳ����зǾ����˵�Ա���й�����ߵ�
select *
  from (select * from emp e where e.empno in (select e2.mgr from emp e2)) t02
 where t02.sal >
       (select max(e0.sal)
          from emp e0
         where e0.empno not in
               (select e.empno
                  from emp e
                 where e.empno in (select e2.mgr from emp e2)));
 
--11. ��нˮ��ߵ�ǰ5����Ա
select * from 
(select * from emp e order by sal desc) t01 where rownum <6

 
12. ��нˮ��ߵĵ�6����10����Ա(important)
select *
  from (select t01.*, rownum r
          from (select * from emp e order by sal desc) t01) t02
 where t02.r > 5 and t02.r<11;

 
--13. �������ְ��5��Ա��
select t01.*, rownum r
  from (select e.* from emp e order by e.hiredate desc) t01
 where rownum < 6
