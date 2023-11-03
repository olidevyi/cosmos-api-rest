package com.olidev.pe.cosmosapirest.exception;

import com.olidev.pe.cosmosapirest.model.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                webRequest.getDescription(false)); // Solo devuelve la URI y omite otros datos sensibles.
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handlerBadRequestException(BadRequestException exception,
                                                                  WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                webRequest.getDescription(false)); // Solo devuelve la URI y omite otros datos sensibles.
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
