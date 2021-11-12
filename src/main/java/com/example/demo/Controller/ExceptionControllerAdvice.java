package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(value= HttpMessageNotReadableException.class)
    public ResponseEntity<String> y(Exception e){
        System.out.println(e.toString());
        return new ResponseEntity<>("The type is not right ", HttpStatus.CONFLICT);

    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> x(Exception e){
        System.out.println(e.toString());
        return new ResponseEntity<>("Not engoht  ", HttpStatus.CONFLICT);
    }


}
