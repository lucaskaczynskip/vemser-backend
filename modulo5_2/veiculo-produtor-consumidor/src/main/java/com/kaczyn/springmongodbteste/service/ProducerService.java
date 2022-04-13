package com.kaczyn.springmongodbteste.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaczyn.springmongodbteste.dto.CarDataDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper mapper;
	
	@Value(value = "${kafka.topic}")
    private String topic;
	
	public void sendMessage(CarDataDTO carDataDTO) throws JsonProcessingException {
		String message = mapper.writeValueAsString(carDataDTO);
		this.sendMessage(message);
	}
	
	private void sendMessage(String msg) {
		Message<String> message = MessageBuilder.withPayload(msg)
				.setHeader(KafkaHeaders.TOPIC, topic)
				.setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
				.build();
		
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
		
		future.addCallback(new ListenableFutureCallback<>() {
			@Override
			public void onSuccess(SendResult result) {
				log.info("log sent to kafka with the text: {}", msg);
			};
			
			@Override
            public void onFailure(Throwable ex) {
                log.error("error publishing to kafka with message: {}", msg, ex);
            }
		});
	}
}
