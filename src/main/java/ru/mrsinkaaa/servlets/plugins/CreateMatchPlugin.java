package ru.mrsinkaaa.servlets.plugins;


import jakarta.persistence.NoResultException;
import ru.mrsinkaaa.dto.MatchDTO;
import ru.mrsinkaaa.dto.PlayerDTO;
import ru.mrsinkaaa.entity.Player;
import ru.mrsinkaaa.exceptions.player.PlayerNotFoundException;
import ru.mrsinkaaa.repository.PlayerRepository;
import ru.mrsinkaaa.service.PlayerService;
import ru.mrsinkaaa.servlets.ServletPlugin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static ru.mrsinkaaa.servlets.CentralServlet.matches;

public class CreateMatchPlugin implements ServletPlugin {

    private final PlayerService playerService = PlayerService.getInstance();


    @Override
    public boolean canHandle(String path) {
        return path.startsWith("/new-match");
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerName1 = request.getParameter("player1");
        String playerName2 = request.getParameter("player2");

        PlayerDTO p1;
        PlayerDTO p2;
        try {
            p1 = playerService.findByName(playerName1);

        } catch (PlayerNotFoundException e) {
                p1 = PlayerDTO.builder()
                        .name(playerName1)
                        .build();

//            playerService.save(p1);
        }

        try {
            p2 = playerService.findByName(playerName2);
        } catch (PlayerNotFoundException e) {
            p2 = PlayerDTO.builder()
                            .name(playerName2)
                            .build();

//            playerService.save(p2);
        }



        MatchDTO match = new MatchDTO(p1, p2);

        UUID uuid = UUID.randomUUID();
        matches.put(uuid, match);

        response.sendRedirect("/match-score?uuid=" + uuid);
    }
}
