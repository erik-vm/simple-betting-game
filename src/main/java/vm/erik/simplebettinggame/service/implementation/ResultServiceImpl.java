package vm.erik.simplebettinggame.service.implementation;

import org.springframework.stereotype.Service;
import vm.erik.simplebettinggame.dto.ResultDTO;
import vm.erik.simplebettinggame.mapper.ResultMapper;
import vm.erik.simplebettinggame.model.Result;
import vm.erik.simplebettinggame.repository.ResultRepository;
import vm.erik.simplebettinggame.service.ResultService;

/**
 * @author Erik Vainumäe
 * Date: 30/03/2023
 * Time: 00:02
 */

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;

    public ResultServiceImpl(ResultRepository resultRepository, ResultMapper resultMapper) {
        this.resultRepository = resultRepository;
        this.resultMapper = resultMapper;
    }

    @Override
    public ResultDTO saveResult(Result result) {
        Result resultToSave = resultRepository.save(result);
        return resultMapper.fromResultToDTO(resultToSave);
    }
}
