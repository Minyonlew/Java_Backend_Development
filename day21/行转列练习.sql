--1 中国移动sql面试题：
/*create table test(
   id number(10) primary key,
   type number(10) ,
   t_id number(10),
   value varchar2(5)
);
insert into test values(100,1,1,'张三');
insert into test values(200,2,1,'男');
insert into test values(300,3,1,'50');

insert into test values(101,1,2,'刘二');
insert into test values(201,2,2,'男');
insert into test values(301,3,2,'30');

insert into test values(102,1,3,'刘三');
insert into test values(202,2,3,'女');
insert into test values(302,3,3,'10');*/
/**请写出一条查询语句结果如下：

姓名      性别     年龄
--------- -------- ----
张三       男        50
*/
select * from TEST t

-- 行转列   第一种思路
-- 就是讲结果中的每一列查询成一张表
-- 再将多张表使用某一字段关联起来，将多张表连接成一张表
select t01.t_id, t01.value 姓名, t02.value 性别, t03.value 年龄
  from (select t.t_id, t.value from test t where t.type = 1) t01,
       (select t.t_id, t.value from test t where t.type = 2) t02,
       (select t.t_id, t.value from test t where t.type = 3) t03
 where t01.t_id = t02.t_id
   and t02.t_id = t03.t_id
   
-- 行转列   第二种思路
select max(decode(t.type, 1, value, 0)) 姓名,
       max(decode(t.type, 2, value, 0)) 性别,
       max(decode(t.type, 3, value, 0)) 年龄
  from test t
 group by t.t_id
 
 
 
/* 2.一道SQL语句面试题，关于group by
表内容：
2005-05-09 胜
2005-05-09 胜
2005-05-09 负
2005-05-09 负
2005-05-10 胜
2005-05-10 负
2005-05-10 负

如果要生成下列结果, 该如何写sql语句?

          胜 负
2005-05-09 2 2
2005-05-10 1 2
------------------------------------------
create table tmp(rq varchar2(10),shengfu varchar2(5));

insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-10','胜');
insert into tmp values('2005-05-10','负');
insert into tmp values('2005-05-10','负');
*/
 select t.rq,
        sum(decode(t.shengfu, '胜', 1, 0)) 胜， sum(decode(t.shengfu, '负' ，1, 0)) 负
   from tmp t
  group by t.rq
   

/*
create table STUDENT_SCORE
(
  name    VARCHAR2(20),
  subject VARCHAR2(20),
  score   NUMBER(4,1)
);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '语文', 78.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '数学', 88.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '英语', 98.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '语文', 89.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '数学', 76.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '英语', 90.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '语文', 99.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '数学', 66.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '英语', 91.0);


3.1得到类似下面的结果
姓名   语文  数学  英语

王五    89    56    89

*/
select * from student_score

-- 多表关联查询实现行转列
select t01.name, t01.score 语文, t02.score 数学, t03.score 英语
  from (select ss.name, ss.score
          from student_score ss
         where ss.subject = '语文') t01
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '数学') t02
    on t01.name = t02.name
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '英语') t03
    on t02.name = t03.name
    
-- 使用组函数实现行转列
select ss.name, max(decode(ss.subject, '语文', ss.score, 0)) 语文,
       max(decode(ss.subject, '数学', ss.score, 0)) 数学,
       max(decode(ss.subject, '英语', ss.score, 0)) 英语
  from student_score ss
 group by ss.name


/*
3.2有一张表，里面有3个字段：语文，数学，英语。其中有3条记录分别表示语文70分，
   数学80分，英语58分，请用一条sql语句查询出这三条记录并按以下条件显示出来（并写出您的思路）：  
   大于或等于80表示优秀，大于或等于60表示及格，小于60分表示不及格。  
       显示格式：  
       语文              数学                英语  
       及格              优秀                不及格    
*/

select tt01.name, case
         when tt01.语文 < 60 then
          '不及格'
         when tt01.语文 >= 60 and tt01.语文 < 80 then
          '及格'
         when tt01.语文 >= 80 then
          '优秀'
       end 语文,
       case
         when tt01.数学 < 60 then
          '不及格'
         when tt01.数学 >= 60 and tt01.数学 < 80 then
          '及格'
         when tt01.数学 >= 80 then
          '优秀'
       end 数学,
       case
         when tt01.英语 < 60 then
          '不及格'
         when tt01.英语 >= 60 and tt01.英语 < 80 then
          '及格'
         when tt01.英语 >= 80 then
          '优秀'
       end 英语
  from (select t01.name, t01.score 语文, t02.score 数学, t03.score 英语
          from (select ss.name, ss.score
                  from student_score ss
                 where ss.subject = '语文') t01
          join (select ss.name, ss.score
                 from student_score ss
                where ss.subject = '数学') t02
            on t01.name = t02.name
          join (select ss.name, ss.score
                 from student_score ss
                where ss.subject = '英语') t03
            on t02.name = t03.name) tt01




select tt01.name,
       case
         when tt01.语文 < 60 then
          '不及格'
         when tt01.语文 >= 60 and tt01.语文 < 80 then
          '及格'
         when tt01.语文 >= 80 then
          '优秀'
       end 语文,
       case
         when tt01.数学 < 60 then
          '不及格'
         when tt01.数学 >= 60 and tt01.数学 < 80 then
          '及格'
         when tt01.数学 >= 80 then
          '优秀'
       end 数学,
       case
         when tt01.英语 < 60 then
          '不及格'
         when tt01.英语 >= 60 and tt01.英语 < 80 then
          '及格'
         when tt01.英语 >= 80 then
          '优秀'
       end 英语
  from (select ss.name,
               max(decode(ss.subject, '语文', ss.score, 0)) 语文,
               max(decode(ss.subject, '数学', ss.score, 0)) 数学,
               max(decode(ss.subject, '英语', ss.score, 0)) 英语
          from student_score ss
         group by ss.name) tt01






/*
4.请用一个sql语句得出结果
从table1,table2中取出如table3所列格式数据，注意提供的数据及结果不准确，
只是作为一个格式向大家请教。
 

table1

月份mon 部门dep 业绩yj
-------------------------------
一月份      01      10
一月份      02      10
一月份      03      5
二月份      02      8
二月份      04      9
三月份      03      8

table2

部门dep      部门名称dname
--------------------------------
      01      国内业务一部
      02      国内业务二部
      03      国内业务三部
      04      国际业务部

table3 （result）

部门dep 一月份      二月份      三月份
--------------------------------------
      01      10        null      null
      02      10         8        null
      03      null       5        8
      04      null      null      9

------------------------------------------

create table yj01(
       month varchar2(10),
       deptno number(10),
       yj number(10)
);

insert into yj01(month,deptno,yj) values('一月份',01,10);
insert into yj01(month,deptno,yj) values('二月份',02,10);
insert into yj01(month,deptno,yj) values('二月份',03,5);
insert into yj01(month,deptno,yj) values('三月份',02,8);
insert into yj01(month,deptno,yj) values('三月份',04,9);
insert into yj01(month,deptno,yj) values('三月份',03,8);

create table yjdept(
       deptno number(10),
       dname varchar2(20)
)

insert into yjdept(deptno,dname) values(01,'国内业务一部');
insert into yjdept(deptno,dname) values(02,'国内业务二部');
insert into yjdept(deptno,dname) values(03,'国内业务三部');
insert into yjdept(deptno,dname) values(04,'国际业务部');


table3 （result）

部门dep     一月份      二月份      三月份
--------------------------------------
      01      10        null      null
      02      10         8        null
      03      null       5        8
      04      null      null      9
      
      
*/

-- [1]将部门每个月的业绩查询成一张表

select yd.deptno, t01.yj 一月份, t02.yj 二月份, t03.yj 三月份
  from yjdept yd
  left outer join (select yj.deptno, yj.yj
                     from yj01 yj
                    where yj.month = '一月份') t01
    on yd.deptno = t01.deptno
  left outer join (select yj.deptno, yj.yj
                     from yj01 yj
                    where yj.month = '二月份') t02
    on yd.deptno = t02.deptno
  left outer join (select yj.deptno, yj.yj
                     from yj01 yj
                    where yj.month = '三月份') t03
    on yd.deptno = t03.deptno
    order by yd.deptno
