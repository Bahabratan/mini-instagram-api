package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FirstController {
    final String HW = "Hello world!";
    @GetMapping("/")
    public String getMethodName(@RequestParam(defaultValue = "world") String param) {
        return "Hello " + param;
    }
    public String retHelloWorld(){
        return HW;
    }
    
}
