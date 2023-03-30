package vm.erik.simplebettinggame.service;

import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.model.Player;

import java.util.UUID;

public interface PlayerService {

    public PlayerDTO saveNewPlayer(PlayerDTO playerDTO);

    public Player loadPlayerById(UUID playerId);

    public void updatePlayer(Player player);
}
