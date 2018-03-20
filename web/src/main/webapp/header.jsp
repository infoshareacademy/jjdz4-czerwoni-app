<div class="row">
<div class="col">
    <a href="index.jsp"><h1>
        <i class="icon-shopping-basket"></i>  <span class="d-none d-lg-inline-block">What Do You Want</span>
    </h1></a>
</div>
<div class="col text-lg-right text-sm-center text-md-right text-center">
    <c:choose>
        <c:when test="${sessionScope.login==null}">
            <div class="mt-3">
                <i class="icon-user"></i> <a href="index.jsp"><span>Zaloguj</span></a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col mt-3">
                <i class="icon-user"></i> <a href="admin-panel.jsp"> ${sessionScope.login}</a>
                <a href="logout" onclick="logoutGoogle()"><span>Wyloguj</span></a>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</div>
