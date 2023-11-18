<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tennis Scoreboard</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>css/index.css" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h2>Tennis Scoreboard</h2>
            </div>
            <div class="buttons">
                <button onclick="redirectToNewMatchPage()">New match</button>
                <button onclick="redirectToAllMatchesPage()">All matches</button>
            </div>
        </div>

    <script>
        const redirectToNewMatchPage = () => {
            window.location.href = "/new-match.jsp";
        }

        const redirectToAllMatchesPage = () => {
            window.location.href = "/matches";
        }
    </script>
    </body>
</html>
