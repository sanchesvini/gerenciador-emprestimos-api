package desafio2.desafio2.rest;

import desafio2.desafio2.rest.exceptions.UsuarioCamposInvalidosException;
import desafio2.desafio2.rest.exceptions.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsuarioRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(UsuarioCamposInvalidosException ex) {
         ErrorResponse errorResponse = new ErrorResponse(
                 HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>( errorResponse, HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(UsuarioNaoEncontradoException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>( errorResponse, HttpStatus.NOT_FOUND );
    }

}
