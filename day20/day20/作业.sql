--1.ѡ����30�е�����Ա��.
  select * from emp where deptno=30
--2.�г����а���Ա(CLERK)����������źͲ��ű��.
select empno,ename,deptno from emp where job='CLERK'

--3.�ҳ�Ӷ�����н���Ա��.
select * from emp where comm>sal
--4.�ҳ�Ӷ�����н���60%��Ա��.
select * from emp where comm > sal* 0.6
--5.�ҳ�����10�����о���(MANAGER)�Ͳ���20�����а���Ա(CLERK)����ϸ����.
select * from emp where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK');
--6.�ҳ�����10�����о���(MANAGER),����20�����а���Ա(CLERK),�Ȳ��Ǿ����ֲ��ǰ���Ա����н����ڻ����2000������Ա������ϸ����.
select * from emp where (job<>'MANAGER' and job<>'CLERK' and sal >= 2000) or(deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK')
--7.�ҳ���ȡӶ���Ա���Ĳ�ͬ����.
select distinct job from emp where comm is not null
--8.�ҳ�����ȡӶ�����ȡ��Ӷ�����100��Ա��.
select * from emp where comm is null or comm<100
--10.�ҳ�����12��ǰ�ܹ͵�Ա��.
select * from emp where hiredate <'01-1��-1982'  order by hiredate
--11.������ĸ��д�ķ�ʽ��ʾ����Ա��������.
--13.��ʾ������"R"��Ա��������.
select * from emp where ename not like '%R%';
--17.��ʾԱ������ϸ����,����������.
select *from emp order by ename
--18.��ʾԱ�����������ܹ�����,�������������,�����ϵ�Ա��������ǰ��.
select ename,hiredate from emp order by hiredate
--19.��ʾ����Ա����������������н��,�������Ľ�������,��������ͬ��н������.
select ename,job,sal from emp  order by job desc,sal desc
--20.��ʾ����Ա�������������빫˾����ݺ��·�,���ܹ���������������,���·���ͬ��������ݵ�Ա��������ǰ��.

--24.��ʾ�����ֶε��κ�λ�ð���"A"������Ա��������.
select ename from emp where ename like '%A%'
