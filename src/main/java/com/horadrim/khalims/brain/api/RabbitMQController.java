package com.horadrim.khalims.brain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horadrim.khalims.brain.service.msgq.ProducerService;

@RestController
public class RabbitMQController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/rabbitmq")
    public String sayHello(){
        producerService.send("Hello");
        return "Hello It's rabbitmq page.";
    }
}
