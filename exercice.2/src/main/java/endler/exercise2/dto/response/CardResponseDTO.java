package endler.exercise2.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CardResponseDTO {

    private Long id;
    private String brand;
    private Long cardNumber;
    private String cardHolder;
    private LocalDate expirationDate;

}
