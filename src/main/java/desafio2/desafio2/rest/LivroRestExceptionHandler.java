package desafio2.desafio2.rest;

import desafio2.desafio2.rest.exceptions.CamposInvalidosException;
import desafio2.desafio2.rest.exceptions.LivroExistenteException;
import desafio2.desafio2.rest.exceptions.LivroNaoEncontradoException;
import desafio2.desafio2.rest.exceptions.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LivroRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LivroNaoEncontradoException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>( errorResponse, HttpStatus.NOT_FOUND );
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LivroExistenteException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>( errorResponse, HttpStatus.BAD_REQUEST );
    }
}
