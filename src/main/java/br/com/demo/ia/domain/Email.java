package br.com.demo.ia.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@RequiredArgsConstructor
public final class Email {
	
	@Id
	@GeneratedValue
	@Column(name = "EMAIL_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_FROM_ID", nullable = false, updatable = false)
	private final User userFrom;
	
	@ManyToOne
	@JoinColumn(name = "USER_TO_ID", nullable = false, updatable = false)
	private final User userTo;
	
	@Column(nullable = false, updatable = false)
	private final String subject;
	
	@Column(updatable = false)
	private final String content;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
}