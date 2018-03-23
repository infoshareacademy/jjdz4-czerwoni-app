<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="what" var="WDYWlanguage" scope="session"/>


<div class="container">[<a style="color: aliceblue !important;" href="<c:url value="/index.jsp"/>"><fmt:message key="goBack.mainPage" bundle="${WDYWlanguage}"/></a>]
</div>
<br>
<hr>
<br>
