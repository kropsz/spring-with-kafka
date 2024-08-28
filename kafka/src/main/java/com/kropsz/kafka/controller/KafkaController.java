package com.kropsz.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kropsz.kafka.service.StringProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {
    
    private final StringProducerService stringProducerService;

    @GetMapping("/send")
    public void sendMessage(@RequestBody String message) {
        stringProducerService.sendMessage(message);
    }
}
