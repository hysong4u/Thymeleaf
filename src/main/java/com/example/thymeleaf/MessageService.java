package com.example.thymeleaf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@RequiredArgsConstructor
@Service
public class MessageService {

    private final JavaMailSender emailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // 보낼 대상
        message.setSubject(subject); // 제목
        message.setText(text); // 내용
        emailSender.send(message);
    }
}
