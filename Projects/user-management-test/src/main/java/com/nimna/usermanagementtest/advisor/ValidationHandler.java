package com.nimna.usermanagementtest.advisor;


import com.nimna.usermanagementtest.dto.response.StandardResponse;
import com.nimna.usermanagementtest.util.enums.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<StandardResponse> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false, StatusCode.BAD_REQUEST.getCode(), "Validation Error", Instant.now(), errorMap),
                HttpStatus.BAD_REQUEST
        );
    }
}
