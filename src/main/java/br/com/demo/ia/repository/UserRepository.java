package br.com.demo.ia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.demo.ia.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByNameStartingWith(@Param("name") final String name, final Pageable pageable);
}
