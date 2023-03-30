package vm.erik.simplebettinggame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vm.erik.simplebettinggame.model.Game;

import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 27/03/2023
 * Time: 22:59
 */

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {
}
