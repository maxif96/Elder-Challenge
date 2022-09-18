package endler.exercise2.services;

import endler.exercise2.dto.request.OperationRequestDTO;
import endler.exercise2.dto.response.OperationResponseDTO;
import endler.exercise2.exceptions.AmountInvalidException;
import endler.exercise2.exceptions.ExpiredCardException;

public interface OperationService {

    OperationResponseDTO save(OperationRequestDTO operationRequestDTO) throws AmountInvalidException, ExpiredCardException;
    OperationResponseDTO update(Long id, OperationRequestDTO operationRequestDTO);
    OperationResponseDTO getById(Long id);
    String delete(Long id);

}
