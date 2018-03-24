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
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id"
          content="830889560506-bfd7gjnpsj4o3ss6n24f2pis4dscu4u9.apps.googleusercontent.com">
</head>
<body class="bg-dark">
<div class="container">
    <%@include file="header.jsp"%>
    <%@include file="links.jsp"%>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3">
            <form method="post">
                <div class="questionForm">
                    <label>Treść pytania: </label><br/><input size="80" name="questionName" type="text"
                                                              value="${sessionScope.question.questionName}"/> <br/><br/>
                    <label>Poziom pytania: </label><br/><input size="20" name="questionLevel" type="text"
                                                               value="${sessionScope.question.questionLevel}"/>
                    <div class="errorMessage">${NFErrorMessage}</div>
                    <br/>
                </div>
                <div class="questionForm">
                    <label>Odpowiedź nadrzędna:<span
                            id="annswerName"> ${sessionScope.relatedAnswer.answerName}</span></label><br/><br/>

                    <label>Wybierz nową odpowiedź nadrzędną: </label>
                    <select name="answer">
                        <option value="wybierz odpowiedź">Wybierz odpowiedź</option>
                        <c:forEach var="list" items="${sessionScope.answersWithoutRelQuestList}">
                            <option value="${list.answerId}">${list.answerName}</option>
                        </c:forEach>
                    </select><br/><br/>
                </div>
                <c:forEach var="answerList" items="${sessionScope.question.answerList}">
                    <div class="questionForm">
                        <label>Odpowiedź: <input type="radio" name="questRadio" value="${answerList.answerId}"/>
                        </label><br/><input size="80" name="answerName" type="text"
                                            value="${answerList.answerName}"/><br/><br/>
                        <label>Kategoria: </label><br/><input size="40" name="categoryName" type="text"
                                                              value="${answerList.relatedCategory.categoryName}"/><br/><br/>
                        <label>Link Allegro: </label><br/><input size="60" name="categoryAllegroLink" type="text"
                                                                 value="${answerList.relatedCategory.categoryName}"/><br/><br/>
                    </div>
                </c:forEach>
                <div class="row">
                    <div class="col-lg-3">
                        <button class="button" type="submit" formaction="" name="edit-button" value="save-changes">
                            Zapisz zmiany
                        </button>
                    </div>
                    <div class="col-lg-3">
                        <button class="button" type="submit" formaction="" name="edit-button" value="remove-answer">Usuń
                            zaznaczoną odpowiedź
                        </button>
                    </div>
                    <div class="col-lg-3">
                        <button class="button" type="submit" formaction="" name="edit-button" value="add-next-answer">
                            Dodaj kolejną odpowiedź
                        </button>
                    </div>
                    <div class="col-lg-3">
                        <button class="button" type="submit" formaction="admin-panel.jsp" name="edit-button"
                                value="back">Anuluj
                        </button>
                    </div>
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