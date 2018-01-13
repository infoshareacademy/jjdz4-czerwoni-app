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
    <h2 id="questionTitle">Dodaj odpowiedzi do pytania</h2>
    <div>${sessionScope.question.questionName}</div>
    <div>
        <ol type="a">
            <c:forEach var="alist" items="${sessionScope.question.answerList}">
                <li>${alist.answerName} Kategoria: ${alist.relatedCategory.categoryName} Link: ${alist.relatedCategory.categoryAllegroLink}</li>
            </c:forEach>
        </ol>
    </div>

    <div class="questionForm">
        <form method="post" action="add-answers">
            <label>Odpowiedź: </label><input name="answerName" type="text"/><br /><br/>
            <label>Kategoria: </label><input name="categoryName" type="text"/><br /><br/>
            <label>Link Allegro: </label><input name="categoryAllegroLink" type="text"/><br /><br/>

            <div><input class="button" type="submit" name="add-answer" value="Zapisz"></div>
            <div><input class="button" type="submit" name="add-next-answer" value="Dodaj kolejną odpowiedź"></div>
            <div class="homeButton"><a href="index.html">Home</a></div>
        </form>
    </div>

</div>
</body>
</html>