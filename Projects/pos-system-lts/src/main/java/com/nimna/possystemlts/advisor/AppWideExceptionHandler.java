package com.nimna.possystemlts.advisor;

import com.nimna.possystemlts.exception.BadRequestException;
import com.nimna.possystemlts.exception.NotFoundException;
import com.nimna.possystemlts.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse>  handleNotFoundException (NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Error Coming", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse> handleException (Exception e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(500, "Error", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardResponse> handleBadRequestException (Exception e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(400, "Error", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}
