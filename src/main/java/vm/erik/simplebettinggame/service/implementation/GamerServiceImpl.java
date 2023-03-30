package vm.erik.simplebettinggame.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.simplebettinggame.dto.ResultDTO;
import vm.erik.simplebettinggame.exception.InvalidNumberException;
import vm.erik.simplebettinggame.mapper.ResultMapper;
import vm.erik.simplebettinggame.model.Game;
import vm.erik.simplebettinggame.model.Player;
import vm.erik.simplebettinggame.model.Result;
import vm.erik.simplebettinggame.repository.GameRepository;
import vm.erik.simplebettinggame.service.GameService;
import vm.erik.simplebettinggame.service.PlayerService;
import vm.erik.simplebettinggame.service.ResultService;

import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 21:09
 */

@Service
@Transactional
public class GamerServiceImpl implements GameService {

    private final PlayerService playerService;
    private final GameRepository gameRepository;
    private final ResultService resultService;
    private final ResultMapper resultMapper;

    public GamerServiceImpl(PlayerService playerService, GameRepository gameRepository, ResultService resultService, ResultMapper resultMapper) {
        this.playerService = playerService;
        this.gameRepository = gameRepository;
        this.resultService = resultService;
        this.resultMapper = resultMapper;
    }

    @Override
    public void saveNewGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    public ResultDTO playGame(UUID playerId, double bet, int playerNumber) {
        Player player = playerService.loadPlayerById(playerId);
        checkPlayerNumber(playerNumber);
        int gameNumber = getGameRandomNumber();

        Result result = newResult(bet, playerNumber, gameNumber);

        Game game = newGame(player, result);

        gameRepository.save(game);
        resultService.saveResult(result);

        return resultMapper.fromResultToDTO(result);
    }


    private void checkPlayerNumber(int chosenNumber) {
        if (chosenNumber < 1 || chosenNumber > 100) {
            throw new InvalidNumberException();
        }
    }

    private double getPrizeMoney(double bet, int chosenNumber) {
        if (chosenNumber == 100){
            return bet;
        }
      //  return bet * (99.0 / (100 - chosenNumber));
        return bet * (100.0 / chosenNumber);
    }

    private int getGameRandomNumber() {
        return (int) (Math.random() * 100 + 1);
    }

    private boolean didPlayerWin(int playerNumber, int gameNumber) {
        return playerNumber >= gameNumber;
    }

    private Result newResult(double bet, int playerNumber, int gameNumber) {
        Result result = new Result();
        result.setBet(bet);
        result.setPlayerNumber(playerNumber);
        result.setGameNumber(gameNumber);


        if (didPlayerWin(playerNumber, gameNumber)) {
            result.setPlayerWon(true);
            result.setPrizeMoney(getPrizeMoney(bet, playerNumber));
        } else {
            result.setPlayerWon(false);
            result.setPrizeMoney(0);
        }

        return result;
    }

    private Game newGame(Player player, Result result) {
        Game game = new Game();
        game.setPlayer(player);
        game.setResult(result);
        return game;
    }
}
