package br.com.demo.ia.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.demo.ia.domain.User;

@Service
class AuthenticationServiceImpl implements AuthenticationService {
	
	private final HttpSession httpSession;
	
	private final UserService userService;

	public AuthenticationServiceImpl(
			final HttpSession httpSession,
			final UserService userService
	) {
		this.httpSession = httpSession;
		this.userService = userService;
	}

	@Override
	public User login(User user) throws UsernameNotFoundException {
		User loggedUser = (User) userService.loadUserByUsername(user.getEmail());
		httpSession.setAttribute("loggedUser", loggedUser);
		
		return loggedUser;
	}

	@Override
	public void logout() {
		httpSession.invalidate();
	}

}
