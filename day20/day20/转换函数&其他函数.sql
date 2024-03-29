--转换函数：
    --to_number(数值类型的字符):将字符转换为数值
    --to_char(数值或者是日期):将数值或者日期转换为字符
    --to_date(日期格式的字符)：将字符转换为日期
----------------数值和字符的互转-----------------------
--字符转换为数字char---->number
    select to_number('123')+2  from dual
--数字转换字符number--->char
    --指定显示格式:
           --9表示位置占位，例如999,999,999会将数字按照三个一组使用逗号隔开。
           --L表示人民币符号，$表示美元符号
           --0可以进行占位分组，但是如果真实数据位数不足，会使用0进行补位。
            select to_char(12345,'$999,999,999') from dual
            select to_char(12345,'L999,999,999') from dual
            select to_char(12345678,'000,000,000,000.000') from dual
    --查询工资大于2000的员工信息
            --数值和字符之间的转换可以隐式转换。to_number可以省略不写.
            select * from emp where sal>'2000';
             select * from emp where sal>to_number('2000');
---------------日期和字符的互转---------------------------
--一般使用方式：新增数据使用to_date(),查询数据使用to_char()
--字符转换为日期 char--->date
    --使用to_date('要转换的字符',日期格式)函数将字符转换为日期
         --注意1：字符必须符合日期格式
         --注意2:oralce默认的转换格式为日月年，例如'01-1月-2018' oracle认为是一个日期
         --常用日期格式：
               --    yyyy-mm-dd
               --    yyyy/mm/dd
    --查询员工入职日期在82年后的信息
    select * from emp where hiredate >to_date('1982-01-01','yyyy-mm-dd')
    select * from emp where hiredate >to_date('1982/01/01','yyyy/mm/dd')      
    select * from emp where to_char(hiredate,'yyyy-mm-dd') >'1982-01-01'
--日期转换为字符  date--->char
   --使用to_char('要转换的日期',转换格式)
   --注意1：如果不指名转换格式，则使用默认格式，日月年例如:'01-1月-81'
   --常用转换格式：
         -- yyyy-mm-dd
         -- yyyy/mm/dd
         --'yyyy"年"mm"月"dd"日"'
   select to_char(hiredate) from emp--使用默认格式将日期转换为字符
   select to_char(hiredate,'yyyy-mm-dd') from emp--使用指定格式  yyyy-mm-dd
   select to_char(hiredate,'yyyy/mm/dd') from emp--使用指定格式 yyyy/mmm/dd
   select to_char(hiredate,'yyyy"年"mm"月"dd"日"') from emp--使用指定格式 'yyyy"年"mm"月"dd"日"'
----------------------------------------------------------------------------------------------------- 
--其他函数：
   --nvl()：nvl(字段名，新的值)
          --如果字段值不为null，则返回该字段的值。如果为null则返回新的值
   --nvl2()：nvl2(字段名，处理1，处理2)
          --如果字段值不为null，则执行处理1，为null执行处理2
   --decode()：decode(字段名,值1，处理1，值2，处理2，值3，处理3,...,公共处理)
          --如果字段的值和decode中的条件值相同则执行对象的处理。如果都没有则执行公共处理
   ---查询员工的工资信息
   select ename,job,sal from emp
   --查询员工的薪水信息
   select ename,job,sal+nvl(comm,0),sal+comm,sal from emp
   select ename,job,nvl2(comm,sal+comm,sal) from emp
   --显示员工的职称
   select ename,job,decode(job,'MANAGER','经理','PRESIDENT','董事长','SALESMAN','销售','普通员工') from emp
   
   
   
   
   







