package br.com.demo.ia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.demo.ia.domain.Email;
import br.com.demo.ia.event.EmailSentEvent;
import br.com.demo.ia.event.EmailSentEventDispatcher;
import br.com.demo.ia.repository.EmailRepository;

@Service
class EmailServiceImpl implements EmailService {
	
	private final EmailRepository emailRepository;
	
	private final EmailSentEventDispatcher emailSentEventDispatcher;

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
	public Email findById(Long id) {
		return emailRepository.findById(id).orElseThrow();
	}
	
	@Override
	@Transactional
	public void dispatchEmail(Email email) {
		email = save(email);
		emailSentEventDispatcher.send(new EmailSentEvent(email));
	}

	@Override
	public Page<Email> findByUserFromId(Long id, Pageable pageable) {
		return emailRepository.findByUserFromId(id, pageable);
	}

}
