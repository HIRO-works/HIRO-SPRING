package org.example.hiro_java.global.controlleradvice;

import org.example.hiro_java.global.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<String> handleCustomNotFoundException(CustomException e) {
        return ResponseEntity.status(HttpStatus.valueOf(e.getCode())).body(e.getMessage());
    }
}
