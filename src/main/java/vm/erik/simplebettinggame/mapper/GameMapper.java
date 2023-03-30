package vm.erik.simplebettinggame.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vm.erik.simplebettinggame.dto.GameDTO;
import vm.erik.simplebettinggame.model.Game;

/**
 * @author Erik Vainumäe
 * Date: 27/03/2023
 * Time: 22:55
 */

@Service
public class GameMapper {

    private final PlayerMapper playerMapper;
    private final ResultMapper resultMapper;

    public GameMapper(PlayerMapper playerMapper, ResultMapper resultMapper) {
        this.playerMapper = playerMapper;
        this.resultMapper = resultMapper;
    }

    public GameDTO fromGameToDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setPlayer(playerMapper.fromPlayerToDTO(game.getPlayer()));
        gameDTO.setResult(resultMapper.fromResultToDTO(game.getResult()));
        return gameDTO;
    }

    public Game fromDTOToGame(GameDTO gameDTO) {
        Game game = new Game();
        BeanUtils.copyProperties(gameDTO, game);
        game.setPlayer(playerMapper.fromDTOToPlayer(gameDTO.getPlayer()));
        game.setResult(resultMapper.fromDTOToResult(gameDTO.getResult()));
        return game;
    }
}
