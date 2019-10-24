# Java Development



## Day 19 Oracle

[TOC]



### 1. Oracle 安装



#### 1.1 安装

> 参考 `PPT`。



#### 1.2 账户

- **初次登录**

> 通过`PL/SQL`图像界面登录 
>
> 1. 账户：`sys`
> 2. 密码：`123`
> 3.  数据库：`ORCL`
> 4. 连接为：`SYSDBA`

- **解锁**

> 1. 创建一个`SQL窗口`  
>
> 2. 输入语句：
>
>    ```sql
>    alter user scott account unlock;  //解锁scott用户
>    ```

- **重新登录`scott`账户**

> 通过`PL/SQL`图像界面登录 
>
> 1. 账户：`scott`
> 2. 密码：`tiger`
> 3.  数据库：`ORCL`
> 4. 连接为：`NOMAL`
> 5. 重新修改密码：`123`

- **测试**

> ``` sql
> select * from emp;
> ```