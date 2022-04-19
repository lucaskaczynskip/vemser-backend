package com.scheduled.demo.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scheduled.demo.dto.EmailDTO;
import com.scheduled.demo.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {

	private final ObjectMapper mapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory"
    )
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonMappingException, JsonProcessingException{
        EmailDTO email = mapper.readValue(message, EmailDTO.class);
        EmailRepository.received.add(email);
        log.info("offset -> '{}' key -> '{}' -> Consumed message -> '{}'  ", offset, key, message);
    }
}
