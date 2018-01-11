<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html>
<head>
    <title>Przesyłanie plików</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="POST" action="upload" enctype="multipart/form-data" >
    Plik:
    <input type="file" name="file" id="file" /> <br/>
    Lokalizacja docelowa:
    <input type="text" value="/tmp" name="destination"/>
    </br>
    <input type="submit" value="Prześlij plik" name="upload" id="upload" />
</form>
</body>
</html>
