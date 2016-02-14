<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

    <title>Coffee Machine</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min" rel="stylesheet">
    <link href="css/coffee-machine.css" rel="stylesheet">
</head>

<body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<%@ include file="../header.jsp" %>

<form action="controllerServlet" method="post" id="form-ingredients">
    <input type="hidden" name="command" value="ingredients">
</form>
<form action="controllerServlet" method="post" id="form-users">
    <input type="hidden" name="command" value="users">
</form>
<form action="controllerServlet" method="post" id="form-operations">
    <input type="hidden" name="command" value="operations">
</form>
<form action="controllerServlet" method="post" id="form-drinks">
    <input type="hidden" name="command" value="drinks">
</form>

<div class="container">
    <div class="jumbotron">
        <h1><fmt:message key="drinks"/> </h1>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading"></div>
        <div class="panel-body">
            <ul class="nav nav-pills">
                <c:if test="${user.isAdmin > 0}">
                    <li role="presentation"><a href="#" onclick="$('#form-ingredients').submit()"><fmt:message key="ingredients"/></a></li>
                    <li role="presentation"><a href="#" onclick="$('#form-users').submit()"><fmt:message key="users"/></a></li>
                    <li role="presentation"><a href="#" onclick="$('#form-operations').submit()"><fmt:message key="operations"/></a></li>
                </c:if>
                <li role="presentation" class="active"><a href="#" onclick="$('#form-drinks').submit()"><fmt:message key="drinks"/></a></li>
            </ul>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading"><fmt:message key="topUp"/></div>
        <div class="panel-body">
            <form action="controllerServlet" method="post">
                <input type="text" name="balance">
                <input type="hidden" name="command" value="balance">
                <button type="submit" class="btn btn-warning"><fmt:message key="add"/></button>
            </form>
        </div>
    </div>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>count</th>
            <th>capacity</th>
            <th>take</th>
        </tr>
        </thead>
        <c:forEach items="${drinks}" var="drink">
            <tr>
                <td>${drink.id}</td>
                <td>${drink.name}</td>
                <td>${drink.price}</td>
                <td>${drink.count}</td>
                <td>${drink.capacity}</td>
                <td>
                    <form action="controllerServlet" method="post">
                        <input type="hidden" name="id" value=${drink.id}>
                        <input type="hidden" name="command" value="getWater">
                        <button type="submit"><fmt:message key="take"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div> <!-- /container -->
</body>
</html>
