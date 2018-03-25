<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="what" var="WDYWlanguage"/>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<%--<form>--%>
    <%--<select id="language" name="language" onchange="updateLanguage()">--%>
        <%--<option value="en_GB" ${language == 'en_GB' ? 'selected' : ''}><img src="if_GB.png"/></option>--%>
        <%--<option value="pl_PL" ${language == 'pl_PL' ? 'selected' : ''}><img src="if_PL.png"/></option>--%>
    <%--</select>--%>
<%--</form>--%>

<input type="button" id="language" name="language" class="lang_ButtonPL" value="pl_PL" onclick="updateLanguage()">
<input type="button" id="language" name="language" class="lang_ButtonEN" value="en_GB" onclick="updateLanguage()">

<script>
    function updateLanguage() {
        console.log("updateLanguage");
        if (window.location.search.indexOf("language="+ $('#language').val()) !== -1) {
        }
        else if (window.location.search.indexOf("language") === -1) {
            window.location.search += '&language=' + $('#language').val();
        } else {
            window.location.search = window.location.search.replace(
                "language=" + '<c:out value="${language}"/>',
                'language=' + $('#language').val()
            );
        }
    }
</script>