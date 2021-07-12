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
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public final class Email {
	
	@Id
	@GeneratedValue
	@Column(name = "EMAIL_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_FROM_ID", nullable = false, updatable = false)
	private User userFrom;

	@ManyToOne
	@JoinColumn(name = "USER_TO_ID", nullable = false, updatable = false)
	private User userTo;

	@Column(nullable = false, updatable = false)
	private String subject;

	@Column(updatable = false)
	private String content;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	public Email(
			Long id, 
			User userFrom, 
			User userTo, 
			String subject, 
			String content
	) {
		this.id = id;
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.subject = subject;
		this.content = content;
		this.createDate = LocalDateTime.now();
	}
	
}