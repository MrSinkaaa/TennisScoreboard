package ru.mrsinkaaa.servlets.plugins;

import ru.mrsinkaaa.dto.MatchDTO;
import ru.mrsinkaaa.entity.Match;
import ru.mrsinkaaa.servlets.ServletPlugin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static ru.mrsinkaaa.servlets.CentralServlet.matches;

public class MatchScorePlugin implements ServletPlugin {


    @Override
    public boolean canHandle(String path) {
        return path.startsWith("/match-score");
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID uuid = UUID.fromString(request.getParameter("uuid"));
        MatchDTO match = matches.get(uuid);

        response.sendRedirect("/match-score.jsp?uuid=" + uuid);


    }
}
