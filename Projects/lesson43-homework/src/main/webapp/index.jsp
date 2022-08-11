<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div style="position: absolute; top:35%; left: 45%; font-size: 20px">
    <c:if test="${sessionScope.currentUser == null}" >
        <a href="/user/reg">Registration</a>
        <br>
        <a href="/user/login">Log In</a>
        <br>
    </c:if>

    <c:if test="${sessionScope.currentUser != null}" >
        <a href="/calc">Calculator</a>
        <br>
        <a href="/calc/history">History</a>
        <br>
        <a href="/user/settings">Settings</a>
        <br>
        <a href="/user/logout">Logout</a>
    </c:if>
</div>
</body>
</html>
