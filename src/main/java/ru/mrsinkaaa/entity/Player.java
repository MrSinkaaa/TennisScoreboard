package ru.mrsinkaaa.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players", indexes = {@Index(name = "idx_player_name", columnList = "name")})
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Player(String name) {
        this.name = name;
    }
}
