package endler.exercise2.repositories;

import endler.exercise2.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository <Card, Long> {

    boolean existsByCardNumber(Long CardNumber);

}
