# that's a o2o example

[SSM到Spring Boot 从零开发校园商铺平台](https://coding.imooc.com/learn/list/144.html)

online learning course above!

## 第一章 开发准备

* IntelliJ IDEA 项目开发IDE
* Navicat Premium Mysql客户端
* Mac OS 系统
* tomcat
* chrome 

> * 使用 homebrew安装mysql与tomcat 
> * [homebrew参考文章](http://manajay.com/2017/01/homebrew-clean-install/)
> * [ruby参考文章](http://manajay.com/2017/01/mac-ruby-install/)

`brew list` 查看安装状态 , 如下图
![brew-list](/image/brew-list.png)


### mysql 

* `brew install mysql` 安装 `mysql`


执行 mysql
```
mysql
```
会报下面的错
```
ERROR 2002 (HY000): Can't connect to local MySQL server through socket '/tmp/mysql.sock' (2)
```
解决办法:
```
mysql.server start
```
然后登录, 注意没有首次root登录,没有密码 
```
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
* `brew install tomcat` 
> 注意版本 tomcat 7 对应 java的jdk7.0
 
* 检查是否安装成功 `catalina -h`
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

![tomcat-config](/image/tomcat-config.gif)
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
* `brew install maven` 安装 `maven`

* 安装后 `mvn --version` 查看相关的配置 

```
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-04T03:39:06+08:00)
Maven home: /usr/local/Cellar/maven/3.5.0/libexec
Java version: 1.8.0_111, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.6", arch: "x86_64", family: "mac"
```
如果没有打印,说明 环境变量没有配置

#### 配置 maven 环境变量

注意 运行的前提是 环境变量

`./etc/profile` 文件   全局共有配置，无论哪个用户登录，都会读取此文件
`/etc/bashrc `   （一般在这个文件中添加系统级环境变量）全局（公有）配置，bash `shell`执行时，不管是何种方式，都会读取此文件。
`~/.bash_profile`  （一般在这个文件中添加用户级环境变量）


* `vi ~/.bash_profile`
* 添加如下命令

```
export M2_HOME=/usr/local/Cellar/maven/3.5.0
export PATH=$PATH:$M2_HOME/bin
```
```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home
export ANDROID_HOME=~/Library/Android/sdk
export PATH=$JAVA_HOME/bin:$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:${JAVA_HOME}/bin:~/.rvm/rubies/ruby-2.4.0/bin/ruby
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
```

* `JAVA_HOME` 注意`jdk`版本号
* `PATH` 多个路径用 `:` 隔开
* `CLASSPATH` 


* 注意`M2_HOME`的路径要看你自己电脑上的路径

![image.png](/image/m2-path.png)

![image.png](/image/idea-setting.png)

![image.png](/image/idea-maven-location.png)


* `source ~/.bash_profile` 刷新相关配置


*  当然也可以 使用 idea 自带的 maven, 默认自带 maven2 和 maven3 .
路径就在 idea 的app里面. 

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


