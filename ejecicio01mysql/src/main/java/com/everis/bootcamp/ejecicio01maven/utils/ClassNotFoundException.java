package com.everis.bootcamp.ejecicio01maven.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassNotFoundException extends RuntimeException{

    public ClassNotFoundException(String exception){
        super(exception);
    }
}
