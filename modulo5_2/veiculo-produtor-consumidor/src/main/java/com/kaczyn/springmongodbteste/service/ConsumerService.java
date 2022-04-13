package com.kaczyn.springmongodbteste.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaczyn.springmongodbteste.dto.CarDataDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
	
	private final CarDataService carDataService;
	private final ObjectMapper mapper;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "veiculo_group1",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonMappingException, JsonProcessingException{
    	CarDataDTO carDataDTO = this.mapper.readValue(message, CarDataDTO.class);
    	this.carDataService.insert(carDataDTO);
        log.info("offset -> '{}' key -> '{}' -> Consumed message -> '{}'  ", offset, key, message);
    }
}
