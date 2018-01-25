<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>What do you want?</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/fontello/css/fontello.css" type="text/css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</head>
<body class="bg-dark">
<div class="container">
    <div class="row">
        <div class="col">
            <a href="index.jsp"><h1>
                <i class="icon-shopping-basket"></i> <span class="d-none d-lg-inline-block">What Do You Want</span>
            </h1></a>
        </div>
        <div class="col text-lg-right text-sm-center text-md-right text-center">
            <div class="dropdown">
                <button class="btn btn-dark dropdown-toggle bg-dark m-3" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                            <input type="password" class="form-control" id="exampleDropdownFormPassword1"
                                   name="password" placeholder="Password">
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
            <c:if test="${sessionScope.login!=null}">
                <div class="col logtext">
                    Zalogowano: <a href="admin-panel.jsp"> ${sessionScope.login}</a>
                    <a href="logout"><span>Wyloguj</span></a>
                </div>
            </c:if>
        </div>
    </div>
    <div class="row nav nav-pills nav-fill">
        <div class="nav-item w-25 border-left-0">
            <a class="nav-link" href="#"><i class="icon-barcode"></i> <span class="d-none d-lg-inline-block">Kod kreskowy</span></a>
        </div>
        <div class="nav-item w-25">
            <a title="Odpowiedz na kilka pytań aby wybrać najlepszą kategorię produktów" class="nav-link"
               href="questions"><i class="icon-cart-arrow-down"></i> <span class="d-none d-lg-inline-block">Pomocnik zakupowy</span></a>
        </div>
        <div class="nav-item w-25">
            <a class="nav-link" href="#"><i class="icon-search"></i> <span class="d-none d-lg-inline-block">Wyszukiwarka Allegro</span></a>
        </div>
        <div class="nav-item w-25">
            <a class="nav-link" href="#"><i class="icon-tags"></i> <span class="d-none d-lg-inline-block">Kategorie Allegro</span></a>
        </div>
    </div>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <form method="post" action="add-answers">
                <div class="questionForm row">
                    <div col-lg-12 style="width: 800px">
                        <h7>Dodaj/zmień odpowiedzi do pytania:</h7>
                        <div id="categoryName">${sessionScope.question.questionName}</div><br/>
                        <div>
                            <ol type="a">
                                <c:forEach var="alist" items="${sessionScope.question.answerList}">
                                    <div class="row">
                                            <div class="col-lg-1 questRadio">
                                                <c:if test="${isUpdateAnswer==true}">
                                                    <input type="radio" name="answerRadio" value="${alist.answerId}"
                                                           formmethod="post"
                                                           formaction="add-answers">

                                                </c:if>
                                            </div>
                                            <div class="col-lg-11">
                                                <li> ${alist.answerName} Kategoria: <a
                                                        href="${alist.relatedCategory.categoryAllegroLink}">${alist.relatedCategory.categoryName}</a>
                                                </li>
                                            </div>
                                    </div>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                </div>
                <div class="questionForm row">
                    <div class="row">
                        <div class="col-lg-11">
                            <label>Odpowiedź: </label><br/><input size="80" name="answerName" type="text"
                                                                  value="${answer.answerName}"/><br/><br/>
                            <label>Kategoria: </label><br/><input size="40" name="categoryName" type="text"
                                                                  value="${answer.relatedCategory.categoryName}"/><br/><br/>
                            <label>Link Allegro: </label><br/><input size="60" name="categoryAllegroLink"
                                                                     type="text"
                                                                     value="${answer.relatedCategory.categoryAllegroLink}"/><br/><br/>
                        </div>
                        <div class="col-lg-1">
                            <c:if test="${isUpdateAnswer==true}">
                                <input class="button" type="submit" name="edit-answer" value="Edytuj">
                            </c:if>
                        </div>

                    </div>
                    <div><input class="button" type="submit" name="add-answer" value="Zapisz"></div>
                    <c:if test="${isUpdateAnswer!=true}">
                        <div><input class="button" type="submit" name="add-next-answer" value="Dodaj kolejną odpowiedź">
                        </div>
                    </c:if>
                    <c:if test="${isUpdateAnswer==true}">
                        <div><input class="button" type="submit" name="remove-answer" value="Usuń"></div>
                    </c:if>
                </div>
            </form>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>