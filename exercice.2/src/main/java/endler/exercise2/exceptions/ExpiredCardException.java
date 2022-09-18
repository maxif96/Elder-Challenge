package endler.exercise2.exceptions;

import javax.persistence.PersistenceException;

public class ExpiredCardException extends PersistenceException {

    public ExpiredCardException(String errorMessage){
        super(errorMessage);
    }

}
