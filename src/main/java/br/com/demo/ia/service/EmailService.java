package br.com.demo.ia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.demo.ia.domain.Email;

public interface EmailService {
	
	Email save(Email entity);
	
	Email findById(Long id);
	
	void dispatchEmail(Email email);

	Page<Email> findByUserId(Long id, Pageable pageable);
}
