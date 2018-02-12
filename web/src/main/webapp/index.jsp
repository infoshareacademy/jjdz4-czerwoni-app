<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
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
            <h3>Witamy w aplikacji What Do You Want</h3>
            Aplikacja została stworzona na potrzeby projektu grupowego, w ramach kursu Junior Java Developer.<br/>
            Co możesz zrobić za pomocą naszej aplikacji:
            <ul>
                <li>Rozpoznasz produkt po kodzie kreskowym</li>
                <li>Pomożemy Ci znaleźć idealny produkt</li>
                <li>Szybko wyszukasz interesującą Cię kategorię Allegro</li>
                <li>Szybko przejrzysz kategorie Allegro</li>
            </ul>
            <div>

                <div><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Zaloguj</button></div>

                <!-- Modal -->
                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div id="login-modal" class="modal-content">
                            <div class="modal-header">
                                <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                                <h4 class="modal-title">WDYW Logowanie</h4>
                            </div>
                            <div class="modal-body">
                                <form method="post" action="login">
                                    <div class="form-group">
                                        <label for="login">Login:</label>
                                        <input type="text" class="form-control" id="login" minlength="3" name="login">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Hasło:</label>
                                        <input type="password" class="form-control" id="password" minlength="3" name="password">
                                    </div>
                                    <button type="submit" class="btn btn-default">Zaloguj</button>
                                    <br/>
                                    <div class="questRadio">
                                    <p>Jeżeli nie masz konta to <span style="text-decoration: underline"><a href="add-user.jsp"> ZAREJESTRUJ SIĘ</a></span> </br>
                                        lub zaloguj się po przez konto Google</p><br/>
                                    </div>
                                    <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                                    <img id="myImg"><br>
                                    <p id="name"></p>
                                    <div id="status"></div>
                                    <%--<button class="button" onclick="logoutGoogle()">Wyloguj google</button>--%>
                                    <div id="logoutGoogleButton"></div>
                                </form>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>

                <script type="text/javascript">
                    $(window).on('load',function(){
                        $('#myModal').modal('show');
                    });
                </script>

                <script type="text/javascript">
                    function onSignIn(googleUser) {
                        var profile = googleUser.getBasicProfile();
                        var imagurl = profile.getImageUrl();
                        var name = profile.getName();
                        var email = profile.getEmail();
                        document.getElementById("myImg").src = imagurl;
                        document.getElementById("name").innerHTML = name;
                        document.getElementById("myP").style.visibility = "hidden";
                        document.getElementById("status").innerHTML = 'Witaj ' + name + '!<a href=google-user?email=' + email + '&name=' + name + '/> Start przy użyciu konta Google</a></p>'
//                        document.getElementById("status").innerHTML = 'Witaj ' + name + '!<a href=index.jsp?email=' + email + '&name=' + name + '/> Start przy użyciu konta Google</a></p>'
                        document.getElementById("logoutGoogleButton").innerHTML =  '<button class="button" onclick="logoutGoogle()">Wyloguj google</button>'
                    }
                </script>

                <script>
                    function logoutGoogle() {
                        gapi.auth2.getAuthInstance().disconnect();
                        location.reload();
                        document.getElementById("logoutGoogleButton").innerHTML =''
                    }
                </script>
            </div>
        </div>
        <div class="row m-0">
            <span class="mx-auto p-2">&#169 infoShare Academy</span>
        </div>
    </div>
</div>
</body>
</html>
