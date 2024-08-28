package com.kropsz.consumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kropsz.consumer.custom.StrCustomConsumerListener;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StrConsumerListener {

    @StrCustomConsumerListener(groupId = "group-1")
    public void create(String message) {
        log.info("Message Receive: {}", message);
    }

    @KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory", topics = "str-topic")
    public void log(String message) {
        log.info("Message Receive: {}", message);
    }
}
