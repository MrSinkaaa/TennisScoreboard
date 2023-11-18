package ru.mrsinkaaa.service;

import ru.mrsinkaaa.dto.PlayerDTO;
import ru.mrsinkaaa.dto.ScoreDTO;

public interface TennisMatchService {

    void pointWonBy(PlayerDTO player);
    ScoreDTO score();
}
