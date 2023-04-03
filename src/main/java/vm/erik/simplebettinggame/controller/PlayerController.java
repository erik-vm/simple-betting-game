package vm.erik.simplebettinggame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.service.PlayerService;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 22:46
 */

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public PlayerDTO savePlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.saveNewPlayer(playerDTO);
    }
}
