package br.com.demo.ia.domain;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Email {

	private final String from;
	private final String to;
	private final String subject;
	private final String content;
	private final LocalDateTime createDate = LocalDateTime.now();
	
}