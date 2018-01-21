<%--
  Created by IntelliJ IDEA.
  User: mmil
  Date: 14.01.18
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przesyłanie plików</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="POST" action="/FileUpload" enctype="multipart/form-data">
    Plik:
    <input type="file" name="file" id="file"/> <br/>
    Lokalizacja docelowa:
    <input type="text" value="/tmp" name="destination"/>
    </br>
    <input type="submit" value="Prześlij plik" name="upload" id="upload"/>
</form>
</body>
</html>
