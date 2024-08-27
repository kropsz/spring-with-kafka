package com.kropsz.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StringProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).whenComplete(
            getResultSendMessage());
    }

    private static java.util.function.BiConsumer<? super SendResult<String, String>, ? super Throwable> getResultSendMessage() {
        return (success, ex) -> {
            if (ex != null) {
                log.error("::: MACHINE_SERVICE | ERROR SEND MESSAGE :::");
            } else {
                log.info("::: MACHINE_SERVICE | SEND MESSAGE SUCCESSFULLY :::");
            }
        };
    }
}
