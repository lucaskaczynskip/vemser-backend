package com.kaczyn.springmongodbteste.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kaczyn.springmongodbteste.dto.CarDataDTO;
import com.kaczyn.springmongodbteste.service.ProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
	
	private final ProducerService producerService;
	
	@PostMapping
	public void send(CarDataDTO message) throws JsonProcessingException {
		this.producerService.sendMessage(message);
	}
}
