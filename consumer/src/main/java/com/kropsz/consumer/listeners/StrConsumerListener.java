package com.kropsz.consumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StrConsumerListener {

    @KafkaListener(topics = "str-topic", groupId = "group-1",
    topicPartitions = {
        @TopicPartition(topic = "str-topic", partitions = { "0" }),
       }
    ,containerFactory = "stringKafkaListenerContainerFactory")
    public void create(String message) {
        log.info("Message Receive: {}", message);
    }

    @KafkaListener(topics = "str-topic", groupId = "group-1", containerFactory = "stringKafkaListenerContainerFactory")
    public void log(String message) {
        log.info("Message Receive: {}", message);
    }
}
