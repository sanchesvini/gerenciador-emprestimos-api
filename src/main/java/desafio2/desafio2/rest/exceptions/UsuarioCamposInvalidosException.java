package desafio2.desafio2.rest.exceptions;

public class UsuarioCamposInvalidosException extends RuntimeException {
    public UsuarioCamposInvalidosException(String message) {
        super(message);
    }
    public UsuarioCamposInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
    public UsuarioCamposInvalidosException(Throwable cause) {
        super(cause);
    }
}
