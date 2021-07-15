package br.com.demo.ia.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.demo.ia.domain.User;

public interface AuthenticationService {

	User login(User user) throws UsernameNotFoundException;

	void logout();
}
