# that's a o2o example

[SSM到Spring Boot 从零开发校园商铺平台](https://coding.imooc.com/learn/list/144.html)

online learning course above!

## 第一章 开发准备

* IntelliJ IDEA 项目开发IDE
* Navicat Premium Mysql客户端
* Mac OS 系统
* tomcat
* chrome 

> 使用 homebrew安装mysql与tomcat ,[参考文章](http://manajay.com/2017/01/homebrew-clean-install/)

`brew list` 查看安装状态 , 如下图
![brew-list](/image/brew-list.png)


### mysql 


```
// 执行 mysql
mysql
会报下面的错
ERROR 2002 (HY000): Can't connect to local MySQL server through socket '/tmp/mysql.sock' (2)
//解决办法: 
mysql.server start
// 然后登录, 注意没有首次root登录,没有密码 
mysql -uroot -p
```
登录后提示如下
```
mysql -uroot -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 5.7.18 Homebrew

Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>
```


### tomcat

#### tomcat安装
* 注意版本 `brew install tomcat` tomcat 7 对应 java的jdk7.0
 
* 检查是否安装成功
`catalina -h`
> 能够正常运行的前提,正确的环境变量, 主要是 `JAVA_HOME` , `PATH` 和`CLASSPATH`

![tomat](/image/tomcat-01.png)

> * tomcat home 路径:  ```/usr/local/Cellar/tomcat@7/7.0.77/libexec``` 
> * tomcat base 路径   ```/usr/local/Cellar/tomcat@7/7.0.77/libexec```

#### 修改tomcat配置

* 配置文件的路径 

`/usr/local/Cellar/tomcat@7/7.0.77/libexec/conf/server.xml`

此路径 `/usr/local/Cellar/tomcat@7` 后面具体是多少,可以`brew`下载后,自己通过文件夹查找

`catalina run`
Tomcat的默认端口是8080，如果运行成功可通过`http://localhost:8080`访问

* 更改端口

`tomcat` 一般使用`HTTP`默认的`localhost` 端口 `8080`, 不过我之前的`8080`被占用了,所以设置的是`8083`

> 首个Connector标签 更改运行端口
```
  <Connector port="8083" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```

#### tomcat 部署配置

![tomat-config](/image/tomcat-02.png)

初始化工程, web的配置 (`web.xml`与欢迎页`index.jsp`和`index.html`)
![tomcat-web-init](/image/tomcat-web-01.jpg)

> war模式：将WEB工程以包的形式上传到服务器, 也称为发布模式

直接用tomcat部署 启动`/bin/startup.sh`,注意首次登录要在`/conf/tomcat-users.xml`中添加管理员权限的角色. 

```
<role rolename="tomcat"/>
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui"/>
 ```

tomcat部署下的文件架构: 
![tomcat-webapp](/image/tomcat-web-02.png)

> war exploded模式：将WEB工程以当前文件夹的位置关系上传到服务, 热部署的开发形式;


## 第二章 项目设计和框架搭建

### 2.1 系统功能模块划分

![系统设计-01](/image/system-design-01.png)

* 前后端分离

### 2.2 实体类设计和表创建

![实体关系图](/image/do-relation.png)

* mysql数据库脚本见 **o2o.sql**


### 2.3 配置Maven

* [idea官方地址](https://link.jianshu.com/?t=https://www.jetbrains.com/idea/download/) 下载`idea`

* 

### 2.4 逐层完成SSM的各项配置

### 2.5 验证Dao

### 2.6 验证Service

### 2.7 验证Controller

## 第三章 Logback日志的配置与使用

### 3.1 logback介绍

### 3.2 logback的配置

### 3.3 验证配置

## 第四章 店铺注册功能模块

### 4.1 Dao层-新增店铺

### 4.2 Dao层-更新店铺

### 4.3 Thumbnailator 图片处理和封装Util

### 4.4 DTO-ShopExecution的实现

### 4.5 店铺注册-Service功能的实现

### 4.6 店铺注册-Controller的实现

### 4.7 店铺注册-Controller的改造

### 4.8 店铺注册-前端设计

### 4.9 店铺注册-js实现

### 4.10 店铺类别区域信息的获取

### 4.11 引入kaptcha实现验证码

### 前后端联调验证整体模块功能


