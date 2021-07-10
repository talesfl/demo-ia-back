package br.com.demo.ia.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime updateDate;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private Boolean admin;
	

	public User(
			String name, 
			String login, 
			String password, 
			String email, 
			Boolean admin
	) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.createDate = LocalDateTime.now();
		this.updateDate = this.createDate;
		this.email = email;
		this.admin = admin;
	}
	
	public User(
			Long id,
			String name, 
			String login, 
			String password, 
			String email, 
			Boolean admin
	) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.updateDate = LocalDateTime.now();
		this.email = email;
		this.admin = admin;
	}
	
	public User(
			Long id,
			String name, 
			String login, 
			String email
	) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.updateDate = LocalDateTime.now();
		this.email = email;
	}

}
