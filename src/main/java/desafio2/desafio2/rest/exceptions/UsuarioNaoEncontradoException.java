package desafio2.desafio2.rest.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
    public UsuarioNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
