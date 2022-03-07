package com.acoer.exception;

//imports
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Exception Handling
@ControllerAdvice
public class ContactCollectionException extends ResponseEntityExceptionHandler {

    //Resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //Global Exception Handler
    //Internal Server Error
    @ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

    //Alternative Object/Number not found Exception

    // public static String NotFoundException(String num) {
    //     return "Contact with " + num + " not found";
    // }

    //Alternative Contact Exists Exception

    // public static String ContactAlreadyExists() {
    //     return "Contact with already exists";

    // }

}
