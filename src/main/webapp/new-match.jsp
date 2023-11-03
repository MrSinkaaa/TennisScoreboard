<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tennis Scoreboard</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/new-match.css" type="text/css">
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Tennis Scoreboard</h2>
    </div>
    <div class="form-match">
        <label for="player1">Player 1</label>
        <input type="text" id="player1">

        <label for="player2">Player 2</label>
        <input type="text" id="player2">

        <button>start match</button>
    </div>
</div>
</body>
</html>
