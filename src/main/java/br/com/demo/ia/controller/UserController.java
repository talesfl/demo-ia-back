package br.com.demo.ia.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.ia.domain.User;
import br.com.demo.ia.service.UserService;

@RestController
@RequestMapping("users")
class UserController {
	
	private UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody final User user) {
		return ResponseEntity.ok(userService.save(user));
	}
	
	@PutMapping
	public ResponseEntity<User> update(@RequestBody final User user) {
		return ResponseEntity.ok(userService.update(user));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> findById(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") final Long id) {
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("name")
	public ResponseEntity<Page<User>> findByNameStartingWith(
			@RequestParam final String name,
			@RequestParam final int pageNumber, 
			@RequestParam final int pageSize
	) {
		Page<User> page = userService.findByNameStartingWith(name, PageRequest.of(pageNumber, pageSize));
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("email")
	public ResponseEntity<Page<User>> findByEmailStartingWith(
			@RequestParam final String email,
			@RequestParam final int pageNumber, 
			@RequestParam final int pageSize
	) {
		Page<User> page = userService.findByEmailStartingWith(email, PageRequest.of(pageNumber, pageSize));
		return ResponseEntity.ok(page);
	}

}
