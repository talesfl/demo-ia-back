package br.com.demo.ia.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.demo.ia.domain.User;

@Service
class AuthenticationServiceImpl implements AuthenticationService {
	
	private final UserService userService;

	public AuthenticationServiceImpl(
			final UserService userService
	) {
		this.userService = userService;
	}

	@Override
	public User login(User user) throws UsernameNotFoundException {
		return (User) userService.loadUserByUsername(user.getEmail());
	}

	@Override
	public void logout() {
		SecurityContextHolder.clearContext();
	}

}
