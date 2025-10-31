package com.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producers")
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String topic,
                              @RequestParam String key,
                              @RequestParam String message) {
        producerService.sendMessage(topic, key, message);
        return "Message send complete";
    }
}
