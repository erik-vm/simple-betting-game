package vm.erik.simplebettinggame.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 21:12
 */

public class PlayerNotFoundException extends EntityNotFoundException {

   public PlayerNotFoundException(UUID playerId){
       super(String.format("Player with id: %s was not found!", playerId));
   }
}
