<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Wybór kategorii na podstawie pytań</title>
    <style><%@include file="css/style.css"%></style>
</head>
<body>
<h2 id="questionTitle">Wybór kategorii na podstawie pytań</h2>
<div class="questionForm">
    <form method="post" action="show-category">
        <div id="questionName">${question.questionName}</div><br/>
        <c:forEach var="list" items="${question.answerList}">
            <div id="annswerName">
                <input name="answerRadio" type="radio" value="${list.answerId}"/>${list.answerName}<br/><br/>
            </div>
        </c:forEach>
        <input type="submit" name="questions" value="Dalej">
    </form>
</div>
</body>
</html>