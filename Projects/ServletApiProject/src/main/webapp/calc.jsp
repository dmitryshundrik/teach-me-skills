<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.06.2022
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/calc">Calculator</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/findHistory">History</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Log out</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <form action="/calc" method="post">
                <div class="mb-3">
                    <label for="exampleInputNumber1" class="form-label">Number 1</label>
                    <input type="number" name="num1" class="form-control" id="exampleInputNumber1"
                           aria-describedby="emailHelp" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputNumber2" class="form-label">Number 2</label>
                    <input type="number" name="num2" class="form-control" id="exampleInputNumber2"
                           aria-describedby="emailHelp" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputOperation" class="form-label">Operation</label>
                    <select name="operation" class="form-select" id="exampleInputOperation"
                            aria-label="Default select example">
                        <option value="sum" selected>+</option>
                        <option value="sub">-</option>
                        <option value="mul">*</option>
                        <option value="div">/</option>
                    </select>
                </div>
                <div>
                    <button>Submit</button>
                </div>
            </form>
            <%
                if (request.getAttribute("result") != null) {
                    out.println("<div class=\"alert alert-secondary\" role=\"alert\">\n" +
                            request.getAttribute("result") + "\n" + "</div>");
                }
            %>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
