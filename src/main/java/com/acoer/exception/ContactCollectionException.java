package com.acoer.exception;

public class ContactCollectionException extends Exception {

    public ContactCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String num) {

        return "Contact with " + num + " not found";

    }

    public static String ContactAlreadyExists() {

        return "Contact with already exists";

    }

}
