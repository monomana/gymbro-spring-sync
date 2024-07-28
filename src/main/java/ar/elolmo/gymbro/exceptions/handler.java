package ar.elolmo.gymbro.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class handler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception ex){
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
