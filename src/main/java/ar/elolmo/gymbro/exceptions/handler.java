package ar.elolmo.gymbro.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class handler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> exceptionHandler(IllegalArgumentException ex){
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

//    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<?> exceptionHandler(SQLIntegrityConstraintViolationException ex){
//        return ResponseEntity.internalServerError().body("Error de clave foranea :: "+ex.getMessage());
//    }
    //    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> exceptionHandler(Exception ex){
//        return ResponseEntity.internalServerError().body(ex.getMessage());
//    }
}
