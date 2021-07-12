package br.com.demo.ia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.demo.ia.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserDTO implements Serializable {

	private Long id;
	private String name;
	private String login;
	private String password;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime updateDate;
	
	private String email;
	private Boolean admin;
	
	public UserDTO(final User entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.name = entity.getName();
			this.login = entity.getLogin();
			this.createDate = entity.getCreateDate();
			this.updateDate = entity.getUpdateDate();
			this.email = entity.getEmail();
			this.admin = entity.getAdmin();
		}
	}
	
	public User toEntity() {
		 return new User(id, name, login, password, email, admin);
	}
}
