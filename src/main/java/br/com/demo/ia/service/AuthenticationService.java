package br.com.demo.ia.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.demo.ia.dto.UserDTO;

public interface AuthenticationService {

	UserDTO login(UserDTO user) throws UsernameNotFoundException;

	void logout();
}
