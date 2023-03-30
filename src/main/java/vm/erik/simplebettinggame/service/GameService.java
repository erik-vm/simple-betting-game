package vm.erik.simplebettinggame.service;

import vm.erik.simplebettinggame.dto.ResultDTO;
import vm.erik.simplebettinggame.model.Game;

import java.util.UUID;

public interface GameService {

    public void saveNewGame(Game game);

    public ResultDTO playGame(UUID playerId, double bet, int chosenNumber);

}
