package vm.erik.simplebettinggame.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.service.PlayerService;

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
    public PlayerDTO savePlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.saveNewPlayer(playerDTO);
    }
}
