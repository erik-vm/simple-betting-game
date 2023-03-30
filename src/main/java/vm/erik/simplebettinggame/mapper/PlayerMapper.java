package vm.erik.simplebettinggame.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.model.Player;

/**
 * @author Erik Vainumäe
 * Date: 27/03/2023
 * Time: 22:51
 */

@Service
public class PlayerMapper {

    public PlayerDTO fromPlayerToDTO(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        BeanUtils.copyProperties(player, playerDTO);
        return playerDTO;
    }

    public Player fromDTOToPlayer(PlayerDTO playerDTO){
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);
        return player;
    }
}
