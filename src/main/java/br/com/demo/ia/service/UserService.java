package br.com.demo.ia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.demo.ia.domain.User;

public interface UserService {

	User save(User entity);
	
	User update(User entity);
	
	void deleteById(Long id);
	
	Page<User> findByNameStartingWith(String name, Pageable pageable);

	User findById(Long id);


}
