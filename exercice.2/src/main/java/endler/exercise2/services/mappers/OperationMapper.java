package endler.exercise2.services.mappers;

import endler.exercise2.dto.request.OperationRequestDTO;
import endler.exercise2.dto.response.OperationResponseDTO;
import endler.exercise2.models.Card;
import endler.exercise2.models.Operation;
import endler.exercise2.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class OperationMapper {

    @Autowired
    private CardRepository cardRepository;

    public Operation requestDTOToEntity(OperationRequestDTO operationRequestDTO) {
        Card card = cardRepository.findById(operationRequestDTO.getCardId())
                .orElseThrow(() -> new EntityNotFoundException("Tarjeta no encontrada."));
        Double amount = operationRequestDTO.getAmount();
        Double interestRate = card.getBrand().getInterest();
        return Operation.builder()
                .card(card)
                .amount(amount)
                .interestRate(interestRate)
                .total(amount + (amount * interestRate / 100))
                .build();

    }

    public OperationResponseDTO entityToResponseDTO(Operation entity) {
        return OperationResponseDTO.builder()
                .id(entity.getId())
                .cardBrand(entity.getCard().getBrand().name())
                .amount(entity.getAmount())
                .interestRate(entity.getInterestRate())
                .total(entity.getTotal())
                .build();
    }
}
