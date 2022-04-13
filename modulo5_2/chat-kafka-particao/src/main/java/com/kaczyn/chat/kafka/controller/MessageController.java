package com.kaczyn.chat.kafka.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kaczyn.chat.kafka.service.ProducerService;
import com.kaczyn.chat.kafka.topics.ChatTopic;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
	
	private final ProducerService producerService;

	@PostMapping
	public void sendMessage(@RequestParam List<ChatTopic> topics, String message) throws JsonProcessingException {
		this.producerService.sendMessage(topics, message);
	}
}
