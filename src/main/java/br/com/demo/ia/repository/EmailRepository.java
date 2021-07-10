package br.com.demo.ia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.demo.ia.domain.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
