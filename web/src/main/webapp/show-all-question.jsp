<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przypisz odpowiedź nadrzędną</title>
</head>
<body>
<div>
    <form method="get" action="show-all-question">
        <label>Treść pytania: </label><input name="questionName" type="text" value="${questionName}"/> <br/><br/>
        <label>Poziom pytania: </label><input name="questionLevel" type="text" value="${questionLevel}"/> <br /><br />
        <label>Wybierz odpowiedź nadrzędną: </label>
        <%--<input type="text" name="questList" list="answers">--%>
        <%--<datalist id="answers">--%>
        <select name="answers">
           <c:forEach var="list" items="${answers}">
               <option value="${list.answeId}">${list.answerId}</option>
           </c:forEach>
        </select>
        <%--</datalist>--%>
    </form>
</div>
</body>
</html>