<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="what" var="WDYWlanguage" scope="session"/>

<div class="row">
<div class="col">
    <a href="index.jsp"><h1>
        <i class="icon-shopping-basket"></i>  <span class="d-none d-lg-inline-block"><fmt:message key="all.mainName" bundle="${WDYWlanguage}"/></span>
    </h1></a>
</div>
<div class="col text-lg-right text-sm-center text-md-right text-center">
    <c:choose>
        <c:when test="${sessionScope.login==null}">
            <div class="mt-3">
                <i class="icon-user"></i> <a href="init"><span><fmt:message key="home.loginButton" bundle="${WDYWlanguage}"/></span></a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col mt-2">
                <i class="icon-user"></i> <a href="admin-panel.jsp"> ${sessionScope.login}</a>
                <a href="logout" onclick="logoutGoogle()"><span><fmt:message key="home.logoutButton" bundle="${WDYWlanguage}"/></span></a>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</div>
