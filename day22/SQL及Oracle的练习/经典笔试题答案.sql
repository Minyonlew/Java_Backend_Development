

����������1-----------------------------------------------------------------------------


select t01.value ����, t02.value �Ա�,t03.value ����
  from (select t.t_id, t.value from test t where t.type = '1') t01
  join (select t.t_id, t.value from test t where t.type = '2') t02
    on t01.t_id = t02.t_id
  join (select t.t_id, t.value from test t where t.type = '3') t03
    on t03.t_id = t02.t_id



����������2-----------------------------------------------------------------------------
select tt01.rq,
       sum(decode(tt01.shengfu, 'ʤ', '1')) ʤ,
       sum(decode(tt01.shengfu, '��', '1')) ��
  from tmp tt01
 group by tt01.rq;
 
 
 -- case when ���
select t.rq,
       sum(case
             when t.shengfu = 'ʤ' then
              '1'
           end) ʤ,
       sum(case
             when t.shengfu = 'ʤ' then
              '1'
           end) ��
  from tmp t
 group by t.rq;




���������� 3.1
--------------------------------------------------------------------------------------
select * from STUDENT_SCORE;
-- decode  case when
-- ����  ���ֿ���
select ss01.name, (case
         when ss01.subject = '����' then
          ss01.score
       end) "����",
       (case
         when ss01.subject = '��ѧ' then
          ss01.score
       end) "��ѧ",
       (case
         when ss01.subject = 'Ӣ��' then
          ss01.score
       end) "Ӣ��"
  from student_score ss01;

-- �ϲ� ȡ��null ��
-- case 
-- ����
--�ۺϺ���
select ss01.name, sum(case
         when ss01.subject = '����' then
          ss01.score else 0
       end) "����",
      sum (case
         when ss01.subject = '��ѧ' then
          ss01.score else 0
       end) "��ѧ",
       sum(case
         when ss01.subject = 'Ӣ��' then
          ss01.score else 0
       end) "Ӣ��"
  from student_score ss01 group by ss01.name;




--��ʹ�÷��� �ۺϺ���
 
  99 �﷨
select   ss01.name,
       ss01.score ����,
       ss02.score ��ѧ,
       ss03.score Ӣ��
  from (select ss.name, ss.score
          from student_score ss
         where ss.subject = '����') ss01
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '��ѧ') ss02
    on ss01.name = ss02.name
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = 'Ӣ��') ss03
    on ss02.name = ss03.name
  
  --------------------------------------------------------------------------------------

���������� 3.2
--------------------------------------------------------------------------------------
select tt01.name,
       case
         when tt01.���� >= 80 then
          '����'
         when tt01.���� >= 60 and tt01.���� < 80 then
          '����'
       end "����",
       case
         when tt01.��ѧ >= 80 then
          '����'
         when tt01.��ѧ >= 60 and tt01.��ѧ < 80 then
          '����'
       end "��ѧ",
       case
         when tt01.Ӣ�� >= 80 then
          '����'
         when tt01.Ӣ�� >= 60 and tt01.Ӣ�� < 80 then
          '����'
       end "Ӣ��"
  from ��select   ss01.name,
       ss01.score ����,
       ss02.score ��ѧ,
       ss03.score Ӣ��
  from (select ss.name, ss.score
          from student_score ss
         where ss.subject = '����') ss01
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = '��ѧ') ss02
    on ss01.name = ss02.name
  join (select ss.name, ss.score
          from student_score ss
         where ss.subject = 'Ӣ��') ss03
    on ss02.name = ss03.name��tt01;
    
--------------------------------------------------------------------------------------


���������� 4
--------------------------------------------------------------------------------------
-- ���ű������ѯ
select * from yj01 join yjdept yd on yj01.deptno = yd.deptno;

select yj.deptno,
       sum((case
             when yj.month = 'һ�·�' then
              yj.yj
           end)) һ�·�,
       sum((case
             when yj.month = '���·�' then
              yj.yj
           end)) ���·�,
       sum((case
             when yj.month = '���·�' then
              yj.yj
           end)) ���·�
  from yj01 yj
  join yjdept yd
    on yj.deptno = yd.deptno
 group by yj.deptno

       













