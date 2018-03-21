<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.language == null}">
    <c:set var="language" scope="session" value="en_GB"/>
</c:if>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="what" var="WDYWlanguage"/>
<!DOCTYPE html>
<html lang="${language}">
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
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <h3><fmt:message key="home.welcomeInfo" bundle="${WDYWlanguage}"/></h3>
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                <fmt:message key="home.detailInfo" bundle="${WDYWlanguage}"/>
            </div>
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                <ul>
                    <li><fmt:message key="home.listDetails1" bundle="${WDYWlanguage}"/></li>
                    <li><fmt:message key="home.listDetails2" bundle="${WDYWlanguage}"/></li>
                    <li><fmt:message key="home.listDetails3" bundle="${WDYWlanguage}"/></li>
                    <li><fmt:message key="home.listDetails4" bundle="${WDYWlanguage}"/></li>
                </ul>
            </div>
            <div>
                <%@include file="login-window.jsp" %>
            </div>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>
