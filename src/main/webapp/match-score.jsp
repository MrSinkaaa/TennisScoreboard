<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <span class="player-name">PLAYER 1</span>
                <span class="serving"></span>
                <span class="score-p1" onclick="addPoints()">30</span>
                <div class="sets">
                    <span class="set">2</span>
                    <span class="set">4</span>
                    <span class="set">1</span>
                </div>
            </div>
            <div class="descriptions">
                <span class="player-name">players</span>
                <div>SERVING</div>
                <div>GAME</div>
                <div class="sets">
                    <span class="description-set">set1</span>
                    <span class="description-set">set2</span>
                    <span class="description-set">set3</span>
                </div>
            </div>
            <div class="player player2">
                <span class="player-name">PLAYER 2</span>
                <span class="serving"></span>
                <span class="score-p2" onclick="addPoints()">15</span>
                <div class="sets">
                    <span class="set">1</span>
                    <span class="set">5</span>
                    <span class="set">3</span>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    const addPoints = (selector) => {
        let score = document.querySelector(selector);
        score.innerHTML += 15;
    }
</script>
</body>
</html>
