package dev.java10x.CadsatroDeNinja.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CadastroNotFound  extends RuntimeException{
    public CadastroNotFound(String msg){
        super(msg);
    }

}
