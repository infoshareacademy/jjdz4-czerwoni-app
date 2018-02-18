<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


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
    <%@include file="header.jsp" %>
    <%@include file="links.jsp" %>
    <div>
        <div class="row mt-3 pl-2 pr-2 pt-3 border border-secondary">
            <form class="questionForm" method="post" action="add-user">
                <fieldset>
                    <label>Login: </label><br/><input size="50" name="login" type="text" minlength="3" required/>
                    <br/><br/>
                    <label>Hasło: </label><br/><input size="50" name="password" id="password" type="password"
                                                      pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                                                      title="Password must contain at least 6 characters, including UPPER/lowercase and numbers."
                                                      required/>
                    <br/><br/>
                    <label>Powtórz hasło: </label><br/><input size="40" name="confirm_password" id="confirm_password"
                                                              type="password" required/>
                    <br/><br/>
                    <label>Imię: </label><br/><input size="40" name="name" type="text" minlength="3"/> <br/><br/>
                    <label>Nazwisko: </label><br/><input size="40" name="surname" type="text" minlength="3"/> <br/><br/>
                    <label>E-mail: </label><br/><input size="50" name="email" type="email" required/> <br/><br/>

                    <div class="errorMessage">${NFErrorMessage}</div>
                    <br/>
                    <label>Wybierz rolę: </label><br/>
                    <select name="roles" required>
                        <option value="">Wybierz rolę</option>
                        <c:forEach var="list" items="${rolesList}">
                            <option value="${list}">${list}</option>
                        </c:forEach>
                    </select><br/><br/>
                    <input class="button" type="submit" name="add-user" value="Zapisz"/>
                </fieldset>
            </form>
            <script>
                var password = document.getElementById("password")
                    , confirm_password = document.getElementById("confirm_password");

                function validatePassword() {
                    if (password.value != confirm_password.value) {
                        confirm_password.setCustomValidity("Hasła nie są zgodne");
                    } else {
                        confirm_password.setCustomValidity('');
                    }
                }

                password.onchange = validatePassword;
                confirm_password.onkeyup = validatePassword;
            </script>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>