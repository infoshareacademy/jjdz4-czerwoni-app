<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <title>What do you want?</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/fontello/css/fontello.css" type="text/css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body class="bg-dark">
<div class="container">
    <div class="row">
        <div class="col">
            <a href="index.jsp"><h1>
                <i class="icon-shopping-basket"></i>  <span class="d-none d-lg-inline-block">What Do You Want</span>
            </h1></a>
        </div>
        <div class="col text-lg-right text-sm-center text-md-right text-center">
            <div class="dropdown">
                <button class="btn btn-dark dropdown-toggle bg-dark m-3" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="icon-user"></i> <span class="d-none d-lg-inline-block">Zaloguj się</span>
                </button>
                <div class="dropdown-menu bg-dark dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                    <form class="px-4 py-3">
                        <div class="form-group">
                            <label for="exampleDropdownFormEmail1">Adres e-mail</label>
                            <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="your@email.com">
                        </div>
                        <div class="form-group">
                            <label for="exampleDropdownFormPassword1">Hasło</label>
                            <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
                        </div>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" class="form-check-input">
                                Zapamiętaj mnie
                            </label>
                        </div>
                        <button type="submit" class="btn btn-secondary">Zaloguj się</button>
                    </form>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" style="color: aliceblue">Nie masz konta? Zapisz się!</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row nav nav-pills nav-fill">
        <div class="nav-item w-25 border-left-0">
            <a class="nav-link" href="#"><i class="icon-barcode"></i> <span class="d-none d-lg-inline-block">Kod kreskowy</span></a>
        </div>
        <div class="nav-item w-25">
            <a class="nav-link" href="#"><i class="icon-cart-arrow-down"></i> <span class="d-none d-lg-inline-block">Pomocnik zakupowy</span></a>
        </div>
        <div class="nav-item w-25">
            <a class="nav-link" href="#"><i class="icon-search"></i> <span class="d-none d-lg-inline-block">Wyszukiwarka Allegro</span></a>
        </div>
        <div class="nav-item w-25">
            <a class="nav-link" href="/allegro-categories?parent=0"><i class="icon-tags"></i> <span class="d-none d-lg-inline-block">Kategorie Allegro</span></a>
        </div>
    </div>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <div class="col-12 text-center"><h4>Kategorie Allegro</h4></div>
            <div class="col-12">
                <c:choose>
                    <c:when test="${empty mainCat}">
                        Kategorie główne:
                    </c:when>
                    <c:otherwise>
                        <a href="/allegro-categories?parent=0">Kategorie główne</a>
                        <c:forEach var="breadCrumb" items="${breadCrumbs}">
                            <a href="/allegro-categories?parent=${breadCrumb.catId}">> ${breadCrumb.catName}</a>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${not empty list}">
                        <c:forEach var="category" items="${list}">
                            <div class="row justify-content-start">
                                <a href="/allegro-categories?parent=${category.key.catId}" class="col-4 px-0">
                                    <div class="py-2 text-center" style="border: 1px white;border-top-style: dotted;">
                                        <c:out value="${category.key.catPosition+1}"/>. <c:out value="${category.key.catName}"/><br/>
                                    </div>
                                </a>
                                <a href="${category.value}">
                                    <div class="px-3 py-2 text-center" style="border: 1px white;border-top-style: dotted;">
                                        Przejdź do kategorii w serwisie Allegro
                                    </div>
                                </a>
                            </div>

                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <a href="${lastCatLink}" class="col-4 px-0">
                            <div class="py-3" style="border: 1px white;border-top-style: dotted;">
                                Przejdź do serwisu Allegro
                            </div>
                        </a>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>
