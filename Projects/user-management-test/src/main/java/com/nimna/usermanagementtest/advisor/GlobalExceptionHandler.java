package com.nimna.usermanagementtest.advisor;


import com.nimna.usermanagementtest.dto.response.StandardResponse;
import com.nimna.usermanagementtest.exception.*;
import com.nimna.usermanagementtest.util.enums.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardResponse> handleBadeRequestException(Exception e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false, StatusCode.BAD_REQUEST.getCode(), e.getMessage(), Instant.now(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(Exception e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false, StatusCode.NOT_FOUND.getCode(), e.getMessage(), Instant.now(), null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<StandardResponse> handleCConflictException(Exception e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false, StatusCode.CONFLICT.getCode(), e.getMessage(), Instant.now(), null),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<StandardResponse> handleForbiddenException(Exception e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false, StatusCode.FORBIDDEN.getCode(), e.getMessage(), Instant.now(), null),
                HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<StandardResponse> handleInternalServerException(Exception e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false, StatusCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage(), Instant.now(), null),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<StandardResponse> handleException (Exception e) {
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(false, StatusCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage(), Instant.now(), null),
//                HttpStatus.INTERNAL_SERVER_ERROR
//        );
//    }
}
