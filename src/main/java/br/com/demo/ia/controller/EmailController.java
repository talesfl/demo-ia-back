package br.com.demo.ia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.ia.domain.Email;
import br.com.demo.ia.service.EmailService;

@RestController
@RequestMapping("emails")
class EmailController {

	private EmailService emailService;

	public EmailController(final EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping("email")
	public ResponseEntity<Void> dispatchEmail(@RequestBody final Email email) {
		Email entity = emailService.save(email);
		emailService.dispatchEmail(entity);
		return ResponseEntity.noContent().build();
	}
}
