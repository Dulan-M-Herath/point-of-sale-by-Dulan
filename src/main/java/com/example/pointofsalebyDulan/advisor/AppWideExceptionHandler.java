package com.example.pointofsalebyDulan.advisor;

import com.example.pointofsalebyDulan.exception.NotFoundException;
import com.example.pointofsalebyDulan.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotfoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
