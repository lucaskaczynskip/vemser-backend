package com.kaczyn.springmongodbteste.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset){
        log.info("offset -> '{}' key -> '{}' -> Consumed message -> '{}'  ", offset, key, message);
    }
}
