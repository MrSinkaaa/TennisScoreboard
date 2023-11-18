package ru.mrsinkaaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "id")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private Player winner;

    public Match(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }
}
