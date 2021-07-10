package br.com.demo.ia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.demo.ia.domain.Email;
import br.com.demo.ia.domain.User;
import br.com.demo.ia.event.EmailSentEvent;
import br.com.demo.ia.event.EmailSentEventDispatcher;
import br.com.demo.ia.repository.UserRepository;

@Service
class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private EmailSentEventDispatcher emailSentEventDispatcher;

	public UserServiceImpl(
			final UserRepository userRepository,
			final EmailSentEventDispatcher emailSentEventDispatcher
	) {
		this.userRepository = userRepository;
		this.emailSentEventDispatcher = emailSentEventDispatcher;
	}

	@Override
	public User save(User entity) {
		return userRepository.save(new User(
				entity.getName(), 
				entity.getLogin(),
				entity.getPassword(),
				entity.getEmail(),
				entity.getAdmin()
			));
	}

	@Override
	public User update(User entity) {
		
		// TODO: quando for implentar a sessão, fazer a checagem na
		// mesma para saber e o usuário logado é admin ou não.
		// Dependendo disso deve ser chamado o construtor apropriado
		
		return userRepository.save(new User(
				entity.getId(),
				entity.getName(),
				entity.getLogin(),
				entity.getEmail()
			));
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
	public void dispatchEmail(Email email) {
		emailSentEventDispatcher.send(new EmailSentEvent(email));
	}
	
}
