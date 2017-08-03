<%--
  Created by IntelliJ IDEA.
  User: manajay
  Date: 27/07/2017
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <title>用户信息列表</title>
</head>

<body>

列表如下: <br/>

<table width="100%" border=1 >
<tr>
    <td>用户名</td>
    <td>年龄</td>
    <td>介绍</td>
    <td>操作</td>
</tr>

<c:forEach items="${list}" var="item">
    <tr>
        <td>${item.name}</td>
        <td>${item.age}</td>
        <td>${item.detail}</td>
        <td>
            <a href="${pageContext.request.contextPath}/user/goToEdit?id=${item.id}">修改</a>
            <a href="${pageContext.request.contextPath}/user/delete?id=${item.id}">删除</a>
        </td>
    </tr>
</c:forEach>

</table>

</body>
</html>
