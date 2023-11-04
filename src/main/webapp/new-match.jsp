<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tennis Scoreboard</title>
<%--    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/new-match.css" type="text/css">--%>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Tennis Scoreboard</h2>
    </div>
    <form class="form-match" method="post" action="<%= request.getContextPath() %>new-match">
        <label for="player1">Player 1</label>
        <input type="text" id="player1" name="player1">

        <label for="player2">Player 2</label>
        <input type="text" id="player2" name="player2">

        <input type="submit" value="start match">
    </form>
</div>
</body>
</html>
