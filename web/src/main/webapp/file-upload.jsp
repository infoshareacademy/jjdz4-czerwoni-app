<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <title>Przesyłanie pliku z kodem kreskowym</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="bg-dark">
<div class="container">
    <br><h5>Wskaż plik z kodem kreskowym produktu</h5><br>
<form method="POST" action="/FileUpload" enctype="multipart/form-data">
    Plik:
    <input type="file" name="file" id="file"/> <br>
    <!--    Lokalizacja docelowa:
        <input type="text" value="/tmp" name="destination"/>
        </br>  -->
    <input type="submit" value="Prześlij plik" name="upload" id="upload"/>
</form>
</div>
<%@ include file="go-back.jsp" %>
</body>
</html>
