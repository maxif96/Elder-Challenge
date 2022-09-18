package endler.exercise2.services;

import endler.exercise2.dto.request.CardRequestDTO;
import endler.exercise2.dto.response.CardResponseDTO;

public interface CardService {

    CardResponseDTO save(CardRequestDTO cardRequestDTO);
    CardResponseDTO update(Long id, CardRequestDTO operationRequestDTO);
    CardResponseDTO getById(Long id);
    String delete(Long id);

}
