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
import br.com.demo.ia.dto.UserDTO;
import br.com.demo.ia.service.UserService;

@RestController
@RequestMapping("users")
class UserController {
	
	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody final UserDTO user) {
		return ResponseEntity.ok(new UserDTO(userService.save(user.toEntity())));
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> update(@RequestBody final UserDTO user) {
		return ResponseEntity.ok(new UserDTO(userService.update(user.toEntity())));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(new UserDTO(userService.findById(id)));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") final Long id) {
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("name")
	public ResponseEntity<Page<UserDTO>> findByNameStartingWith(
			@RequestParam final String name,
			@RequestParam final int pageNumber, 
			@RequestParam final int pageSize
	) {
		Page<User> page = userService.findByNameStartingWith(name, PageRequest.of(pageNumber, pageSize));
		return ResponseEntity.ok(page.map(UserDTO::new));
	}
	
	@GetMapping("email")
	public ResponseEntity<Page<UserDTO>> findByEmailStartingWith(
			@RequestParam final String email,
			@RequestParam final int pageNumber, 
			@RequestParam final int pageSize
	) {
		Page<User> page = userService.findByEmailStartingWith(email, PageRequest.of(pageNumber, pageSize));
		return ResponseEntity.ok(page.map(UserDTO::new));
	}

}
