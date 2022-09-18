package endler.exercise2.services.impl;

import endler.exercise2.dto.request.CardRequestDTO;
import endler.exercise2.dto.response.CardResponseDTO;
import endler.exercise2.enumerations.Brand;
import endler.exercise2.exceptions.BrandDoesNotExistException;
import endler.exercise2.exceptions.CardAlreadyExists;
import endler.exercise2.exceptions.InvalidCardNumberException;
import endler.exercise2.models.Card;
import endler.exercise2.repositories.CardRepository;
import endler.exercise2.services.CardService;
import endler.exercise2.services.mappers.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Transactional
    public CardResponseDTO save(CardRequestDTO cardRequestDTO) {
        validations(cardRequestDTO);
        System.out.println(cardRepository.existsByCardNumber(cardRequestDTO.getCardNumber()));
        Card cardToSave =  cardMapper.requestDTOToEntity(cardRequestDTO);

        return cardMapper.entityToResponseDTO(cardRepository.save(cardToSave));

    }

    @Override
    public CardResponseDTO update(Long id, CardRequestDTO operationRequestDTO) {
        return null;
    }

    @Override
    public CardResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    public void validations(CardRequestDTO cardRequestDTO){
        boolean existsBrand = false;
        for (Brand brand: Brand.values()) {
            if (cardRequestDTO.getBrand().equalsIgnoreCase(brand.name())){existsBrand = true; break;}
        }
        if (!existsBrand) throw new BrandDoesNotExistException("La marca de la tarjeta de crédito no está registrada en nuestra base de datos.");
        if (String.valueOf(cardRequestDTO.getCardNumber()).length() < 10) throw new InvalidCardNumberException("El número de la tarjeta de crédito debe tener más de 10 dígitos.");
        if (cardRepository.existsByCardNumber(cardRequestDTO.getCardNumber())) throw new CardAlreadyExists("Una tarjeta con ese número de tarjeta ya se encuentra registrada.");
    }
}
