------��ֵ�ͺ���

--1.����ֵ
select abs(100),abs(-100),abs(0) from dual
--2.����ֵ
select sign(100),sign(-100) from dual
--3.���ش��ڵ���x����С����ֵ
select ceil(3.1),ceil(2.8+1.3) from dual
--4.���ش��ڵ���x���������ֵ
select floor(3.1),floor(2.8+1.3),floor(0) from dual;
--5.����x��y����
select power(3,2) from dual
--6.����x����y������
select mod(3,2) from dual
--7.��������������ֵ
select round(4.4),round(0.1) from dual


------�ַ��ͺ���
--1.�����ַ���ASCII��
select ASCII('a') from dual
--2.���������ַ�����concat
select concat('����',(concat('һ��','����'))) from dual
--3.��ÿ����������ĸ��Ϊ��д
select nls_initcap('ab cd'),nls_initcap('a c d b') from dual
--4.�������ַ���ת��Ϊ��д/Сд
select lower('A'),upper('b') from dual
--5.��һ���ַ���������ָ�����ַ�,���ط���ָ�����ַ���λ��;���ֽڷ�(���֡�ȫ�Ƿ���)����2���ַ�����
select instr('����ĳ�����˾','ĳ',1,1),instrb('����ĳ�����˾','ĳ',1,1) instring from dual; --���أ�3,5
--6.����ߡ��ұ�����ַ�
select lpad('hi',5,'*'),rpad('hi',5,'*') from dual;  -- 5��ָ����֮���ַ������ܳ���
--7.ɾ�����������ַ����Ŀո�
select ltrim('  aa'),rtrim('bb   ') from dual
--8.�滻�ַ���
select replace('he love you','he','i') test from dual;
--9.��ȡ�ַ���
select substr('���ֻ�13012345678',4,11),substrb('���ֻ�13012345678',4,11),substrb('���ֻ�13012345678',3,11) test from dual;
--����:13012345678, ��13012345,�ֻ�1301234


------���ں���
--1.����ϵͳ��ǰ����
select sysdate  hz from dual
--2.����ָ�������������
select add_months(sysdate,5) from dual
--3.���ر������һ�������
select last_day(sysdate) from dual;
--4.����2������ʱ������
select months_between(sysdate,to_date('2016-01-01','YYYY-MM-DD')) from dual;  --����45.7968
--5.�����������ڼ��һ��
select sysdate ��ʱ����,
round(sysdate) ���0������,
round(sysdate,'day') ���������,
round(sysdate,'month') ����³�,
round(sysdate,'q') �����������, 
round(sysdate,'year') ���������� from dual;

--6.�������������ڼ�ĵ�һ��
select sysdate ��ʱ����,
trunc(sysdate) ��������,
trunc(sysdate,'day') ����������,
trunc(sysdate,'month') ���³�,
trunc(sysdate,'q') ����������, 
trunc(sysdate,'year') ��������� from dual;








