package ru.mrsinkaaa.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mrsinkaaa.dto.PlayerDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisMatchServiceTest {

    TennisMatchServiceImpl tennisMatchService;
    PlayerDTO server;
    PlayerDTO client;

    @BeforeEach
    void setUp() {
        server = new PlayerDTO(1, "server");
        client = new PlayerDTO(2, "client");
        tennisMatchService = new TennisMatchServiceImpl(server, client);
    }

    @Test
    void shouldScore15_0AfterFirstPointWonByFirstPlayer() {

        tennisMatchService.pointWonBy(server);

//        assertEquals("15-0", tennisMatchService.score());
    }

    @Test
    void shouldScoreDeuceAfterBothPlayerWin3Points() {
        tennisMatchService.pointWonBy(server);
        tennisMatchService.pointWonBy(server);
        tennisMatchService.pointWonBy(server);

        tennisMatchService.pointWonBy(client);
        tennisMatchService.pointWonBy(client);
        tennisMatchService.pointWonBy(client);

//        assertEquals("Deuce", tennisMatchService.score());
    }

    @Test
    void shouldWinGameAfterScoring40_30() {
        tennisMatchService.pointWonBy(server);
        tennisMatchService.pointWonBy(server);
        tennisMatchService.pointWonBy(server);

        tennisMatchService.pointWonBy(client);
        tennisMatchService.pointWonBy(client);
        tennisMatchService.pointWonBy(client);

        tennisMatchService.pointWonBy(server);

        assertEquals(1, server.getSetScores().get(0));
    }

    @Test
    void shouldGainAdvantageAfterDeuce() {

    }

    @Test
    void shouldWinGameAfterAdvantage() {

    }

    @Test
    void shouldWinSetAfter6GamesTo4() {

    }

    @Test
    void shouldStartTiebreakAt6_6() {

    }

    @Test
    void shouldChangePlayerEveryTwoPointsInTiebreak() {

    }

    @Test
    void shouldWinMatchAfterWinningRequiredNumberOfSets() {

    }

}
