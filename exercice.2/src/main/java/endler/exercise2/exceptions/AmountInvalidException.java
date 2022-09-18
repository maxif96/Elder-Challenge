package endler.exercise2.exceptions;

import javax.persistence.PersistenceException;

public class AmountInvalidException extends PersistenceException {

    public AmountInvalidException (String errorMessage){
        super(errorMessage);
    }

}
