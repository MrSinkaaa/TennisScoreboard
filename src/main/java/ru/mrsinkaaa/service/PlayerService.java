package ru.mrsinkaaa.service;

import ru.mrsinkaaa.dto.PlayerDTO;
import ru.mrsinkaaa.exceptions.player.PlayerNotFoundException;
import ru.mrsinkaaa.repository.PlayerRepository;

public class PlayerService {

    private static final PlayerService INSTANCE = new PlayerService();
    private final PlayerRepository playerRepository = PlayerRepository.getInstance();

    private PlayerService() {
    }

    public PlayerDTO findById(Integer id) {
        return playerRepository.findById(id).map(player ->
                PlayerDTO.builder()
                        .id(player.getId())
                        .name(player.getName())
                        .build())
                .orElseThrow(PlayerNotFoundException::new);
    }

    public PlayerDTO findByName(String name) {
        return playerRepository.findByName(name).map(player ->
                        PlayerDTO.builder()
                                .id(player.getId())
                                .name(player.getName())
                                .build())
                .orElseThrow(PlayerNotFoundException::new);
    }

    public static PlayerService getInstance() {
        return INSTANCE;
    }
}
