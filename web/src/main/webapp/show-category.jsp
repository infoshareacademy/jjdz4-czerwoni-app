<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Wybór kategorii na podstawie pytań</title>
    <style>
        <%@include file="css/style.css" %>
    </style>
</head>
<body>
<div id="container">
    <h2 id="questionTitle">Wybór kategorii na podstawie pytań</h2>
    <div class="questionForm">
        <form method="post" action="questions">

            <div id="questionName">${sessionScope.question.questionName}</div>
            <br/>

            <c:forEach var="list" items="${sessionScope.question.answerList}">
                <c:if test="${list.answerId == selectedRadio}">
                    <div id="annswerName">
                        <input name="answerRadio" type="radio" value="${list.answerId}" checked/>${list.answerName}
                        <br/><br/>
                    </div>
                </c:if>
                <c:if test="${list.answerId != selectedRadio}">
                    <div id="annswerName">
                        <input name="answerRadio" type="radio" value="${list.answerId}"/>${list.answerName}<br/><br/>
                    </div>
                </c:if>
            </c:forEach>
            <div id="category">
                Twoja kategoria Allegro to:
                <a id="categoryName" href="${category.categoryAllegroLink}">${category.categoryName}</a><br/><br/>
            </div>
            <c:if test="${isNextQuestion == true}">
                Czy chcesz szukac dalej?<br/><br/>
                <input class="button" type="submit" name="questions" value="Dalej">
            </c:if>
            <div class="homeButton"><a href="index.html">Home</a></div>

        </form>
    </div>
</div>
</body>
</html>