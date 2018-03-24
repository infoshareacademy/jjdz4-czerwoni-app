<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="what" var="WDYWlanguage" scope="session"/>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="home.mainName" bundle="${WDYWlanguage}"/></title>
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
    <%@include file="header.jsp" %>
    <%@include file="links.jsp" %>
    <%@include file="login-window.jsp" %>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <div class="col-12 text-center">
                <h4><fmt:message key="home.categories" bundle="${WDYWlanguage}"/></h4></div>
            <div class="col-12">
                <c:choose>
                    <c:when test="${empty mainCat}">
                        <span style="font-size: 1.3em;"><fmt:message key="categories.mainInfo"
                                                                     bundle="${WDYWlanguage}"/></span>
                    </c:when>
                    <c:otherwise>
                        <a href="/allegro-categories?parent=0" style="font-size: 1.3em;"><fmt:message
                                key="categories.redirectToAllegroService" bundle="${WDYWlanguage}"/></a>
                        <c:forEach var="breadCrumb" items="${breadCrumbs}">
                            <a href="/allegro-categories?parent=${breadCrumb.catId}"
                               style="font-size: 1.3em;">> ${breadCrumb.catName}</a>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${not empty list}">
                        <c:forEach var="category" items="${list}">
                            <div class="row justify-content-start">
                                <a href="/allegro-categories?parent=${category.key.catId}" class="col-4 px-0">
                                    <div class="py-2 text-center" style="border: 1px white;border-top-style: dotted;">
                                        <span
                                                <c:if test="${category.key.promoted==true}">style="font-weight: bold; color: aqua;"</c:if>>
                                            <c:out value="${category.key.catPosition+1}"/>. <c:out
                                                value="${category.key.catName}"/><br/>
                                        </span>
                                    </div>
                                </a>
                                <a href="${category.value}" target="_blank">
                                    <div class="px-3 py-2 text-center"
                                         style="border: 1px white;border-top-style: dotted; color: yellow;">
                                        <fmt:message key="categories.redirectToAllegroCategory"
                                                     bundle="${WDYWlanguage}"/>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <a href="${lastCatLink}" target="_blank" class="col-4 px-0">
                            <div class="py-3" style="border: 1px white;border-top-style: dotted;">
                                <fmt:message key="categories.redirectToAllegroService" bundle="${WDYWlanguage}"/>
                            </div>
                        </a>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>
