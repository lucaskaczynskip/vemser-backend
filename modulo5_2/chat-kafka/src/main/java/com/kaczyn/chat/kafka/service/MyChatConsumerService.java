package com.kaczyn.chat.kafka.service;


import java.time.format.DateTimeFormatter;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaczyn.chat.kafka.dto.ChatMessageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyChatConsumerService {

	private final ObjectMapper mapper;

    @KafkaListener(
            topics = "chat-lucas",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonMappingException, JsonProcessingException{
    	ChatMessageDTO chatMessageDTO = this.mapper.readValue(message, ChatMessageDTO.class);
        log.info("{} [{}] (privado): {}  ", chatMessageDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), chatMessageDTO.getUsuario(), chatMessageDTO.getMensagem());
    }
}
