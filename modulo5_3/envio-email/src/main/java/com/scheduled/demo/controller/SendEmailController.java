package com.scheduled.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scheduled.demo.dto.EmailDTO;
import com.scheduled.demo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class SendEmailController {

    private final ProducerService service;

    @PostMapping
    @Validated
    public void sendEmailToStack(@Valid EmailDTO emailDTO) throws JsonProcessingException {
        service.sendMessage(emailDTO);
    }
}
