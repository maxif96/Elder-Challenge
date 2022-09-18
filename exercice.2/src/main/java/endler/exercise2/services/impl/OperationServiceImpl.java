package endler.exercise2.services.impl;



import endler.exercise2.dto.request.OperationRequestDTO;
import endler.exercise2.dto.response.OperationResponseDTO;
import endler.exercise2.exceptions.AmountInvalidException;
import endler.exercise2.exceptions.ExpiredCardException;
import endler.exercise2.models.Card;
import endler.exercise2.models.Operation;
import endler.exercise2.repositories.CardRepository;
import endler.exercise2.repositories.OperationRepository;
import endler.exercise2.services.OperationService;
import endler.exercise2.services.mappers.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private OperationMapper operationMapper;

    @Transactional
    public OperationResponseDTO save(OperationRequestDTO operationRequestDTO) throws AmountInvalidException, ExpiredCardException {
        validations(operationRequestDTO);

        Operation operationToSave = operationMapper.requestDTOToEntity(operationRequestDTO);
        return operationMapper.entityToResponseDTO(operationRepository.save(operationToSave));
    }

    @Override
    public OperationResponseDTO update(Long id, OperationRequestDTO operationRequestDTO) {
        return null;
    }

    public OperationResponseDTO getById(Long id) {
        return operationMapper
                .entityToResponseDTO(operationRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("La operación no ha sido encontrada.")));
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    public void validations(OperationRequestDTO operationRequestDTO) throws AmountInvalidException, ExpiredCardException {
        if (!isValidOperation(operationRequestDTO.getAmount())) throw new AmountInvalidException("El monto debe ser menor a 1000 y mayor a 0 para operar.");
        if (!isValidCardToOperate(cardRepository
                .findById(operationRequestDTO.getCardId())
                .orElseThrow(() -> new EntityNotFoundException("Tarjeta no encontrada.")))) throw new ExpiredCardException("La tarjeta ya ha expirado.");
    }

    public boolean isValidOperation(Double amount) {
        return amount < 1000 && amount > 0;
    }

    public boolean isValidCardToOperate(Card card) {
        return card.getExpirationDate().isAfter(LocalDate.now());
    }




}
