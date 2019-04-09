package com.example.demosecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Hello {

    @GetMapping("/home")
    public String home(){
        String num = "10";
        System.out.println("my home...notttt secured: " + num) ;

         return "home";

    }

    @GetMapping("/hello")
    public String hello(){
        String num = "10";
        System.out.println("hello...secured: " + num) ;

//        System.out.println("SecurityContextHolder.getContext().getAuthentication().getPrincipal() : " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "hello...1";

    }

    @GetMapping("/api/a")
    public String aaa(){
        String num = "10";
        System.out.println("aaa...should not secured...") ;
        return "";

    }


}
