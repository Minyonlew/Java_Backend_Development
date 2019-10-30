----分组查询&筛选学习：
     --关键字：group by 分组字段名,分组字段名....
         --注意1：使用了分组后，在select语句中只允许出现分组字段和多行函数。
         --注意2：如果是多字段分组，则先按照第一字段分组，然后每个小组继续按照第二个字段继续分组，以此类推。
         --注意3：在where子句中不允许出现多行函数。
     --分组筛选
         --关键字：having
              --作用：针对分组进行分组后的数据筛选，允许使用多行函数。
              --注意：having关键必须和分组结合使用。不允许单独使用。   
              --where和having的比较：
                 --where子句不允许出现多行函数，having允许出现多行函数
                 --where子句和having都可以使用普通字段直接进行筛选，但是where的效率高于having
                    --where执行顺序: from--->where--->group by-->select-->order by
                    --having执行顺序:from--->group by-->select--->having--->order by
               --结论：在分组语句中，使用where进行字段级别的筛选，使用having进行多行函数的筛选。    
      --查询最高工资和员工数
      select max(sal),count(*) from emp
      --查询不同部门的最高工资
      select deptno,max(sal) from emp group by deptno
      select * from emp
      --查询不同工作岗位的员工数
      select job, count(*) from emp group by job
      --查询不同部门的不同工作岗位的人数
      select deptno ,lower(job),count(*) from emp group by deptno,job order by deptno
      --查询不同部门的不同工作岗位的并且人数大于1的信息
      select deptno ,lower(job),count(*) from emp  group by deptno,job having count(*)>1 order by deptno
      --查询部门号大于10的不同部门的不同工作岗位的人数
          --使用having关键字
          select deptno ,lower(job),count(*) from emp group by deptno,job  having deptno>10  order by deptno
          --使用where关键字
          select deptno,job,count(*) from emp where deptno>10 group by deptno,job  order by deptno
---SQL查询语句的结构
        --select 子句                  要查询的数据(oracle函数，别名，连接符，去除重复，逻辑运算)
        --from语句                     决定要查询的表(表名)             
        --where子句                    筛选数据（筛选条件，关键字）
        --group by子句                 分组     （分组字段）
        --having子句                   分组筛选   (多行函数筛选条件)
        --order by子句                 排序       （排序）
        --from-->where--->group by-->select--->having--->order by
        
        
        
        
        
      
