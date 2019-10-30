
--1����ѯ10�Ų����б��������ְ��Ա�����������Ա���ĸ�����Ϣ��
--�������
select min(e.hiredate) from emp e where e.deptno = 10;
-- ������ְ��
select max(e.hiredate) from emp e where e.deptno = 10;

select e1.*
  from emp e1
 where e1.hiredate in
       ((select min(e.hiredate)
          from emp e
         where e.deptno = 10),
         (select max(e.hiredate) from emp e where e.deptno = 10)
        );
--2���ӡ�software���ҵ���f����λ�ã��á�*��������䵽15λ��ȥ�����еġ�a����
select instr ('software','f')  from dual;
select lpad('software',15,'*') from dual;
select rpad('software',15,'*') from dual;
select replace('software','a') from dual;


--3����ѯԱ���Ľ����������ΪNULL��ʾ���н��𡯣�Ϊnull����ʾ�޽���
select e.ename ,nvl2(e.comm,'�޽���'��'�н���') from emp e;
select decode(e.comm,null,'�޽���','�н���') from emp e

--4��дһ����ѯ��ʾ��ǰ���ڣ��б�����ʾΪDate��
select sysdate "date"  from dual;
--��ʾ�����º�����ڣ�
select sysdate "date",next_day(add_months(sysdate,6),2) from dual;
--�������һ������ڡ�
select trunc(last_day(sysdate)) from dual;
--  ��һ������ �յ����ڣ� trunc �ضϣ�ֻ��ʾ����
select  trunc( next_day(sysdate,1)) from dual;

--5����ѯEMP�������߱���������У���������߱��Ϊ�����Ϊ�յ�����ǰ��ʾ   
 select e.* from emp e order by nvl(e.mgr,0); 
 select e.* from emp e order by e.mgr nulls first; 
--6������ƽ��нˮ
select e.deptno, avg(e.sal) from emp e group by e.deptno;
--7��������������ʴ���1300��Ա�� ���ű�š�ƽ�����ʡ���СӶ�����Ӷ��,�������Ӷ�����100
select e.deptno, avg(e.sal), min(e.comm), max(e.comm)
  from emp e
 where e.sal > 1300
 group by e.deptno having max(e.comm) > 100;
--8���ҳ�ÿ�����ŵ�ƽ������С�����нˮ
select avg(e.sal) ,min(e.sal),max(e.sal) from emp e group by e.deptno;
--9����ѯ����Ա������Ա���ڲ������ƣ� ���ʵȼ�
select e.ename, d.deptno, sg.grade
  from emp e, dept d, salgrade sg
 where e.deptno = d.deptno
   and e.sal between sg.losal and sg.hisal;
-- ���ղ��Ų�ѯ����������ְ�͹���������Ա
select min(e.hiredate), max(e.hiredate), e.deptno
  from emp e
 group by e.deptno

--1
