<%--
  Created by IntelliJ IDEA.
  User: manajay
  Date: 31/07/2017
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>
    <title>用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<form id="registerForm" action="${pageContext.request.contextPath}/user/register" method="post">
    <table width="400" border="1">
        <tr>
            <td>用户名称</td>
            <td> <input  name="name" /> </td>
        </tr>
        <tr>
            <td>用户年龄</td>
            <td> <input type="number" name="age" /> </td>
        </tr>

        <tr>
            <td>登录密码</td>
            <td> <input type="password" name="password"  placeholder="密码位数8~16位,包含大小写"/> </td>
        </tr>

        <tr>
            <td>个人介绍</td>
            <td> <input name="detail"  placeholder="简要介绍一下自己吧"/> </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit"  value="注册"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
