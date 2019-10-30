create table tb_student(
       ssid number(3) primary key ,
       ssno varchar2(10) unique,
       ssname varchar2(10),
       ssgender number(1) default(1),check(ssgender = 1 or ssgender = 0),
       ssage  number(3) default(18),
       ssemail varchar2(20) unique,
       ssattendtime date 
     )
     
create table tb_course(
       ccid number(3) primary key,
       ccname varchar2(10) unique ,
       ccdescribe varchar2(200) 
)

drop table tb_score
 
create table tb_score( 
       scid number(3) primary key,
       stuid number(3) ,
       couid number(3) ,
       score number(5,2) default(0)
   
)

alter table tb_score add constraint FK_B foreign key (stuid) references tb_student(ssid)

alter table tb_score add constraint FK_C foreign key (couid) references tb_course(ccid)




--���롢�޸ġ�ɾ��tb_student��Ϣ
insert into tb_student values(100,'0','С��',1,20,'000@163.com','10-10��-1998');
insert into tb_student values(101,'1','Сһ',0,21,'001@163.com','9-10��-1997');
insert into tb_student values(102,'2','С��',1,23,'002@163.com','11-10��-1996');
insert into tb_student values(103,'3','С��',0,22,'003@163.com','12-10��-1998');
insert into tb_student values(104,'4','С��',1,20,'004@163.com','8-10��-1999');

insert into tb_student values(111,'7','С��',1,20,'008@163.com','10-10��-1998');

update tb_student set ssid = 108 ,ssno = '8' where ssname='С��';

delete from tb_student where ssname = 'С��';
delete from tb_student where ssname = 'С��';
select * from tb_student


--���롢�޸ġ�ɾ��tb_course��Ϣ
insert into tb_course values(1,'����','�����Ŀ���');
insert into tb_course values(2,'��ѧ','����ѧ����');
insert into tb_course values(3,'Ӣ��','��Ӣ�����');
insert into tb_course values(4,'��ʷ','����ʷ����');

update tb_course set ccname = '����',ccdescribe = '�����ο���' where ccname= '��ʷ'
delete from tb_course where ccname = '����';
select * from tb_course

--���롢�޸ġ�ɾ��tb_score��Ϣ
select * from tb_score
--ѧ��0�ĳɼ�
insert into tb_score values(0,100,1,90);
insert into tb_score values(1,100,2,91);
insert into tb_score values(2,100,3,92);
--ѧ��1�ĳɼ�
insert into tb_score values(3,101,1,80);
insert into tb_score values(4,101,2,81);
insert into tb_score values(5,101,3,82);
--ѧ��2�ĳɼ�
insert into tb_score values(6,102,1,70);
insert into tb_score values(7,102,2,71);
insert into tb_score values(8,102,3,72);
--ѧ��3�ĳɼ�
insert into tb_score values(9,103,1,90);
insert into tb_score values(10,103,2,93);
insert into tb_score values(11,103,3,94);

--2.��ѯһ��ѧ�����еĳɼ�����ѧ�����ƣ�ѧ���ɼ�����Ŀ����
select tss.ssname,tbc.ccname,tsc.score 
from tb_score tsc , tb_student tss, tb_course tbc
where tss.ssid = tsc.stuid
and tsc.couid = tbc.ccid


--��ת��
--1.�Ƚ������� ��Ŀ�ϳ�һ�ű�
select tss.ssname, tbc.ccname
  from tb_score tsc, tb_student tss, tb_course tbc
 where tss.ssid = tsc.stuid
   and tsc.couid = tbc.ccid
--2.��ת������ͼ
create or replace View V$_ZY
as select tss.ssname,tbc.ccname,tsc.score 
from tb_score tsc , tb_student tss, tb_course tbc
where tss.ssid = tsc.stuid
and tsc.couid = tbc.ccid

select * from V$_ZY


--3.Ȼ����ת��
    --3.1 ����ͼ����е�ÿһ�в�ѯ��һ�ű�
    --3.2 �ٽ����ű�ʹ��ĳһ�ֶι��������������ű����ӳ�һ�ű�
 select tt1.ssname,tt1.score ����,tt2.score ��ѧ,tt3.score Ӣ��
 from (select t1.ssname, t1.score
                from (select * from V$_ZY) t1
               where t1.ccname = '����') tt1
   join (select t1.ssname, t1.score
           from (select * from V$_ZY) t1
          where t1.ccname = '��ѧ') tt2
     on tt1.ssname = tt2.ssname
   join (select t1.ssname, t1.score
           from (select * from V$_ZY) t1
          where t1.ccname = 'Ӣ��') tt3
     on tt2.ssname = tt3.ssname
     
     
-- ��ת�� �ڶ���˼·

