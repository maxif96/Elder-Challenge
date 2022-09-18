package endler.exercise2.controllers;

import endler.exercise2.dto.request.OperationRequestDTO;
import endler.exercise2.dto.response.OperationResponseDTO;
import endler.exercise2.exceptions.AmountInvalidException;
import endler.exercise2.exceptions.ExpiredCardException;
import endler.exercise2.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping
    public ResponseEntity<OperationResponseDTO> save (@Valid @RequestBody OperationRequestDTO operationRequestDTO) throws AmountInvalidException, ExpiredCardException {
        return ResponseEntity.status(HttpStatus.CREATED).body(operationService.save(operationRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationResponseDTO> getById (@PathVariable Long id){
        return ResponseEntity.ok().body(operationService.getById(id));
    }

}
