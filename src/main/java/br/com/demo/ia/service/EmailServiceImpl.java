package br.com.demo.ia.service;

import org.springframework.stereotype.Service;

import br.com.demo.ia.domain.Email;
import br.com.demo.ia.event.EmailSentEvent;
import br.com.demo.ia.event.EmailSentEventDispatcher;
import br.com.demo.ia.repository.EmailRepository;

@Service
class EmailServiceImpl implements EmailService {
	
	private EmailRepository emailRepository;
	
	private EmailSentEventDispatcher emailSentEventDispatcher;

	public EmailServiceImpl(
			final EmailRepository emailRepository,
			final EmailSentEventDispatcher emailSentEventDispatcher
	) {
		this.emailRepository = emailRepository;
		this.emailSentEventDispatcher = emailSentEventDispatcher;
	}

	@Override
	public Email save(Email entity) {
		return emailRepository.save(entity);
	}
	
	@Override
	public void dispatchEmail(Email email) {
		emailSentEventDispatcher.send(new EmailSentEvent(email));
	}
	
}
