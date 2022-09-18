package endler.exercise2.exceptions;

public class BrandDoesNotExistException extends RuntimeException {
    public BrandDoesNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
