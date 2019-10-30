
----------2---------------------------
create table tmp(rq varchar2(10),shengfu varchar2(5))

insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','胜');  
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-10','胜');
insert into tmp values('2005-05-10','负');
insert into tmp values('2005-05-10','负');

select * from tmp

select rq，sum(decode(shengfu,'胜',1,0)) 胜，sum(decode(shengfu,'负',1,0)) 负
from tmp t
group by rq


-------------3.1--------------------------

create table STUDENT_SCORE
(
  name    VARCHAR2(20),
  subject VARCHAR2(20),
  score   NUMBER(4,1)
)

insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '语文', 78.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '数学', 88.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '英语', 98.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '语文', 89.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '数学', 76.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '英语', 90.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '语文', 99.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '数学', 66.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '英语', 91.0);

select * from student_score

--用组函数

select ss.name,max(decode(ss.subject,'语文',ss.score,0)) 语文,
               max(decode(ss.subject,'数学',ss.score,0)) 数学,
               max(decode(ss.subject,'英语',ss.score,0)) 英语
from student_score ss
group by ss.name

--多表查询
  --先分开几个表，（因为最后要求显示的字段是 名字和分数，所以就让他们当作新表的字段），字段：姓名 分数（改名为语文、数学、英语）
  --再通过name字段将各表连接
  select t1.name,t1.score 语文,t2.score 数学,t3.score 英语
  from 
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '语文') t1
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '数学') t2
  on t1.name = t2.name
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '英语') t3
  on t2.name  = t3.name
  
  
 -------------3.2--------------------------   

select tt1.name,
case
  when tt1.语文 < 60 then '不及格'
  when tt1.语文 >= 60 and tt1.语文 <80 then '及格'
  when tt1.语文>=80 then '优秀'
    end 语文，
case
  when tt1.数学 < 60 then '不及格'
  when tt1.数学 >= 60 and tt1.数学 <80 then '及格'
  when tt1.数学>=80 then '优秀'
    end 数学，    
case
  when tt1.英语 < 60 then '不及格'
  when tt1.英语 >= 60 and tt1.英语 <80 then '及格'
  when tt1.英语>=80 then '优秀'
    end 英语
from(
select t1.name,t1.score 语文,t2.score 数学,t3.score 英语
  from 
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '语文') t1
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '数学') t2
  on t1.name = t2.name
  join
  (select ss.name,ss.score
  from student_score ss
  where ss.subject = '英语') t3
  on t2.name  = t3.name) tt1

---------------4.--------------------
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

select * from yj01

-- 输出的字段 部门号 月份的业绩
--多表查询

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








