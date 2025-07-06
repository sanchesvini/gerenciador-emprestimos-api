package desafio2.desafio2.rest.exceptions;

public class LivroExistenteException extends RuntimeException {
    public LivroExistenteException(String message) {
        super(message);
    }

    public LivroExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
    public LivroExistenteException(Throwable cause) {
        super(cause);
    }
}
