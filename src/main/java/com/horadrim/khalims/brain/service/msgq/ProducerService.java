package com.horadrim.khalims.brain.service.msgq;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horadrim.khalims.brain.configuration.msgq.RabbitMQConstants;

import java.util.UUID;

@Service
public class ProducerService {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String msg) {
        rabbitTemplate.convertAndSend(
                RabbitMQConstants.EXCHANGE,
                RabbitMQConstants.ROUTING_KEY,
                msg,
                (MessagePostProcessor) message -> {
                    message.getMessageProperties().setMessageId(UUID.randomUUID().toString());
                    return message;
                });
    }

    public void sendToExchangeWithRoutingKey(String exchange, String routingKey, String msg) {
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                msg,
                (MessagePostProcessor) message -> {
                    message.getMessageProperties().setMessageId(UUID.randomUUID().toString());
                    return message;
                });
    }
}
