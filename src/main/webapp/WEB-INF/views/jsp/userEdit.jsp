<%@ page contentType="text/html;charset=UTF-8"  %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑用户详情</title>
</head>
<body>

<h1>使用req获取表单数据</h1>
<form id="updateByRequestForm" action="${pageContext.request.contextPath}/user/updateByRequest" method="post" accept-charset="UTF-8">
    <input type="hidden" name="id" value="${user.id}">
    <table border="1">
        <tr>
            <td>用户名称</td>
            <td> <input  name="name" value="${user.name}"/> </td>
        </tr>
        <tr>
            <td>用户年龄</td>
            <td> <input  name="age" value="${user.age}"/> </td>
        </tr>
        <tr>
            <td>用户介绍</td>
            <td> <input  name="detail" value="${user.detail}"/> </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit"  value="提交"/>
            </td>
        </tr>
    </table>
</form>
5
<h1>使用User获取表单数据</h1>
<form id="updateByPoJoForm" action="${pageContext.request.contextPath}/user/updateByPoJo" method="post" accept-charset="UTF-8">
    <input type="hidden" name="id" value="${user.id}">
    <table border="1">
        <tr>
            <td>用户名称</td>
            <td> <input  name="name" value="${user.name}"/> </td>
        </tr>
        <tr>
            <td>用户年龄</td>
            <td> <input  name="age" value="${user.age}"/> </td>
        </tr>
        <tr>
            <td>用户介绍</td>
            <td> <input  name="detail" value="${user.detail}"/> </td>
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
