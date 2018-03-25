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

<input type="button"  name="language" id="lang_ButtonPL" value="pl_PL" onclick="updateLanguage('pl_PL')">
<input type="button"  name="language" id="lang_ButtonEN" value="en_GB" onclick="updateLanguage('en_GB')">

<script>
    function updateLanguage(lang) {
        console.log("updateLanguage");
        if (window.location.search.indexOf("language="+ lang) !== -1) {
        }
        else if (window.location.search.indexOf("language") === -1) {
            window.location.search += '&language=' + lang;
        } else {
            window.location.search = window.location.search.replace(
                "language=" + '<c:out value="${language}"/>',
                'language=' + lang
            );
        }
//        document.location.reload(true);
    }
</script>