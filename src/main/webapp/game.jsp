<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= request.getAttribute("question") %></h1><br>

<form action="start_game" method="get">
    <label>
        <input type="radio" name="answer" value="firstAnswer">
        <%= request.getAttribute("firstAnswer") %>
    </label><br>
    <label>
        <input type="radio" name="answer" value="secondAnswer">
        <%= request.getAttribute("secondAnswer")%><br>
        <input type="submit" value="Отправить">
    </label><br>
</form>

<div>
    <h2>Статистика:</h2>
    <p>IP Address: <%= request.getAttribute("ip")%></p>
    <p>Имя в игре: <%= request.getAttribute("name")%></p>
    <p>Количество игр: <%= request.getAttribute("counter")%></p>

</div>

</body>
</html>