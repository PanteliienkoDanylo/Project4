<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
            <form action="login.jsp" method="POST">
                <button class="btn btn-success" type="submit"><fmt:message key="index.signIn"/></button>
            </form>

            <form action="registration.jsp" method="POST">
                <button class="btn btn-success" type="submit"><fmt:message key="index.register"/></button>
            </form>
        </div>
    </div> <!-- /container -->
</body>
</html>