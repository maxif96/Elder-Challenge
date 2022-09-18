package endler.exercise2.dto.response;

import endler.exercise2.enumerations.Brand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OperationResponseDTO {

    private Long id;
    private String cardBrand;
    private Double amount;
    private Double interestRate;
    private Double total;

}
