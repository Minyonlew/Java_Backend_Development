/**
������ϰ  PPT ��21ҳ
 1����ѯ82��Ա��
  2����ѯ32�깤�����Ա
  3����ʾԱ����Ӷ�� 6 ���º���һ������һ������
  
  4��Ϊ�����˳����ʣ���׼�ǣ�10���ų�10%��20���ų�15%��30���ų�20%�������ų�18%
*/
--1
select e.* from emp e  where to_char(e.hiredate,'yyyy')='1982'
select e.* from emp e  where to_char(e.hiredate,'yy') like '82';
--2
select  (sysdate-e.hiredate)/365 "time" from emp e where floor((sysdate-e.hiredate)/365)=35
--3
--��ȡ6�����Ժ������
select add_months(e.hiredate,6) ,e.ename,e.hiredate from emp e;
--��ȡ��ְ���6���µ���һ������һ
select next_day(add_months(e.hiredate,6),'����һ') ,e.ename,e.hiredate from emp e;
--��ȡ��һ��������  һ  �� 
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
