<%--
  Created by IntelliJ IDEA.
  User: calculator
  Date: 26.07.2022
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calc/main" method="post">
    <input type="text" name="firstNumber" placeholder="First Number">
    <br>
    <br>
    <input type="text" name="secondNumber" placeholder="Second Number">
    <br>
    <br>
    <input type="text" name="operation" placeholder="Operation">
    <br>
    <br>
    <button>Submit</button>
</form>
<p>Result = ${result}</p>
</body>
</html>
