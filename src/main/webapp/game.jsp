<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .centered-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }
        .statistics {
            position: fixed;
            bottom: 5%;
            left: 3%;
            width: 100%;
            max-width: 300px;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 10px;
            border-top-right-radius: 10px;
            box-shadow: 0 -2px 5px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
<div class="container centered-container">
    <div>
        <h1 class="mb-4"><%= request.getAttribute("question") %></h1>

        <form action="start_game" method="get" class="mb-4">
            <div class="form-check form-check-inline">
                <input type="radio" id="firstAnswer" name="answer" value="firstAnswer" class="form-check-input">
                <label for="firstAnswer" class="form-check-label">
                    <%= request.getAttribute("firstAnswer") %>
                </label>
            </div><br>
            <div class="form-check form-check-inline">
                <input type="radio" id="secondAnswer" name="answer" value="secondAnswer" class="form-check-input">
                <label for="secondAnswer" class="form-check-label">
                    <%= request.getAttribute("secondAnswer") %>
                </label>
            </div>
            <div class="mt-3">
                <input type="submit" value="Ответить" class="btn btn-primary">
            </div>
        </form>
    </div>
</div>

<div class="statistics">
    <h2>Статистика:</h2>
    <p>IP Address: <span class="fw-bold"><%= request.getAttribute("ip") %></span></p>
    <p>Имя в игре: <span class="fw-bold"><%= request.getAttribute("name") %></span></p>
    <p>Количество игр: <span class="fw-bold"><%= request.getAttribute("counter") %></span></p>
</div>
</body>
</html>