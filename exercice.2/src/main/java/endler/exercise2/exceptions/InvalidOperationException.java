package endler.exercise2.exceptions;

import javax.persistence.PersistenceException;

public class InvalidOperationException extends PersistenceException {
    public InvalidOperationException(String errorMessage) {
        super(errorMessage);
    }
}
