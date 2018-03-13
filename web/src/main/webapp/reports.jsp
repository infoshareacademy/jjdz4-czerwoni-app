<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>What do you want?</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/fontello/css/fontello.css" type="text/css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id"
          content="830889560506-bfd7gjnpsj4o3ss6n24f2pis4dscu4u9.apps.googleusercontent.com">
</head>
<body class="bg-dark">
<div class="container">
    <%@include file="header.jsp"%>
    <%@include file="links.jsp"%>
    <%@include file="login-window.jsp" %>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <div class="col-12 mx-auto">
                <h3>Raport aktywności użytkowników</h3>
                <form method="post" action="/reports">
                    <label class="pt-2">Podaj e-mail szukanego użytkownika: </label><br/>
                    <input type="email" name="email"/><br/>
                    <input type="submit" name="emailSearch" class="pt-2" value="Wyświetl raport"/>
                </form><br/>
                <form method="post" action="/reports">
                    <input type="submit" name="showAll" value="Pokaż raport"/>
                </form>
                <c:choose>
                    <c:when test="${not empty errorMessageReport}">
                        <div class="errorMessage">${errorMessageReport}</div>
                    </c:when>
                    <c:when test="${not empty okMessageId}">
                        <div class="logtext">${okMessageId}</div>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${not empty statsList}">
                        <c:forEach var="stat" items="${statsList}">
                            <c:out value="${stat.userLogin}"/>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>