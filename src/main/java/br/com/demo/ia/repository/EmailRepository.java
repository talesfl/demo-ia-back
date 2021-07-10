package br.com.demo.ia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.demo.ia.domain.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
	
	Page<Email> findByUserFromId(@Param("userFrom.id") Long id,  final Pageable pageable);
}
