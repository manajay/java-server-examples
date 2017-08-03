<%--
  Created by IntelliJ IDEA.
  User: manajay
  Date: 27/07/2017
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>${user.name}的个人信息</title>
</head>
<body>
<h1>获取单个的用户数据</h1>
<p>根据mapper-xml查询,request中获取 所需要查询人员的id</p>

列表如下:

<table border="1">
    <tr>
        <td>用户名称</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>用户年龄</td>
        <td>${user.age}</td>
    </tr>
</table>

</body>
</html>
