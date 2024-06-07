<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>End of game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .centered-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container centered-container">
    <div>
        <h1 class="mb-4"><%= request.getAttribute("title") %></h1>
        <h2 class="mb-4"><%= request.getAttribute("msg") %></h2>
        <form action="start_game" method="get">
            <input type="submit" id="reloadButton" name="reloadGame" value="Начать заново" class="btn btn-primary">
        </form>
    </div>
</div>
</body>
</html>

