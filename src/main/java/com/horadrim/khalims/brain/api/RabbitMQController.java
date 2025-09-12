package com.horadrim.khalims.brain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;

import com.horadrim.khalims.brain.service.msgq.ProducerService;
import com.horadrim.khalims.brain.api.messages.Message;

@RestController
public class RabbitMQController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping("/rabbitmq")
    public String sayHello() throws JsonProcessingException {
        Message sampleMsg = new Message("khalims-brain", Instant.now().toEpochMilli());
        producerService.send(mapper.writeValueAsString(sampleMsg));
        return "Hello It's rabbitmq page.";
    }
}
