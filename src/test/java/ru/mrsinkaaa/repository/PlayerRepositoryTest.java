package ru.mrsinkaaa.repository;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.mrsinkaaa.entity.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerRepositoryTest {

    private PlayerRepository playerRepository;
    Player player = new Player("John");

    @BeforeAll
    void createRepository() {
        playerRepository = new PlayerRepository();
    }

    @Test
    void saveToRepository() {
        playerRepository.save(player);

        assertEquals(player, playerRepository.findById(1));
        assertEquals(player, playerRepository.findByName(player.getName()));
    }

    @Test
    void findById() {
        assertEquals(player, playerRepository.findById(1));
    }

    @Test
    void findByName() {
        assertEquals(player, playerRepository.findByName(player.getName()));
    }
}
