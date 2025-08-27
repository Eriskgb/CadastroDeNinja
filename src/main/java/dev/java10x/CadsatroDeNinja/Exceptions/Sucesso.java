package dev.java10x.CadsatroDeNinja.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class Sucesso extends RuntimeException{
    public  Sucesso(String msg){
        super(msg);

    }
}
