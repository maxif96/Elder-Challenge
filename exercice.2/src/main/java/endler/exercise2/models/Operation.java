package endler.exercise2.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "operation_card",
    joinColumns = @JoinColumn(name = "operation_id"),
    inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Card card;

    @Column
    private Double amount;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column
    private Double total;


}
