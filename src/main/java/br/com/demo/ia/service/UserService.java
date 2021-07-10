package br.com.demo.ia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.demo.ia.domain.User;

public interface UserService {

	User save(User entity);
	
	User update(User entity);
	
	User findById(Long id);

	void deleteById(Long id);
	
	Page<User> findByNameStartingWith(String name, Pageable pageable);
}
