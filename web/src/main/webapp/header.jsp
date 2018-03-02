<div class="row">
<div class="col">
    <a href="index.jsp"><h1>
        <i class="icon-shopping-basket"></i>  <span class="d-none d-lg-inline-block">What Do You Want</span>
    </h1></a>
</div>
<div class="col text-lg-right text-sm-center text-md-right text-center">
    <div class="dropdown">
        <button class="btn btn-dark dropdown-toggle bg-dark m-3" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="icon-user"></i> <span class="d-none d-lg-inline-block">Panel administatora</span>
        </button>
        <div class="dropdown-menu bg-dark dropdown-menu-right" aria-labelledby="dropdownMenuButton">
            <form class="px-4 py-3" method="post" action="login">
                <div class="form-group">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" id="login" name="login" placeholder="login">
                </div>
                <div class="form-group">
                    <label for="exampleDropdownFormPassword1">Hasło</label>
                    <input type="password" class="form-control" id="exampleDropdownFormPassword1" name="password" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-secondary">Zaloguj się</button>
            </form>
            <div class="dropdown-divider"></div>
        </div>
    </div>
    <c:if test="${sessionScope.login!=null}">
        <div class="col logtext">
            Zalogowano: <a href="admin-panel.jsp"> ${sessionScope.login}</a>
            <a href="logout" onclick="logoutGoogle()"><span>Wyloguj</span></a>
        </div>
    </c:if>
</div>
</div>
