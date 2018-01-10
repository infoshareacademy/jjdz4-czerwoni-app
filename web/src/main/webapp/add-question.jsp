<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dodawanie i edycja pytań</title>
    <style><%@include file="css/style.css"%></style>
</head>
<body>
<div id="container">
    <c:if test="${sessionScope.mode != 'editMode'}">
        <form method="post" action="add-question">
            <label>Treść pytania: </label><input name="questionName" type="text" value="${sessionScope.question.questionName}"/> <br/><br/>
            <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${sessionScope.guestion.questionLevel}"/> <br /><br />
            <input class="button" type="submit" name="add-question" value="Dodaj"/>
        </form>
    </c:if>
    <c:if test="${sessionScope.mode == 'editMode'}">
        <form method="post" action="assign-parent-answer">
            Pytanie: ${sessionScope.question.questionName}, poziom: ${sessionScope.question.questionLevel} <br/><br/>
            <input class="button" type="submit" name="assign-parent-answer" value="Przypisz pytanie do odpowiedzi nadrzędnej"/>
            <div class="homeButton"><a href="index.html">Home</a> </div>
        </form>
    </c:if>
</div>
</body>
</html>