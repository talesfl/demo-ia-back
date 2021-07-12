package br.com.demo.ia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.demo.ia.domain.Email;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class EmailDTO implements Serializable {
	
	private Long id;
	private UserDTO userFrom;
	private UserDTO userTo;
	private String subject;
	private String content;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createDate;

	public EmailDTO(final Email entity) {
		if (entity != null) {
			this.id = entity.getId();
			
			if (entity.getUserFrom() != null) {
				this.userFrom = new UserDTO(entity.getUserFrom());
			}
			
			if (entity.getUserTo() != null) {
				this.userFrom = new UserDTO(entity.getUserTo());
			}
			
			this.subject = entity.getSubject();
			this.content = entity.getContent();
			this.createDate = entity.getCreateDate();
		}
	}
	
	public Email toEntity() {
		return new Email(id, userFrom.toEntity(), userTo.toEntity(), subject, content);
	}
}
