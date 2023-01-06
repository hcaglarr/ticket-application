package com.hcaglar.ticketapplication.web.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Controller
@RequestMapping("/account/login")
public class LoginController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        var stringTrimmer = new StringTrimmerEditor(false);
        dataBinder.registerCustomEditor(String.class,stringTrimmer);
    }

    @GetMapping
    public String index(){
        return "login/index";
    }

}
