<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="/language" />

<form action="controllerServlet" method="post" id="form-en">
    <input type="hidden" name="from" value="${pageContext.request.requestURI}">
    <input type="hidden" name="language" value="en_US">
    <c:if test="${not empty req}">
        <input type="hidden" name="request" value="${req}">
    </c:if>
    <c:if test="${not empty com}">
        <input type="hidden" name="command" value="${com}">
    </c:if>
    <%--<button type="submit"> </button>--%>
</form>
<form action="controllerServlet" method="post" id="form-ru">
    <input type="hidden" name="from" value="${pageContext.request.requestURI}">
    <input type="hidden" name="language" value="ru_RU">
    <c:if test="${not empty req}">
        <input type="hidden" name="request" value="${req}">
    </c:if>
    <c:if test="${not empty com}">
        <input type="hidden" name="command" value="${com}">
    </c:if>
</form>
<form action="controllerServlet" method="post" id="form-logout">
    <input type="hidden" name="command" value="logout">
</form>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">&lt;<fmt:message key="header.coffee-machine"/>&gt;</a>
            <a class="navbar-brand" href="#"><fmt:message key="hello"/> ${user.login}</a>
            <a class="navbar-brand" href="#"><fmt:message key="header.yourBalance"/> ${user.balance}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
<%--
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
--%>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" onclick="$('#form-en').submit()"><fmt:message key="header.english"/></a>
                </li>
                <li>
                    <a href="#" onclick="$('#form-ru').submit()"><fmt:message key="header.russian"/></a>
                </li>
                <li>
                    <a href="#" onclick="$('#form-logout').submit()"><fmt:message key="header.logOut"/></a>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
