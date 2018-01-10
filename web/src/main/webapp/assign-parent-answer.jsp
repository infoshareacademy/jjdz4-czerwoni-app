<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przypisz odpowiedź nadrzędną</title>
</head>
<body>
<div id="container">
    <form method="post" action="assign-parent-answer">
        <label>Treść pytania: </label><input name="questionName" type="text" value="${sessionScope.question.questionName}"/> <br/><br/>
        <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${sessionScope.question.questionLevel}"/> <br /><br />
        <label>Wybierz odpowiedź nadrzędną: </label>
        <select name="answer">
            <option value="wybierz odpowiedź">Wybierz odpowiedź</option>
            <c:forEach var="list" items="${answersList}">
                <option value="${list.answerId}">${list.answerName}</option>
            </c:forEach>
        </select>
        <input class="button" type="submit" name="add-parent-answer" value="Dodaj"/>
    </form>
</div>
</body>
</html>