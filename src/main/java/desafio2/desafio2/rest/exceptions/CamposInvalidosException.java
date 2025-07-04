package desafio2.desafio2.rest.exceptions;

public class CamposInvalidosException extends RuntimeException {
    public CamposInvalidosException(String message) {
        super(message);
    }
    public CamposInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
    public CamposInvalidosException(Throwable cause) {
        super(cause);
    }
}
