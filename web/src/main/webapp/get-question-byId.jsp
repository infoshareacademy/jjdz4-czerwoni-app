<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="what" var="WDYWlanguage" scope="session"/>

<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="questionById.title" bundle="${WDYWlanguage}"/></title>
</head>
<body>
<div>
    <fmt:message key="questionById.questionId" bundle="${WDYWlanguage}"/> <c:out value="${sessionScope.questionId}"/><br/>
    <fmt:message key="questionById.question" bundle="${WDYWlanguage}"/> <c:out value="${sessionScope.questionName}"/><br/>
    <fmt:message key="questionById.questionLevel" bundle="${WDYWlanguage}"/> <c:out value="${sessionScope.questionLevel}"/><br/>
</div>
<br/><br/>
-- <c:if test="${isUpdateUser == false}">
    <form method="post" action="add-answer">
        <input type="submit" name="add-answer" value="<fmt:message key="questionById.addQuestion" bundle="${WDYWlanguage}"/>">
    </form>
-- </c:if>
-- <%@ include file="go-back.jsp" %>
</body>
</html>