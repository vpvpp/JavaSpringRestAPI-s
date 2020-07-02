package edu.ait.shoppingCart.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommonNotFoundException extends RuntimeException {

    public CommonNotFoundException() {
        super();
    }

    public CommonNotFoundException(String message) {
        super(message);
    }

}
