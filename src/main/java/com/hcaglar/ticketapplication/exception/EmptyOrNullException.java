package com.hcaglar.ticketapplication.exception;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
public class EmptyOrNullException extends RuntimeException{

    public EmptyOrNullException(String className, String message) {
        super(className + " "+message);
    }

    public EmptyOrNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
