package endler.exercise2.exceptions;

import javax.persistence.PersistenceException;

public class CardAlreadyExists extends PersistenceException {
    public CardAlreadyExists(String errorMessage) {
        super(errorMessage);
    }
}
