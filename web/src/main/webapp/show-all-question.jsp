<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przypisz odpowiedź nadrzędną</title>
    <style>
        <%@include file="css/style.css" %>
    </style>
</head>
<body>
<div id="container">
    <ol>
        <c:forEach var="list" items="${questionList}">
            <li>${list.questionName} (poziom: ${list.questionLevel}, QId_${list.questionId})
                <ol type="a">
                    <c:forEach var="alist" items="${list.answerList}">
                        <li>${alist.answerName} QId_${alist.relatedQuest.questionId}</li>
                    </c:forEach>
                </ol>
            </li>
        </c:forEach>
    </ol>
</div>
</body>
</html>