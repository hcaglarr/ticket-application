package com.hcaglar.ticketapplication.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EmptyOrNullException.class)
    public String emptyAndNullException(EmptyOrNullException exception, Model model){
        // TODO Edit pls
        return "error";
    }
}
