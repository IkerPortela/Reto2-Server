package com.example.Reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto2.email.EmailService;

@RestController
@RequestMapping("api")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send-email")
	public ResponseEntity<?> sendEmail(
			@RequestParam String toEmail,
			@RequestParam String subject,
			@RequestParam String message) {
		emailService.sendEmail(toEmail, subject, message);
		return null;
	}
}
