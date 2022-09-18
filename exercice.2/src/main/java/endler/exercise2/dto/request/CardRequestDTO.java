package endler.exercise2.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class CardRequestDTO {

    private String brand;
    private Long cardNumber;
    @NotBlank(message = "Nombre y Apellido no puede estar vacío.")
    private String cardHolder;
    private LocalDate expirationDate;

}
