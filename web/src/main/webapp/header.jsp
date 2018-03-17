<div class="row">
<div class="col">
    <a href="index.jsp"><h1>
        <i class="icon-shopping-basket"></i>  <span class="d-none d-lg-inline-block">What Do You Want</span>
    </h1></a>
</div>
<div class="col text-lg-right text-sm-center text-md-right text-center">
    <c:if test="${sessionScope.login!=null}">
        <div class="col logtext mt-3" style="color: #ffffff;">
            <i class="icon-user"></i> <a href="admin-panel.jsp"> ${sessionScope.login}</a>
            <a href="logout" onclick="logoutGoogle()"><span>Wyloguj</span></a>
        </div>
    </c:if>
</div>
</div>
