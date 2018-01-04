<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przypisz odpowiedź nadrzędną</title>
</head>
<body>
<div>
    <form method="get" action="show-all-question">
        <label>Treść pytania: </label><input name="questionName" size="100" type="text" value="${questionName}"/> <br/><br/>
        <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${questionLevel}"/> <br /><br />
        <label>Wybierz odpowiedź nadrzędną: </label><br/>
           <c:forEach var="list" items="${answers}">
               <label><input name="answerRadio" type="radio" value="${list.answerName}"/>${list.answerName}</label><br/>
           </c:forEach>
    </form>
</div>
</body>
</html>