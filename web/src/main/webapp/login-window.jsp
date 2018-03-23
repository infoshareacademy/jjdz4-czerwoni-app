<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="what" var="WDYWlanguage" scope="session"/>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div id="login-modal" class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><span><fmt:message key="loginWindow.info" bundle="${WDYWlanguage}"/></span></h4>
            </div>
            <div class="modal-body">
                <form method="post" action="login">
                    <div class="form-group">
                        <label for="login"><fmt:message key="loginWindow.login" bundle="${WDYWlanguage}"/></label>
                        <input type="text" class="form-control" id="login" minlength="3" name="login">
                    </div>
                    <div class="form-group">
                        <label for="password"><fmt:message key="loginWindow.password" bundle="${WDYWlanguage}"/></label>
                        <input type="password" class="form-control" id="password" minlength="3"
                               name="password">
                    </div>
                    <button type="submit" class="btn btn-default"><fmt:message key="loginWindow.logIn" bundle="${WDYWlanguage}"/></button>
                    <br/>
                    <div class="questRadio">
                        <p><fmt:message key="loginWindow.else" bundle="${WDYWlanguage}"/></p><br/>
                    </div>
                    <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                    <img id="myImg"><br>
                    <p id="name"></p>
                    <div id="status"></div>
                    <div id="logoutGoogleButton"></div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="loginWindow.close" bundle="${WDYWlanguage}"/></button>
            </div>
        </div>

    </div>
</div>
<c:if test="${sessionScope.login==null}">
    <script type="text/javascript">
        $(window).on('load', function () {
            $('#myModal').modal('show');
        });
    </script>
</c:if>

<script type="text/javascript">
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        var imagurl = profile.getImageUrl();
        var name = profile.getName();
        var email = profile.getEmail();
        document.getElementById("myImg").src = imagurl;
        document.getElementById("name").innerHTML = name;
        document.getElementById("myP").style.visibility = "hidden";
        document.getElementById("status").innerHTML = 'Witaj ' + name + '!<span class="logtext"><a href=google-user?email=' + email + '&name=' + name + '/> Start przy użyciu konta Google</a></span></p>'
        document.getElementById("logoutGoogleButton").innerHTML = '<button class="button" onclick="logoutGoogle()">Wyloguj google</button>'
    }
</script>

<script>
    function logoutGoogle() {
        gapi.auth2.getAuthInstance().disconnect();
        location.reload();
        document.getElementById("logoutGoogleButton").innerHTML = ''
    }
</script>