package br.com.demo.ia.service;

import br.com.demo.ia.domain.Email;

public interface EmailService {
	
	Email save(Email entity);
	
	void dispatchEmail(Email email);
}
