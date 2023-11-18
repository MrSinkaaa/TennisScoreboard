package ru.mrsinkaaa.servlets.plugins;


import jakarta.persistence.NoResultException;
import ru.mrsinkaaa.entity.Player;
import ru.mrsinkaaa.repository.PlayerRepository;
import ru.mrsinkaaa.servlets.ServletPlugin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static ru.mrsinkaaa.servlets.CentralServlet.matches;

public class CreateMatchPlugin implements ServletPlugin {

    private final PlayerRepository playerRepository = new PlayerRepository();


    @Override
    public boolean canHandle(String path) {
        return path.startsWith("/new-match");
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerName1 = request.getParameter("player1");
        String playerName2 = request.getParameter("player2");

        Player p1;
        Player p2;
        try {
            p1 = playerRepository.findByName(playerName1);

        } catch (NoResultException e) {
                p1 = new Player(playerName1);
                playerRepository.save(p1);
        }

        try {
            p2 = playerRepository.findByName(playerName2);
        } catch (NoResultException e) {
            p2 = new Player(playerName2);
            playerRepository.save(p2);
        }



//        MatchDTO match = new MatchDTO(p1.getId(), p2.getId(), new ScoreDTO(0, 0));

        UUID uuid = UUID.randomUUID();
//        matches.put(uuid, match);

        response.sendRedirect("/match-score?uuid=" + uuid);
    }
}
