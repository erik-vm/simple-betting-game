package vm.erik.simplebettinggame.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vm.erik.simplebettinggame.dto.ResultDTO;
import vm.erik.simplebettinggame.service.GameService;

import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 22:46
 */

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PutMapping("/play/{playerId}/{bet}/{playerNumber}")
    public ResultDTO playGame(@PathVariable("playerId") UUID playerID,
                              @PathVariable("bet") double bet,
                              @PathVariable("playerNumber") int playerNumber) {
        return gameService.playGame(playerID, bet, playerNumber);
    }
}
