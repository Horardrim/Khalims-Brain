package com.horadrim.khalims.brain.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello");
        return "Hello I'm Khalims Brain";
    }
}
