<%--
  Created by IntelliJ IDEA.
  User: mesk
  Date: 06.06.2024
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>End of game</title>
</head>
<body>
<h1><%= request.getAttribute("title")%></h1><br>
<h2><%= request.getAttribute("msg")%></h2>

<form action="start_game" method="get">
    <input type="submit" id="reloadButton" name="reloadGame" value="Начать заного">
</form>

</body>
</html>
