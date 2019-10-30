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




--插入、修改、删除tb_student信息
insert into tb_student values(100,'0','小零',1,20,'000@163.com','10-10月-1998');
insert into tb_student values(101,'1','小一',0,21,'001@163.com','9-10月-1997');
insert into tb_student values(102,'2','小二',1,23,'002@163.com','11-10月-1996');
insert into tb_student values(103,'3','小三',0,22,'003@163.com','12-10月-1998');
insert into tb_student values(104,'4','小四',1,20,'004@163.com','8-10月-1999');

insert into tb_student values(111,'7','小八',1,20,'008@163.com','10-10月-1998');

update tb_student set ssid = 108 ,ssno = '8' where ssname='小八';

delete from tb_student where ssname = '小八';
delete from tb_student where ssname = '小四';
select * from tb_student


--插入、修改、删除tb_course信息
insert into tb_course values(1,'语文','上语文课啦');
insert into tb_course values(2,'数学','上数学课啦');
insert into tb_course values(3,'英语','上英语课啦');
insert into tb_course values(4,'历史','上历史课啦');

update tb_course set ccname = '政治',ccdescribe = '上政治课啦' where ccname= '历史'
delete from tb_course where ccname = '政治';
select * from tb_course

--插入、修改、删除tb_score信息
select * from tb_score
--学生0的成绩
insert into tb_score values(0,100,1,90);
insert into tb_score values(1,100,2,91);
insert into tb_score values(2,100,3,92);
--学生1的成绩
insert into tb_score values(3,101,1,80);
insert into tb_score values(4,101,2,81);
insert into tb_score values(5,101,3,82);
--学生2的成绩
insert into tb_score values(6,102,1,70);
insert into tb_score values(7,102,2,71);
insert into tb_score values(8,102,3,72);
--学生3的成绩
insert into tb_score values(9,103,1,90);
insert into tb_score values(10,103,2,93);
insert into tb_score values(11,103,3,94);

--2.查询一个学生所有的成绩，（学生名称，学生成绩，科目名称
select tss.ssname,tbc.ccname,tsc.score 
from tb_score tsc , tb_student tss, tb_course tbc
where tss.ssid = tsc.stuid
and tsc.couid = tbc.ccid


--行转列
--1.先将姓名与 科目合成一张表
select tss.ssname, tbc.ccname
  from tb_score tsc, tb_student tss, tb_course tbc
 where tss.ssid = tsc.stuid
   and tsc.couid = tbc.ccid
--2.再转换成视图
create or replace View V$_ZY
as select tss.ssname,tbc.ccname,tsc.score 
from tb_score tsc , tb_student tss, tb_course tbc
where tss.ssid = tsc.stuid
and tsc.couid = tbc.ccid

select * from V$_ZY


--3.然后行转列
    --3.1 将视图结果中的每一列查询成一张表
    --3.2 再将多张表使用某一字段关联起来，将多张表连接成一张表
 select tt1.ssname,tt1.score 语文,tt2.score 数学,tt3.score 英语
 from (select t1.ssname, t1.score
                from (select * from V$_ZY) t1
               where t1.ccname = '语文') tt1
   join (select t1.ssname, t1.score
           from (select * from V$_ZY) t1
          where t1.ccname = '数学') tt2
     on tt1.ssname = tt2.ssname
   join (select t1.ssname, t1.score
           from (select * from V$_ZY) t1
          where t1.ccname = '英语') tt3
     on tt2.ssname = tt3.ssname
     
     
-- 行转列 第二种思路

