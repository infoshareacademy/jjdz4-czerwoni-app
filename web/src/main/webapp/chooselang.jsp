<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="what" var="WDYWlanguage"/>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>



<input type="button" class="buttonPL"  name="language" id="lang_ButtonPL" alt="pl_PL" onclick="updateLanguage('pl_PL')">
<input type="button" class="buttonGB"  name="buttonEN" id="lang_ButtonGB"  alt="en_GB" onclick="updateLanguage('en_GB')">

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

    }
</script>