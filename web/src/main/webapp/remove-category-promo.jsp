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
                <div class="col-12">
                    <h3 class="mx-auto">Usuń kategorię z listy promowanych.</h3>
                    <form method="post" action="/remove-category-promo">
                        <label class="pt-2">Podaj Id kategorii do usunięcia: </label><br/>
                        <input type="text" name="id"/><br/>
                        <input type="submit" name="idSearch" class="pt-2" value="Usuń kategorię"/>
                    </form>
                    <c:choose>
                        <c:when test="${not empty errorMessageId}">
                            <div class="errorMessage">${errorMessageId}</div>
                        </c:when>
                        <c:when test="${not empty okMessageId}">
                            <div class="logtext">${okMessageId}</div>
                        </c:when>
                    </c:choose>
                </div>
                <div class="col-12">
                        <label class="pt-2">Wybierz kategorię z listy: </label><br/>
                    <c:choose>
                        <c:when test="${not empty errorMessageName}">
                            <div class="errorMessage">${errorMessageName}</div>
                        </c:when>
                        <c:when test="${not empty okMessageName}">
                            <div class="logtext">${okMessageName}</div>
                        </c:when>
                    </c:choose>
                <c:choose>
                    <c:when test="${not empty categoriesMap}">
                        <c:forEach var="category" items="${categoriesMap}">
                                <form method="post" action="/add-category-promo">
                                    <div class="py-2 text-center" style="border: 1px white;border-top-style: dotted;">
                                        <c:out value="${category.value}"/>
                                        <input type="submit" name="addCategoryByName" value="Dodaj kategorię o id ${category.key.catId}"/>
                                    </div>
                                </form>
                        </c:forEach>
                    </c:when>
                </c:choose>
                </div>
            </div>
            <div class="row m-0">
                <span class="mx-auto p-2">&#169 infoShare Academy</span>
            </div>
        </div>
</body>
</html>
