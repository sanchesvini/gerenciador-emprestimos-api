package desafio2.desafio2.rest;

import desafio2.desafio2.rest.exceptions.*;
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
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LivroNaoEmprestadoException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>( errorResponse, HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LivroIndisponivelException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LivroCamposInvalidosException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
