package desafio2.desafio2.rest.exceptions;

public class LivroIndisponivelException extends RuntimeException {
    public LivroIndisponivelException(String message) {
        super(message);
    }

    public LivroIndisponivelException(String message, Throwable cause) {
        super(message, cause);
    }
    public LivroIndisponivelException(Throwable cause) {
        super(cause);
    }
}
