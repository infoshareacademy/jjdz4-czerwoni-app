<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Wybór kategorii na podstawie pytań</title>
</head>
<body>
<h2>Wybór kategorii na podstawie pytań</h2>
<div>
    <form method="post" action="show-category">
        <div>${question.questionName}</div>
        <c:forEach var="list" items="${question.answerList}">
            <div>
                <label><input name="answerRadio" type="radio" value="${list.answerId}"/>${list.answerName}</label><br/>
            </div>
        </c:forEach>
        <input type="submit" name="questions" value="Dalej">
    </form>
</div>
</body>
</html>