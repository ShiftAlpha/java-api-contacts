package com.acoer.exception;

//imports
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Resource Not Found Class & Message
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    // private static final long serialVUID = 1L;

    //Resource Not Found Exception Class
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
