package com.kaczyn.springmongodbteste.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaczyn.springmongodbteste.service.ProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
	
	private final ProducerService producerService;
	
	@PostMapping
	public void send(String message) {
		this.producerService.sendMessage(message);
	}
}
