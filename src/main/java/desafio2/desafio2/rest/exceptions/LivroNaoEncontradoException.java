package desafio2.desafio2.rest.exceptions;

public class LivroNaoEncontradoException extends Exception {
    public LivroNaoEncontradoException(String message) {
        super(message);
    }

    public LivroNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public LivroNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
