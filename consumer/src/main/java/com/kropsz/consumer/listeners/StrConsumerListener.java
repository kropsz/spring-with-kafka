package com.kropsz.consumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StrConsumerListener {

    @KafkaListener(topics = "str-topic",
                   groupId = "group-1",
                   containerFactory = "stringKafkaListenerContainerFactory")
    public void listner(String message) {
        log.info("Message Receive: {}", message);
    }
}
