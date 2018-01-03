<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przypisz odpowiedź nadrzędną</title>
</head>
<body>
<div>
    <form method="post" action="assign-parent-answer">
        <label>Treść pytania: </label><input name="questionName" type="text" value="${sessionScope.questionName}"/> <br/><br/>
        <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${sessionScope.questionLevel}"/> <br /><br />
        <label>Wybierz odpowiedź nadrzędną: </label>
        <select name="answer">
            <option value="wybierz odpowiedź">Wybierz odpowiedź</option>
            <c:forEach var="list" items="${answersList}">
                <option value="${list.answerName}">${list.answerName}</option>
            </c:forEach>
        </select>
        <input type="submit" name="assign-parent-answer" value="Dodaj"/>
    </form>
</div>
</body>
</html>