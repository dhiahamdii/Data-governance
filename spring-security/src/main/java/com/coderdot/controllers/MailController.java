package com.coderdot.controllers;

import com.coderdot.services.EMAILSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MailController {
    @Autowired
    private EMAILSenderService mailService;

    public void SpringSecurityApplication(EMAILSenderService mailService) {
        this.mailService = mailService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/mail")

    public void sendMail(@RequestBody String to) throws MessagingException {
    mailService.sendNewMail(to);
    }
}
