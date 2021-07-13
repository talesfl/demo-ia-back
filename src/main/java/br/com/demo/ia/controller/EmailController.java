package br.com.demo.ia.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.ia.domain.Email;
import br.com.demo.ia.service.EmailService;

@RestController
@RequestMapping("emails")
class EmailController {

	private final EmailService emailService;

	public EmailController(final EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping
	public ResponseEntity<Void> dispatchEmail(@RequestBody final Email email) {
		emailService.dispatchEmail(email);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Email> findById(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(emailService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<Email>> findByUserFromId(
			@RequestParam final Long id,
			@RequestParam final int pageNumber, 
			@RequestParam final int pageSize
	) {
		Page<Email> page = emailService.findByUserFromId(id, PageRequest.of(pageNumber, pageSize));
		return ResponseEntity.ok(page);
	}
}
