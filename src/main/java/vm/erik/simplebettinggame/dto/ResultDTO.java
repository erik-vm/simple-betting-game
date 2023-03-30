package vm.erik.simplebettinggame.dto;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 23:03
 */
@Data
public class ResultDTO {

    private double bet;
    private int playerNumber;
    private int gameNumber;
    private boolean playerWon;
    private double prizeMoney;
}
