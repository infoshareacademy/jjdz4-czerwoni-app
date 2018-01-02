<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dodawanie i edycja pytań</title>
</head>
<body>
<div>
    <form method="post" action="add-question">
        <label>Treść pytania: </label><input name="questionName" type="text" value="${questionName}"/> <br/><br/>
        <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${questionLevel}"/> <br /><br />
        <label>Powiązane pytanie: </label>
            <select name="answer">
                <option value="wybierz odpowiedź">Wybierz odpowiedź</option>
                <c:forEach var="list" items="${answersList}">
                    <option value="${list.answerName}">${list.answerName}</option>
                </c:forEach>

            </select>
        <input type="submit" name="add-question" value="Dodaj"/>
    </form>
</div>
</body>
</html>