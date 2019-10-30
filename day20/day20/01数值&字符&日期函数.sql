------数值型函数

--1.绝对值
select abs(100),abs(-100),abs(0) from dual
--2.正负值
select sign(100),sign(-100) from dual
--3.返回大于等于x的最小整数值
select ceil(3.1),ceil(2.8+1.3) from dual
--4.返回大于等于x的最大整数值
select floor(3.1),floor(2.8+1.3),floor(0) from dual;
--5.返回x的y次幂
select power(3,2) from dual
--6.返回x除以y的余数
select mod(3,2) from dual
--7.返回四舍五入后的值
select round(4.4),round(0.1) from dual


------字符型函数
--1.返回字符的ASCII码
select ASCII('a') from dual
--2.连接两个字符串，concat
select concat('我是',(concat('一个','好人'))) from dual
--3.吧每个单词首字母变为大写
select nls_initcap('ab cd'),nls_initcap('a c d b') from dual
--4.将整个字符串转换为大写/小写
select lower('A'),upper('b') from dual
--5.在一个字符串中搜索指定的字符,返回发现指定的字符的位置;多字节符(汉字、全角符等)，按2个字符计算
select instr('重庆某软件公司','某',1,1),instrb('重庆某软件公司','某',1,1) instring from dual; --返回：3,5
--6.在左边、右边添加字符
select lpad('hi',5,'*'),rpad('hi',5,'*') from dual;  -- 5是指加完之后字符串的总长度
--7.删除左、右两边字符串的空格
select ltrim('  aa'),rtrim('bb   ') from dual
--8.替换字符串
select replace('he love you','he','i') test from dual;
--9.截取字符串
select substr('我手机13012345678',4,11),substrb('我手机13012345678',4,11),substrb('我手机13012345678',3,11) test from dual;
--返回:13012345678, 机13012345,手机1301234


------日期函数
--1.返回系统当前日期
select sysdate  hz from dual
--2.返回指定月数后的日期
select add_months(sysdate,5) from dual
--3.返回本月最后一天的日期
select last_day(sysdate) from dual;
--4.返回2个日期时隔月数
select months_between(sysdate,to_date('2016-01-01','YYYY-MM-DD')) from dual;  --返回45.7968
--5.四舍五入后的期间第一天
select sysdate 当时日期,
round(sysdate) 最近0点日期,
round(sysdate,'day') 最近星期日,
round(sysdate,'month') 最近月初,
round(sysdate,'q') 最近季初日期, 
round(sysdate,'year') 最近年初日期 from dual;

--6.返回日期所在期间的第一天
select sysdate 当时日期,
trunc(sysdate) 今天日期,
trunc(sysdate,'day') 本周星期日,
trunc(sysdate,'month') 本月初,
trunc(sysdate,'q') 本季初日期, 
trunc(sysdate,'year') 本年初日期 from dual;








