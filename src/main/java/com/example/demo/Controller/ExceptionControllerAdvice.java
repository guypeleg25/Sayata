package com.example.demo.Controller;

import com.example.demo.ErrorResponse;
import com.example.demo.ExistsExp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ExistsExp.class)
    public String exceptionHandler(Exception e){
        //TODO build exp
        return e.getMessage();
    }

}
