package com.angel.curso.springboot.webapperror.controllers;

import com.angel.curso.springboot.webapperror.exceptions.UserNotFoundException;
import com.angel.curso.springboot.webapperror.models.Error;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.util.*;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error: Division entre 0");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        //  opcion 1
        //  return ResponseEntity.internalServerError().body(error);

        //  opcion 2
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Error: numero con formato no valido");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({
            NullPointerException.class,
            HttpMessageNotWritableException.class,
            NoSuchElementException.class,
            UserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Error: Usuario o rol no encontrado");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error: Api rest no encontrada");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
