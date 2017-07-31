<%--
  Created by IntelliJ IDEA.
  User: manajay
  Date: 31/07/2017
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户详情</title>
</head>
<body>

<form id="itemForm" action="${pageContext.request.contextPath}/api/updateUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <table border="1">
        <tr>
            <td>用户名称</td>
            <td> <input type="text" name="name" value="${user.name}"/> </td>
        </tr>
        <tr>
            <td>用户年龄</td>
            <td> <input type="text" name="age" value="${user.age}"/> </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit"  value="提交"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
