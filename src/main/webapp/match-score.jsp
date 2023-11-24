<jsp:useBean id="match" scope="request" type="ru.mrsinkaaa.dto.MatchDTO"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tennis Scoreboard</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>css/match-score.css" type="text/css">
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Tennis Scoreboard</h2>
    </div>
    <div class="scoreboard">
        <div class="time">06:32:25</div>
        <div class="players">
            <div class="player player1">
                <span class="player-name">${match.player1.name}</span>
                <span class="serving"></span>
                <span class="score-p1">${match.player1.currentScore}</span>
                <div class="sets">
                    <span class="set">2</span>
                    <span class="set">4</span>
                    <span class="set">1</span>
                </div>
                <button onclick="addPoints('.player1.score-p1')">take points</button>
            </div>
            <div class="player player2">
                <span class="player-name">${match.player2.name}</span>
                <span class="serving"></span>
                <span class="score-p2">${match.player2.currentScore}</span>
                <div class="sets">
                    <span class="set">1</span>
                    <span class="set">5</span>
                    <span class="set">3</span>
                </div>
                <button onclick="addPoints('.player2.score-p2')">take points</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>