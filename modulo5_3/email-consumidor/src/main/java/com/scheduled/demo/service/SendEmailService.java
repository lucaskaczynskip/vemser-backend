package com.scheduled.demo.service;

import com.scheduled.demo.dto.EmailDTO;
import com.scheduled.demo.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final EmailService emailService;

    public void sendEmail() {
        List<EmailDTO> list = new ArrayList<>();
        EmailRepository.received.forEach(email -> {
           emailService.sendSimpleMessage(email.getText(), email.getSubject(), email.getTo());
           list.add(email);
        });
        EmailRepository.received.removeAll(list);
    }
}
