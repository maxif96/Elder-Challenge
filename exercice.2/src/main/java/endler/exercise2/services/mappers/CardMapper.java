package endler.exercise2.services.mappers;

import endler.exercise2.dto.request.CardRequestDTO;
import endler.exercise2.dto.response.CardResponseDTO;
import endler.exercise2.enumerations.Brand;
import endler.exercise2.models.Card;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CardMapper {


    public Card requestDTOToEntity(CardRequestDTO cardRequestDTO) {

        return Card.builder()
                .cardHolder(cardRequestDTO.getCardHolder())
                .cardNumber(cardRequestDTO.getCardNumber())
                .brand(Brand.valueOf(cardRequestDTO.getBrand().toUpperCase()))
                .expirationDate(cardRequestDTO.getExpirationDate())
                .build();

    }

    public CardResponseDTO entityToResponseDTO(Card entity) {

        return CardResponseDTO.builder()
                .id(entity.getId())
                .cardHolder(entity.getCardHolder())
                .cardNumber(entity.getCardNumber())
                .brand(entity.getBrand().name())
                .expirationDate(entity.getExpirationDate())
                .build();

    }
}
