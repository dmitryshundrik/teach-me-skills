<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.08.2022
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>History</title>
</head>
<body>
<div style="position: absolute; top:35%; left: 30%; font-size: 20px">
    <ul>
        <c:forEach items="${operations}" var="operation">
            <li>${operation}</li>
        </c:forEach>
    </ul>
    <br>
    <form action="/">
        <input type="submit" value="Back"/>
    </form>
</div>
</body>
</html>
