package vm.erik.simplebettinggame.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 27/03/2023
 * Time: 22:27
 */


@Entity
@Table(name = "games")
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "game_id", nullable = false)
    private UUID gameID;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;
    @OneToOne
    @JoinColumn(name = "result_id")
    private Result result;

}
