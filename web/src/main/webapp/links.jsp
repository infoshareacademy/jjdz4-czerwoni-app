<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="what" var="WDYWlanguage" scope="session"/>


<div class="row nav nav-pills nav-fill">
    <div class="nav-item w-25 border-left-0">
        <a title=
           <fmt:message key="links.barcodeDetails" bundle="${WDYWlanguage}"/> class="nav-link"
           href="/file-upload.jsp"><i
                class="icon-barcode"></i> <span class="d-none d-lg-inline-block">
             <fmt:message key="links.barcode" bundle="${WDYWlanguage}"/></span></a>
    </div>
    <div class="nav-item w-25">
        <a title=
           <fmt:message key="links.helperDetails" bundle="${WDYWlanguage}"/> class="nav-link"
           href="questions"><i class="icon-cart-arrow-down"></i> <span class="d-none d-lg-inline-block">
            <fmt:message key="links.helper" bundle="${WDYWlanguage}"/> </span></a>
    </div>
    <div class="nav-item w-25">
        <a title=
           <fmt:message key="links.phraseDetails" bundle="${WDYWlanguage}"/> href="phrase-finder.jsp"><i
                class="icon-search"></i> <span class="d-none d-lg-inline-block"><fmt:message key="links.phrase"
                                                                                             bundle="${WDYWlanguage}"/></span></a>
    </div>
    <div class="nav-item w-25">
        <a title=
           <fmt:message key="links.categoriesDetails" bundle="${WDYWlanguage}"/> class="nav-link"
           href="/allegro-categories?parent=0"><i
                class="icon-tags"></i> <span class="d-none d-lg-inline-block"><fmt:message key="links.categories"
                                                                                           bundle="${WDYWlanguage}"/></span></a>
    </div>
</div>
