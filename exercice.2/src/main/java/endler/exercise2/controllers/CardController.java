package endler.exercise2.controllers;

import endler.exercise2.dto.request.CardRequestDTO;
import endler.exercise2.dto.response.CardResponseDTO;
import endler.exercise2.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponseDTO> save (@Valid @RequestBody CardRequestDTO cardRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cardService.save(cardRequestDTO));
    }


}
