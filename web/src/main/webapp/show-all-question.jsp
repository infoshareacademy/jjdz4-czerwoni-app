<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przypisz odpowiedź nadrzędną</title>
</head>
<body>
<div>
    <ol>
        <c:forEach var="list" items="${questionList}">
            <li>${list.questionName} (poziom: ${list.questionLevel})
                <ol type="a">
                    <c:forEach var="alist" items="${list.answerList}">
                        <li>${alist.answerName}</li>
                    </c:forEach>
                </ol>
            </li>
        </c:forEach>
    </ol>
</div>
</body>
</html>