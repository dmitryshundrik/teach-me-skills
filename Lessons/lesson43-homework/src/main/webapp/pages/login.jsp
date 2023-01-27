<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.08.2022
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<div style="position: absolute; top:35%; left: 45%; font-size: 20px">
    <s:form method="post" action="/user/login" modelAttribute="loginUserModel">
        <s:input path="username" placeholder="username"/>
        <br>
        <s:errors path="username"/>
        <br>

        <s:input path="password" placeholder="password"/>
        <br>
        <s:errors path="password"/>

        <p>${message}</p>

        <s:button>Submit</s:button>
    </s:form>

    <s:form action="/">
        <input type="submit" value="Back"/>
    </s:form>
</div>
</body>
</html>
