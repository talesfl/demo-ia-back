package br.com.demo.ia.event;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.demo.ia.component.CommonBeansComponent;
import br.com.demo.ia.domain.Email;

@Component
public class EmailSentEventHandler {
	
	private final CommonBeansComponent commonBeansComponent;

	public EmailSentEventHandler(
			final CommonBeansComponent commonBeansComponent
	) {
		this.commonBeansComponent = commonBeansComponent;
	}
	
	@RabbitListener(queues = "${demo_ia_back.rabbitMQ.queue}")
	public void handleEmailSentEvent(final Message message) {
		
		Email email = (Email) commonBeansComponent.jackson2MessageConverter()
			.fromMessage(message, EmailSentEvent.class);
		
		System.out.println("=======================");
		System.out.println(email);
		System.out.println("=======================");
	}	
}
