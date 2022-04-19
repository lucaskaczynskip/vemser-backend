package com.scheduled.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleTask {

    private final SendEmailService sendEmailService;

    @Scheduled(fixedDelay = 6000)
    private void sendMail() throws InterruptedException {
        sendEmailService.sendEmail();
    }
}
