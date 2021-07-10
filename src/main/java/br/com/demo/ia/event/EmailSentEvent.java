package br.com.demo.ia.event;

import java.io.Serializable;

import br.com.demo.ia.domain.Email;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@SuppressWarnings("serial")
public class EmailSentEvent implements Serializable {
	
	private final Email email;
	
}
