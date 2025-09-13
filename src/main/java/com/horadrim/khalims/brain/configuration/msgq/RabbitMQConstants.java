package com.horadrim.khalims.brain.configuration.msgq;

public class RabbitMQConstants {
    public static final String QUEUE_NAME  = "boot.queue";
    public static final String EXCHANGE    = "boot.direct";
    public static final String ROUTING_KEY = "boot.routing";
    
    public static final String TOPIC_EXCHANGE = "boot.topic";
    public static final String QUEUE_NAME_TOPIC_EXCHANGE = "boot.queue.topic";
    public static final String TOPIC_EXCHANGE_ROUTING_KEY = "hdm.#.routing";
}
