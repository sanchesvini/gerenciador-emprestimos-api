package desafio2.desafio2.rest.exceptions;

public class LivroNaoEmprestadoException extends RuntimeException {
    public LivroNaoEmprestadoException(String message) {
        super(message);
    }

    public LivroNaoEmprestadoException(String message, Throwable cause) {
        super(message, cause);
    }
    public LivroNaoEmprestadoException(Throwable cause) {
        super(cause);
    }
}
