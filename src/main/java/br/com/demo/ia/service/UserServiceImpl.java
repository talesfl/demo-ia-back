package br.com.demo.ia.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.demo.ia.domain.User;
import br.com.demo.ia.repository.UserRepository;

@Service
class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User update(User entity) {
		User user = userRepository.findById(entity.getId()).orElseThrow();
		
		user.setAdmin(entity.getAdmin());
		user.setEmail(entity.getEmail());
		user.setLogin(entity.getLogin());
		user.setName(entity.getName());
		user.setUpdateDate(LocalDateTime.now());
		
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Page<User> findByNameStartingWith(String name, Pageable pageable) {
		return userRepository.findByNameStartingWith(name, pageable);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}

	@Override
	public Page<User> findByEmailStartingWith(String name, Pageable pageable) {
		return userRepository.findByEmailStartingWith(name, pageable);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User [ %s ] not found.", username)));
	}

	@Override
	public void updatePassword(Long id, String password) {
		User user = userRepository.findById(id).orElseThrow();
		
		if (password == null || password.isEmpty() || password.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		user.setPassword(password);
		user.setUpdateDate(LocalDateTime.now());
		
		userRepository.save(user);
	}

}
