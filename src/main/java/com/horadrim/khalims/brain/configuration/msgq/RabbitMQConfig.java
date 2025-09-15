package com.horadrim.khalims.brain.configuration.msgq;


import java.beans.BeanProperty;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitMQConfig {
    /** direct exchange **/
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(RabbitMQConstants.EXCHANGE, true, false);
    }

    public Queue queue() {
        return new Queue(RabbitMQConstants.QUEUE_NAME, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(RabbitMQConstants.ROUTING_KEY);
    }

    /** topic exchange **/
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQConstants.TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public Queue topicQueue() {
        return new Queue(RabbitMQConstants.QUEUE_NAME_TOPIC_EXCHANGE, true);
    }

    @Bean
    public Binding topicExchangeBind() {
        return BindingBuilder
                .bind(topicQueue())
                .to(topicExchange())
                .with(RabbitMQConstants.TOPIC_EXCHANGE_ROUTING_KEY);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory cf) {
        return new RabbitAdmin(cf);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMandatory(true);

        template.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("Message reach Exchange: {}", correlationData.getId());
            } else {
                log.error("Message reach Exchange: {}, with the reason: {}", correlationData.getId(), cause);
                // can do retry or other logic here.
            }
        });

        template.setReturnsCallback(returned -> {
            log.error("Message not reach: {}, routingKey: {}, replyText: {}",
                returned.getMessage().getMessageProperties().getMessageId(),
                returned.getRoutingKey(),
                returned.getReplyText());
            // can do retry or other logic here.
        });
        return template;
    }
}
