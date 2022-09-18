package endler.exercise2.exceptions;

public class InvalidCardNumberException extends RuntimeException {
    public InvalidCardNumberException(String errorMessage) {
        super(errorMessage);
    }
}
