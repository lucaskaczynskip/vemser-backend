package com.kaczyn.chat.kafka.service;

import java.time.LocalDateTime;
import java.util.List;
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

	@Value("${kafka.topic}")
	private String topic;
	
	public void sendMessage(List<ChatTopic> topics, String mensagem) throws JsonProcessingException {
		ChatMessageDTO chatMessage = ChatMessageDTO.builder()
				.mensagem(mensagem)
				.usuario("Lucas")
				.dataCriacao(LocalDateTime.now())
				.build();
		
		for (ChatTopic topic : topics) {
			this.sendMessage(topic.ordinal(), this.mapper.writeValueAsString(chatMessage));
		}
	}
	
	private void sendMessage(Integer partition, String msg) {
		this.sendMessageTo(partition, msg);
	}

	private void sendMessageTo(Integer partition, String msg) {
		Message<String> message = MessageBuilder.withPayload(msg)
				.setHeader(KafkaHeaders.TOPIC, topic)
				.setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
				.setHeader(KafkaHeaders.PARTITION_ID, partition)
				.build();
		
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
	}
}
