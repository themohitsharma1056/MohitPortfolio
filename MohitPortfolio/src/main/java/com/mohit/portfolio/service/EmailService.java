package com.mohit.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactNotification(

            String name,

            String email,

            String message

    ) {

        SimpleMailMessage mail =
                new SimpleMailMessage();

        mail.setTo(
                "the.mohit1056@gmail.com"
        );

        mail.setSubject(
                "New Portfolio Contact Message"
        );

        mail.setText(

                "Name: " + name +

                "\nEmail: " + email +

                "\n\nMessage:\n" + message

        );

        mailSender.send(mail);

    }

}