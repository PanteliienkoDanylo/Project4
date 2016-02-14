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
    <h1><fmt:message key="operations"/> </h1>
  </div>

  <div class="panel panel-default">
    <div class="panel-heading"></div>
    <div class="panel-body">
      <ul class="nav nav-pills">
        <li role="presentation"><a href="#" onclick="$('#form-ingredients').submit()"><fmt:message key="ingredients"/></a></li>
        <li role="presentation"><a href="#" onclick="$('#form-users').submit()"><fmt:message key="users"/></a></li>
        <li role="presentation" class="active"><a href="#" onclick="$('#form-operations').submit()"><fmt:message key="operations"/></a></li>
        <li role="presentation"><a href="#" onclick="$('#form-drinks').submit()"><fmt:message key="drinks"/></a></li>
      </ul>
    </div>
  </div>

  <table class="table table-striped table-bordered">
    <thead>
    <tr>
      <th>id</th>
      <th>login</th>
      <th>drink</th>
    </tr>
    </thead>
    <c:forEach items="${operations}" var="operation">

      <tr>
        <td>${operation.id}</td>
        <td>${operation.login}</td>
        <td>${operation.drink}</td>
      </tr>
    </c:forEach>
  </table>
</div> <!-- /container -->
</body>
</html>
