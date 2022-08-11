<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.08.2022
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div style="position: absolute; top:35%; left: 45%; font-size: 20px">
    <s:form method="post" action="/user/reg" modelAttribute="user">
        <s:input path="name" placeholder="name"/>
        <br>
        <s:errors path="name"/>
        <br>

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
