package br.com.demo.ia.dto;

import java.time.LocalDateTime;

import br.com.demo.ia.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String name;
	private String login;
	private String password;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private String email;
	private Boolean admin;
	
	public UserDTO(User entity) {
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
