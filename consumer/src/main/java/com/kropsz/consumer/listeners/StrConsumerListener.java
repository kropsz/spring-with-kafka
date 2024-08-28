package com.kropsz.consumer.listeners;

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

    @StrCustomConsumerListener(groupId = "group-1")
    public void log(String message) {
        log.info("Message Receive: {}", message);
    }
}
