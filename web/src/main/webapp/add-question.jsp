<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dodawanie i edycja pytań</title>
</head>
<body>
<div>
    <c:if test="${sessionScope.mode != 'editMode'}">
    <form method="post" action="add-question">
        <label>Treść pytania: </label><input name="questionName" type="text" value="${sessionScope.questionName}"/> <br/><br/>
        <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${sessionScope.questionLevel}"/> <br /><br />
        <input type="submit" name="add-question" value="Dodaj"/>
    </form>
    </c:if>
</div>
<div>
    <c:if test="${sessionScope.mode == 'editMode'}">
        <form method="post" action="assign-parent-answer">
            <label>Treść pytania: </label><input name="questionName" type="text" value="${sessionScope.questionName}"/> <br/><br/>
            <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${sessionScope.questionLevel}"/> <br /><br />
            <input type="submit" name="assign-parent-answer" value="Przypisz pytanie"/>
            <input type="submit" name="home" value="Strona główna"/>
        </form>
    </c:if>
</div>
</body>
</html>