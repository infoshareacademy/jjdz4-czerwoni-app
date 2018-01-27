<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User details</title>
</head>
<body>
<div>
    Pytanie ID: <c:out value="${sessionScope.questionId}"/><br/>
    Treść pytania: <c:out value="${sessionScope.questionName}"/><br/>
    Poziom pytania: <c:out value="${sessionScope.questionLevel}"/><br/>
</div>
<br/><br/>
-- <c:if test="${isUpdateUser == false}">
    <form method="post" action="add-answer">
        <input type="submit" name="add-answer" value="Dodaj pytanie">
    </form>
-- </c:if>
-- <%@ include file="go-back.jsp" %>
</body>
</html>