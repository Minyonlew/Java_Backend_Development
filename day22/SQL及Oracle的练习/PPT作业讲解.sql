--1����ƽ��нˮ��ߵĲ��ŵĲ��ű��

--  [1]�������ŵ�ƽ��нˮ
select avg(e.sal), e.deptno from emp e group by e.deptno;
-- [2]ȡ������ƽ��нˮ
select max(avg(e.sal)) from emp e group by e.deptno;

-- ��[1]��[2]��Ϊ���ű� ��һ ���  �������һ�е��ڱ���е�����ƽ��нˮ��һ�����ݵĲ��ű��
select t1.deptno  from
(select avg(e.sal) vsal, e.deptno from emp e group by e.deptno) t1,
(select min(avg(e.sal)) msal from emp e group by e.deptno) t2 
where t1.vsal = t2.msal;

-- ʹ��rownum ���  
  select t01.* ,rownum from
  (select avg(e.sal) vsal from emp e group by e.deptno order by vsal desc) t01
  where rownum  = 1;
  
  
-- rownum ���к�
select ename ,rownum from emp;
--ȡ��ǰ����
select ename ,rownum  from emp where rownum <= 5;
-- rownum ����ֱ��ʹ�ô��ں�  ���ȡ�� ���� 5 ������
-- ʹ���Ӳ�ѯ
select * from(select ename ,rownum r from emp) t1  where t1.r > 5;


--2������ƽ��нˮ�ĵȼ�
-- ƽ��нˮ
select sg.grade ,t01.deptno ,t01.vsal
  from salgrade sg, (select avg(sal) vsal,deptno from emp e group by e.deptno) t01
 where t01.vsal between sg.losal and sg.hisal
 
--3������ƽ����нˮ�ȼ�
select avg(t01.grade),t01.deptno from
(select * from emp e left join salgrade sg on e.sal between sg.losal and sg.hisal) t01 group by t01.deptno



--4����нˮ��ߵ�ǰ5����Ա
select * from emp e order by e.sal desc;
-- select ��order ��ִ�� ����rownum˳�򲻶�
select e.* ,rownum from emp e order by e.sal desc;
-- ���
select t01.* ,rownum from 
(select e.*  from emp e order by e.sal desc) 
t01 where rownum <= 5
--5����нˮ��ߵĵ�6��10����Ա
select *
  from (select t01.*, rownum r
          from (select e.* from emp e order by e.sal desc) t01) t02
 where t02.r >= 6
   and t02.r <= 10;

-- �Ż� 
-- ��ȡ��ǰʮ��   Ȼ���ٴ�ǰʮ��ȡ��6~10 ��
select *
  from (select t01.*, rownum r
          from (select e.* from emp e order by e.sal desc) t01 where rownum <=10) t02
 where t02.r >= 6;



