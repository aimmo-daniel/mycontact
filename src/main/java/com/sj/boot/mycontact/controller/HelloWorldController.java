package com.sj.boot.mycontact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/api/helloWorld")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/helloException")
    public String helloException() {
        throw new RuntimeException("Hello RuntimeException");
    }
}
