package com.cherries.exchange.demo.ExptionHandlers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.sql.Timestamp;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value =  EntityNotFoundException.class )
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, HttpServletRequest request) {
        //IETF 7807
        ErrorResponse errorResponse = new ErrorResponse(
                new Timestamp(System.currentTimeMillis()).toString(),
                HttpStatus.NOT_FOUND.value(),
                EntityNotFoundException.class.getName(),
                ex.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<Object>(
                errorResponse,
                HttpStatus.NOT_FOUND);
    }
}