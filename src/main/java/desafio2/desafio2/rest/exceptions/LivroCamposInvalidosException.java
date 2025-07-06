package desafio2.desafio2.rest.exceptions;

public class LivroCamposInvalidosException extends RuntimeException {
    public LivroCamposInvalidosException(String message) {
        super(message);
    }

    public LivroCamposInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
    public LivroCamposInvalidosException(Throwable cause) {
        super(cause);
    }
}
