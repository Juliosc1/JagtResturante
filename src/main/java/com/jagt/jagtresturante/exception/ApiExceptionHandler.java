package com.jagt.jagtresturante.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice //Allows you to handle exceptions across the whole application
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class}) //Used for handling exceptions in specific handler classes
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception) {
        //containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                exception.getMessage(), badRequest, ZonedDateTime.now()
        );
        //Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
