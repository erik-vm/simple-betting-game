package vm.erik.simplebettinggame.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.exception.PlayerNotFoundException;
import vm.erik.simplebettinggame.mapper.PlayerMapper;
import vm.erik.simplebettinggame.model.Player;
import vm.erik.simplebettinggame.repository.PlayerRepository;
import vm.erik.simplebettinggame.service.PlayerService;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 21:07
 */

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO saveNewPlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.fromDTOToPlayer(playerDTO);
        playerRepository.save(player);
        return playerMapper.fromPlayerToDTO(player);
    }

    @Override
    public Player loadPlayerById(UUID playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isEmpty()) {
            throw new PlayerNotFoundException(playerId);
        }
        return playerOptional.get();
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }
}
