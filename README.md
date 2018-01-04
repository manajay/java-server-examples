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

![tomat](/image/tomcat-01.png)

tomcat 配置

> * tomcat home 路径:  ```/usr/local/Cellar/tomcat@7/7.0.77/libexec``` 
> * tomcat base 路径   ```/usr/local/Cellar/tomcat@7/7.0.77/libexec```

![tomat-config](/image/tomcat-02.png)

`tomcat`注意配置下面的文件, 一般使用`HTTP`默认的`localhost` 端口 `8080`, 不过我之前的`8080`被占用了,所以设置的是`8083`
```
<?xml version='1.0' encoding='utf-8'?>

<Server port="8005" shutdown="SHUTDOWN">
  <Listener className="org.apache.catalina.startup.VersionLoggerListener" />
  <Listener className="org.apache.catalina.security.SecurityListener" />
  <Listener className="org.apache.catalina.core.AprLifecycleListener" SSLEngine="on" />
  <Listener className="org.apache.catalina.core.JasperListener" />
  <Listener className="org.apache.catalina.core.JreMemoryLeakPreventionListener" />
  <Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener" />
  <Listener className="org.apache.catalina.core.ThreadLocalLeakPreventionListener" />

  <GlobalNamingResources>
    <Resource name="UserDatabase" auth="Container"
              type="org.apache.catalina.UserDatabase"
              description="User database that can be updated and saved"
              factory="org.apache.catalina.users.MemoryUserDatabaseFactory"
              pathname="conf/tomcat-users.xml" />
  </GlobalNamingResources>
  
  <Service name="Catalina">
    <Connector port="8083" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
   
    <Connector executor="tomcatThreadPool"
               port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
    
    <Connector port="8443" protocol="org.apache.coyote.http11.Http11Protocol"
               maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
               clientAuth="false" sslProtocol="TLS" />

    <Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />

    <Engine name="Catalina" defaultHost="localhost">

   
      <Cluster className="org.apache.catalina.ha.tcp.SimpleTcpCluster"/>
      <Realm className="org.apache.catalina.realm.LockOutRealm">
        <Realm className="org.apache.catalina.realm.UserDatabaseRealm"
               resourceName="UserDatabase"/>
      </Realm>

      <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log." suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />

      </Host>
    </Engine>
  </Service>
</Server>

```


## 第二章 项目设计和框架搭建

### 2.1 系统功能模块划分

### 2.2 实体类设计和表创建

### 2.3 配置Maven

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


