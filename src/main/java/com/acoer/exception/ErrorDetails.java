package com.acoer.exception;

//imports
import java.util.Date;

//Error Details Class
public class ErrorDetails {

    //Error Details Attributes
    private Date timestamp;
    private String message;
    private String details;

    //Error Details Constructor
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    //Get Method for Time Stamp
    public Date getTimestamp() {
        return timestamp;
    }

    //Get Method for message(For Errors)
    public String getMessage() {
        return message;
    }

    //Get Method for details of error
    public String getDetails() {
        return details;
    }
}
