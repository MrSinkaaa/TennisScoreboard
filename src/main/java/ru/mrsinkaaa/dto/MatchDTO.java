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

}
