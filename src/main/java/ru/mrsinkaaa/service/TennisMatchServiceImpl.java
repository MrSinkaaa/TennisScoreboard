package ru.mrsinkaaa.service;

import ru.mrsinkaaa.dto.PlayerDTO;


public class TennisMatchServiceImpl implements TennisMatchService {

    private final PlayerDTO player1;
    private final PlayerDTO player2;
    private int currentSetNumber;

    public TennisMatchServiceImpl(PlayerDTO player1, PlayerDTO player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentSetNumber = 0;
    }


    @Override
    public void pointWonBy(PlayerDTO player) {
        switch (player.getCurrentScore()) {
            case 30 -> player.setCurrentScore(player.getCurrentScore() + 10);
            case 40 -> {
                int setScore = 0;
                if(!player.getSetScores().isEmpty()) {
                    setScore = player.getSetScores().get(currentSetNumber);
                }
                player.getSetScores().add(currentSetNumber, setScore + 1);

                player1.setCurrentScore(0);
                player2.setCurrentScore(0);
            }
            default -> player.setCurrentScore(player.getCurrentScore() + 15);
        }
    }


}
