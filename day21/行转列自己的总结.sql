
----------2---------------------------
create table tmp(rq varchar2(10),shengfu varchar2(5))

insert into tmp values('2005-05-09','ʤ');
insert into tmp values('2005-05-09','ʤ');  
insert into tmp values('2005-05-09','��');
insert into tmp values('2005-05-09','��');
insert into tmp values('2005-05-10','ʤ');
insert into tmp values('2005-05-10','��');
insert into tmp values('2005-05-10','��');

select * from tmp

select rq��sum(decode(shengfu,'ʤ',1,0)) ʤ��sum(decode(shengfu,'��',1,0)) ��
from tmp t
group by rq


-------------3.1--------------------------

create table STUDENT_SCORE
(
  name    VARCHAR2(20),
  subject VARCHAR2(20),
  score   NUMBER(4,1)
)

insert into student_score (NAME, SUBJECT, SCORE) values ('����', '����', 78.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', '��ѧ', 88.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', 'Ӣ��', 98.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', '����', 89.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', '��ѧ', 76.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', 'Ӣ��', 90.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', '����', 99.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', '��ѧ', 66.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('����', 'Ӣ��', 91.0);

select * from student_score

--���麯��

select ss.name,max(decode(ss.subject,'����',ss.score,0)) ����,
               max(decode(ss.subject,'��ѧ',ss.score,0)) ��ѧ,
               max(decode(ss.subject,'Ӣ��',ss.score,0)) Ӣ��
from student_score ss
group by ss.name

--����ѯ
  --�ȷֿ�����������Ϊ���Ҫ����ʾ���ֶ��� ���ֺͷ��������Ծ������ǵ����±���ֶΣ����ֶΣ����� ����������Ϊ���ġ���ѧ��Ӣ�
  --��ͨ��name�ֶν���������
  select t1.name,t1.score ����,t2.score ��ѧ,t3.score Ӣ��
  from 
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '����') t1
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '��ѧ') t2
  on t1.name = t2.name
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = 'Ӣ��') t3
  on t2.name  = t3.name
  
  
 -------------3.2--------------------------   

select tt1.name,
case
  when tt1.���� < 60 then '������'
  when tt1.���� >= 60 and tt1.���� <80 then '����'
  when tt1.����>=80 then '����'
    end ���ģ�
case
  when tt1.��ѧ < 60 then '������'
  when tt1.��ѧ >= 60 and tt1.��ѧ <80 then '����'
  when tt1.��ѧ>=80 then '����'
    end ��ѧ��    
case
  when tt1.Ӣ�� < 60 then '������'
  when tt1.Ӣ�� >= 60 and tt1.Ӣ�� <80 then '����'
  when tt1.Ӣ��>=80 then '����'
    end Ӣ��
from(
select t1.name,t1.score ����,t2.score ��ѧ,t3.score Ӣ��
  from 
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '����') t1
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '��ѧ') t2
  on t1.name = t2.name
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = 'Ӣ��') t3
  on t2.name  = t3.name) tt1

---------------4.--------------------
create table yj01(
       month varchar2(10),
       deptno number(10),
       yj number(10)
);

insert into yj01(month,deptno,yj) values('һ�·�',01,10);
insert into yj01(month,deptno,yj) values('���·�',02,10);
insert into yj01(month,deptno,yj) values('���·�',03,5);
insert into yj01(month,deptno,yj) values('���·�',02,8);
insert into yj01(month,deptno,yj) values('���·�',04,9);
insert into yj01(month,deptno,yj) values('���·�',03,8);

create table yjdept(
       deptno number(10),
       dname varchar2(20)
)

insert into yjdept(deptno,dname) values(01,'����ҵ��һ��');
insert into yjdept(deptno,dname) values(02,'����ҵ�����');
insert into yjdept(deptno,dname) values(03,'����ҵ������');
insert into yjdept(deptno,dname) values(04,'����ҵ��');

select * from yj01

-- ������ֶ� ���ź� �·ݵ�ҵ��
--����ѯ

select yd.deptno, t01.yj һ�·�, t02.yj ���·�, t03.yj ���·�
  from yjdept yd
  left outer join (select yj.deptno, yj.yj
                     from yj01 yj
                    where yj.month = 'һ�·�') t01
    on yd.deptno = t01.deptno
  left outer join (select yj.deptno, yj.yj
                     from yj01 yj
                    where yj.month = '���·�') t02
    on yd.deptno = t02.deptno
  left outer join (select yj.deptno, yj.yj
                     from yj01 yj
                    where yj.month = '���·�') t03
    on yd.deptno = t03.deptno
    order by yd.deptno








