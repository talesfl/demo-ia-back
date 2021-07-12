package br.com.demo.ia.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		
		UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
		
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				user.getEmail(), 
				user.getPassword(), 
				userDetails.getAuthorities()
		);
		context.setAuthentication(authentication);
		
		return (User) userDetails;
	}

	@Override
	public void logout() {
		SecurityContextHolder.clearContext();
	}

}
