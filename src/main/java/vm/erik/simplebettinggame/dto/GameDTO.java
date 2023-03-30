package vm.erik.simplebettinggame.dto;

import lombok.Data;

/**
 * @author Erik Vainumäe
 * Date: 27/03/2023
 * Time: 22:49
 */

@Data
public class GameDTO {
    private PlayerDTO player;
    private ResultDTO result;
}
