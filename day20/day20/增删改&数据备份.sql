--数据库的增删改&数据备份
    --注意：增加删除修改的数据SQL语句执行完毕后，不会立马进行数据的写入。
           --还需要手动对数据进行提交，如果数据有问题还可以回滚
    --主键：非空唯一的字段可以设置为主键。
          --在一张表中，某个字段的值是非空唯一的，将此字段设置为主键。
          --主键的作用：唯一的标识一条数据。
  --增加数据
      --insert into 表名(字段名，字段名，...)values(值1，值2，值3....);
          --注意1：主键必须给值，允许为空的字段可以不给值。
          --注意2：插入语句表名后跟的字段名为要赋值的字段，值和字段数量和顺序必须是一一对应的。
          --注意3：如果是全字段插入，可以省略字段名部分 insert into 表名 values(值1，值2，.....)
      --在部门中新增一个新的部门信息，信息内容为 编号：50，名称：LOL学院,地址：北京
         insert into dept(deptno,dname,loc)values(50,'LOL学院','北京');
         insert into dept(deptno,dname,loc)values(60,'LOL学院','北京');
         insert into dept values(60,'LOL学院','北京');
         select * from dept
      --在部门中新增一条数据，只有部门编号和名称，没有地址。
         insert into dept(deptno,dname)values('吃鸡学院',70)
  --删除数据
       --delete from 表名 删除表中的所有记录
           --truncate table 表名  删除表中的所有记录，但是效率高于delete
       --delete from 表名 where 条件 删除指定的数据,只要符合条件就会删除
       delete from dept where deptno=50 --删除指定的数据
       delete from dept --清空表数据
       truncate table dept--清空表中数据
  --更新数据
       --update 表名 set 字段名=新的值,字段名=新的值...(会将字段的值全部改为新的值)
       --update 表名 set 字段名=新的值,字段名=新的值... where 条件(将符合条件的数据的字段改为新的值)
       update dept set dname='java学院',loc='上海'
       update dept set dname='java学院',loc='上海' where deptno=50
       select * from dept
  --数据的备份
       --注意：只会备份表结构和表的数据，约束不会备份。
       --表级别备份
           --全部备份:create table 新的表名 as select * from 备份表名
           --部分备份: create table 新的表名 as select 字段名，字段名，...from  备份表名
       --数据整体插入
           --insert into 插入表名 select * from 表名
           --注意:查询语句结果的字段数据必须和插入表名的字段数量一致，类型要一致。
       create table deptBak as select * from dept--全部备份
       create table deptBak2 as select deptno,dname from dept-- 部分备份
       select * from deptBak2
       insert into deptBak2 select deptno,dname from dept
      
       
       
       
       
       
       
       
       
