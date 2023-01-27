<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.08.2022
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<div style="position: absolute; top:35%; left: 45%; font-size: 20px">
    <s:form method="post" action="/user/settings" modelAttribute="settingsUserModel">
        <p>current name: ${sessionScope.currentUser.name}</p>
        <s:input path="newName" placeholder="new name"/>
        <br>
        <s:errors path="newName"/>
        <br>

        <p>current number: ${sessionScope.currentUser.telephones.get(0)}</p>
        <s:input path="newPhoneNumber1" placeholder="new phone number"/>
        <br>
        <s:errors path="newPhoneNumber1"/>
        <br>

        <p>current number: ${sessionScope.currentUser.telephones.get(1)}</p>
        <s:input path="newPhoneNumber2" placeholder="new phone number"/>
        <br>
        <s:errors path="newPhoneNumber2"/>
        <br>

        <s:input path="newPassword" placeholder="new password"/>
        <br>
        <s:errors path="newPassword"/>
        <br>

        <s:input path="currentPassword" placeholder="current password"/>
        <br>
        <s:errors path="currentPassword"/>

        <a href="/user/delete">delete account</a>

        <p>${message}</p>

        <s:button>Submit</s:button>
    </s:form>

    <s:form action="/">
        <input type="submit" value="Back"/>
    </s:form>
</div>
</body>
</html>
