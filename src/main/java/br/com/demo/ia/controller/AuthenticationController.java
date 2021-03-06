package br.com.demo.ia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.ia.domain.User;
import br.com.demo.ia.service.AuthenticationService;

@RestController
@RequestMapping("authentications")
class AuthenticationController {

	private final AuthenticationService authenticationService;

	public  AuthenticationController(final AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("login")
	ResponseEntity<User> login(@RequestBody User user) {
		return ResponseEntity.ok(authenticationService.login(user));
	}

	@GetMapping("logout")
	ResponseEntity<Void> logout() {
		authenticationService.logout();
		return ResponseEntity.noContent().build();
	}
}
