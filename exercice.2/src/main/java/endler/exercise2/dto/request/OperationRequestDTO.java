package endler.exercise2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OperationRequestDTO {

    @NotNull(message = "Debe ingresar una tarjeta.")
    private Long cardId;
    @NotNull(message = "Debe ingresar un monto.")
    private Double amount;

}
