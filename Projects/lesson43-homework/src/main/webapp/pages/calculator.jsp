<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.08.2022
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<div style="position: absolute; top:35%; left: 45%; font-size: 20px">
    <s:form method="post" action="/calc" modelAttribute="operation">
        <s:input path="firstNumber" placeholder="number"/>
        <br>
        <s:errors path="firstNumber"/>
        <br>

        <s:input path="secondNumber" placeholder="number"/>
        <br>
        <s:errors path="secondNumber"/>
        <br>

        <s:input path="operation" placeholder="operation"/>
        <br>
        <s:errors path="operation"/>

        <p>Result: ${result}</p>

        <s:button>Submit</s:button>
    </s:form>

    <s:form action="/">
        <input type="submit" value="Back"/>
    </s:form>
</div>
</body>
</html>
