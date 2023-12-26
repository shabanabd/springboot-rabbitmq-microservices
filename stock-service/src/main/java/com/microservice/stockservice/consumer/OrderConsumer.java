package com.microservice.stockservice.consumer;

import com.microservice.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Received message -> %s", event.toString()));
    }
}
