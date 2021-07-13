package br.com.demo.ia.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.demo.ia.domain.User;
import br.com.demo.ia.dto.UserDTO;

@Service
class AuthenticationServiceImpl implements AuthenticationService {
	
	private final UserService userService;

	public AuthenticationServiceImpl(
			final UserService userService
	) {
		this.userService = userService;
	}

	@Override
	public UserDTO login(UserDTO user) throws UsernameNotFoundException {
		return new UserDTO((User) userService.loadUserByUsername(user.getEmail()));
	}

	@Override
	public void logout() {
		SecurityContextHolder.clearContext();
	}

}
