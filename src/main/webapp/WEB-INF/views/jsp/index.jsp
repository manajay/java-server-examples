
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<title>用户登录</title>

<body>

<form name="login-form" action="${pageContext.request.contextPath}/api/userLogin" method="post">
    <table width="400" border="1">

        <tr>
            <td colspan="2">登录窗口</td>
        </tr>
        <tr>
            <td>
                用户名
            </td>
            <td>
                <input type="text" name="name" size="10"></input>
            </td>
        </tr>

        <tr>
            <td>
                密码
            </td>
            <td>
                <input type="text" name="password"  size="10"></input>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="登录"/>
                <a href="${pageContext.request.contextPath}/api/gotoRegister">注册</a>
            </td>
        </tr>

    </table>

</form>

</body>


</html>
