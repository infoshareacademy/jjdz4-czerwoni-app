<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
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
    <%@include file="header.jsp" %>
    <%@include file="links.jsp" %>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <div class="tree">


                <ul>
                    <c:forEach var="list" items="${questionList}">
                        <li>
                            <a href="#"> ${list.questionName} </a>

                            <ul>
                                <c:forEach var="alist" items="${list.answerList}">
                                    <li id="annswerName"><a href="#"> ${alist.answerName}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>


                <%--<ul>--%>
                    <%--<li>--%>
                        <%--<a href="#">Parent</a>--%>
                        <%--<ul>--%>
                            <%--<li>--%>
                                <%--<a href="#">Child</a>--%>
                                <%--<ul>--%>
                                    <%--<li>--%>
                                        <%--<a href="#">Grand Child</a>--%>
                                    <%--</li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Child</a>--%>
                                <%--<ul>--%>
                                    <%--<li><a href="#">Grand Child</a></li>--%>
                                    <%--<li>--%>
                                        <%--<a href="#">Grand Child</a>--%>
                                        <%--<ul>--%>
                                            <%--<li>--%>
                                                <%--<a href="#">Great Grand Child</a>--%>
                                            <%--</li>--%>
                                            <%--<li>--%>
                                                <%--<a href="#">Great Grand Child</a>--%>
                                            <%--</li>--%>
                                            <%--<li>--%>
                                                <%--<a href="#">Great Grand Child</a>--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</li>--%>
                                    <%--<li><a href="#">Grand Child</a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            </div>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>
