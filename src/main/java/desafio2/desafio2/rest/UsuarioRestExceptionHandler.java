package desafio2.desafio2.rest;

import desafio2.desafio2.rest.exceptions.CamposInvalidosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsuarioRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(CamposInvalidosException ex) {
         ErrorResponse errorResponse = new ErrorResponse(
                 HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>( errorResponse, HttpStatus.BAD_REQUEST );
    }

}
