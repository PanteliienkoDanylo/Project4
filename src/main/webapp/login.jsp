<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

    <title>Coffee Machine</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/coffee-machine.css" rel="stylesheet">
</head>

<body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<%@ include file="header.jsp" %>

<c:if test="${not empty reader}">
    <c:redirect url="app/drinks.jsp"/>
</c:if>

<div class="container">
    <div class="jumbotron">
        <form action="controllerServlet" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label"><fmt:message key="login"/></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" placeholder="Login" name="login">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label"><fmt:message key="pass"/></label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="pass">
                </div>
            </div>
            <input type="hidden" name="command" value="login">
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default"><fmt:message key="index.signIn"/></button>
                </div>
            </div>
        </form>
    </div>
</div> <!-- /container -->
</body>
</html>
