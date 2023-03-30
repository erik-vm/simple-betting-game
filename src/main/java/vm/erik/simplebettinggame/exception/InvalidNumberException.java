package vm.erik.simplebettinggame.exception;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 22:17
 */

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException(){
        super("Entered number has to be between 1-100");
    }
}
