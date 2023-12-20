package com.ecemgc.orderproductdemo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> invalidArgumentException(MethodArgumentNotValidException e) {
        Map<String, String> result  = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            result.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return result;
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleBusinessException(NotFoundException notFoundException) {
        return new HashMap<>() {{
            put("errorMessage", notFoundException.getMessage());
        }};
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleUnauthorized(UnauthorizedException unauthorizedException) {
        return new HashMap<>() {{
            put("errorMessage", unauthorizedException.getMessage());
        }};
    }

}