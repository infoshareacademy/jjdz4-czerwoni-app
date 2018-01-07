<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Wybór kategorii na podstawie pytań</title>
</head>
<body>
<h2>Wybór kategorii na podstawie pytań</h2>
<div>
    <form method="post" action="questions">
        <div>${question.questionName}</div>
        <c:forEach var="list" items="${question.answerList}">
            <label><input name="answerRadio" type="radio" value="${list.answerName}"/>${list.answerName}</label><br/>
        </c:forEach>
    </form>
</div>
</body>
</html>