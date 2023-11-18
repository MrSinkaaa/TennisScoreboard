package ru.mrsinkaaa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MatchDTO {

    private PlayerDTO player1;
    private PlayerDTO player2;
    private PlayerDTO winnerId;

    public MatchDTO(PlayerDTO player1, PlayerDTO player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
