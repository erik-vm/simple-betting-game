package vm.erik.simplebettinggame.service;

import org.springframework.stereotype.Service;
import vm.erik.simplebettinggame.dto.ResultDTO;
import vm.erik.simplebettinggame.model.Result;

/**
 * @author Erik Vainumäe
 * Date: 30/03/2023
 * Time: 00:01
 */

@Service
public interface ResultService {

  public ResultDTO saveResult(Result result);
}
