package vm.erik.simplebettinggame.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 23:01
 */

@Entity
@Table(name = "results")
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "result_id", nullable = false)
    private UUID resultId;
    @Column(name = "bet", nullable = false)
    private double bet;
    @Column(name = "player_number", nullable = false)
    private int playerNumber;
    @Column(name = "game_number", nullable = false)
    private int gameNumber;
    @Column(name = "player_won", nullable = false)
    private boolean playerWon;
    @Column(name = "prize_money", nullable = false)
    private double prizeMoney;
}
