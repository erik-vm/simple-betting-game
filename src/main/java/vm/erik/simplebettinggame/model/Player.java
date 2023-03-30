package vm.erik.simplebettinggame.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 27/03/2023
 * Time: 22:29
 */

@Entity
@Table
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "player_id", nullable = false)
    private UUID playerId;
    @Column(name = "player_name", nullable = false)
    private String playerName;
    @OneToMany(mappedBy = "player")
    List<Game> games = new ArrayList<>();
}
