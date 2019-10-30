

经典面试题1-----------------------------------------------------------------------------


select t01.value 姓名, t02.value 性别,t03.value 年龄
  from (select t.t_id, t.value from test t where t.type = '1') t01
  join (select t.t_id, t.value from test t where t.type = '2') t02
    on t01.t_id = t02.t_id
  join (select t.t_id, t.value from test t where t.type = '3') t03
    on t03.t_id = t02.t_id



经典面试题2-----------------------------------------------------------------------------
select tt01.rq,
       sum(decode(tt01.shengfu, '胜', '1')) 胜,
       sum(decode(tt01.shengfu, '负', '1')) 负
  from tmp tt01
 group by tt01.rq;
 
 
 -- case when 解决
select t.rq,
       sum(case
             when t.shengfu = '胜' then
              '1'
           end) 胜,
       sum(case
             when t.shengfu = '胜' then
              '1'
           end) 负
  from tmp t
 group by t.rq;




经典面试题 3.1
--------------------------------------------------------------------------------------
select * from STUDENT_SCORE;
-- decode  case when
-- 问题  出现空列
select ss01.name, (case
         when ss01.subject = '语文' then
          ss01.score
       end) "语文",
       (case
         when ss01.subject = '数学' then
          ss01.score
       end) "数学",
       (case
         when ss01.subject = '英语' then
          ss01.score
       end) "英语"
  from student_score ss01;

-- 合并 取出null 列
-- case 
-- 分组
--聚合函数
select ss01.name, sum(case
         when ss01.subject = '语文' then
          ss01.score else 0
       end) "语文",
      sum (case
         when ss01.subject = '数学' then
          ss01.score else 0
       end) "数学",
       sum(case
         when ss01.subject = '英语' then
          ss01.score else 0
       end) "英语"
  from student_score ss01 group by ss01.name;




--不使用分组 聚合函数
 
  99 语法
select   ss01.name,
       ss01.score 语文,
       ss02.score 数学,
       ss03.score 英语
  from (select ss.name, ss.score
          from student_score ss
         where ss.subject = '语文') ss01
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '数学') ss02
    on ss01.name = ss02.name
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '英语') ss03
    on ss02.name = ss03.name
  
  --------------------------------------------------------------------------------------

经典面试题 3.2
--------------------------------------------------------------------------------------
select tt01.name,
       case
         when tt01.语文 >= 80 then
          '优秀'
         when tt01.语文 >= 60 and tt01.语文 < 80 then
          '及格'
       end "语文",
       case
         when tt01.数学 >= 80 then
          '优秀'
         when tt01.数学 >= 60 and tt01.数学 < 80 then
          '及格'
       end "数学",
       case
         when tt01.英语 >= 80 then
          '优秀'
         when tt01.英语 >= 60 and tt01.英语 < 80 then
          '及格'
       end "英语"
  from （select   ss01.name,
       ss01.score 语文,
       ss02.score 数学,
       ss03.score 英语
  from (select ss.name, ss.score
          from student_score ss
         where ss.subject = '语文') ss01
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '数学') ss02
    on ss01.name = ss02.name
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '英语') ss03
    on ss02.name = ss03.name）tt01;
    
--------------------------------------------------------------------------------------


经典面试题 4
--------------------------------------------------------------------------------------
-- 两张表关联查询
select * from yj01 join yjdept yd on yj01.deptno = yd.deptno;

select yj.deptno,
       sum((case
             when yj.month = '一月份' then
              yj.yj
           end)) 一月份,
       sum((case
             when yj.month = '二月份' then
              yj.yj
           end)) 二月份,
       sum((case
             when yj.month = '三月份' then
              yj.yj
           end)) 三月份
  from yj01 yj
  join yjdept yd
    on yj.deptno = yd.deptno
 group by yj.deptno

       













