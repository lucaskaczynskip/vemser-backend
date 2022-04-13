package com.kaczyn.chat.kafka.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
import com.kaczyn.chat.kafka.dto.ChatMessageDTO;
import com.kaczyn.chat.kafka.topics.ChatTopic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerService {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper mapper;
	
	public void sendMessage(List<ChatTopic> topics, String mensagem) throws JsonProcessingException {
		ChatMessageDTO chatMessage = ChatMessageDTO.builder()
				.mensagem(mensagem)
				.usuario("Lucas")
				.dataCriacao(LocalDateTime.now())
				.build();
		
		for (ChatTopic topic : topics) {
			this.sendMessage(topic.getDescription(), this.mapper.writeValueAsString(chatMessage));			
		}
	}
	
	private void sendMessage(String topic, String msg) {
		this.sendMessageTo(topic, msg);
	}

	private void sendMessageTo(String topic, String msg) {
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
