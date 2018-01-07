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
        <div>${sessionScope.question.questionName}</div>

        <c:forEach var="list" items="${sessionScope.question.answerList}">
            <c:if test="${list.answerId == selectedRadio}">
                <div>
                    <input name="answerRadio" type="radio" value="${list.answerId}" checked />${list.answerName} <br/>
                </div>
            </c:if>
            <c:if test="${list.answerId != selectedRadio}">
            <div>
                <input name="answerRadio" type="radio" value="${list.answerId}"/>${list.answerName}<br/>
            </div>
            </c:if>
        </c:forEach>
        <br/>
        Twoja kategoria Allegro to: ${category.categoryName}<br/>
        <a href="${category.categoryAllegroLink}">Link Allegro</a><br/><br/>
        Czy chcesz szukac dalej?<br/>
        <input type="submit" name="questions" value="Dalej">
    </form>
</div>
</body>
</html>