package vm.erik.simplebettinggame.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vm.erik.simplebettinggame.dto.ResultDTO;
import vm.erik.simplebettinggame.model.Result;

/**
 * @author Erik Vainumäe
 * Date: 29/03/2023
 * Time: 23:36
 */

@Service
public class ResultMapper {

    public Result fromDTOToResult(ResultDTO resultDTO){
        Result result = new Result();
        BeanUtils.copyProperties(resultDTO, result);
        return  result;
    }

    public ResultDTO fromResultToDTO(Result result){
        ResultDTO resultDTO = new ResultDTO();
        BeanUtils.copyProperties(result, resultDTO);
        return resultDTO;
    }
}
