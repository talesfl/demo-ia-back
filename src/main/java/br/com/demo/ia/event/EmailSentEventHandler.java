package br.com.demo.ia.event;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.demo.ia.component.CommonBeansComponent;

@Component
public class EmailSentEventHandler {
	
	private final CommonBeansComponent commonBeansComponent;

	public EmailSentEventHandler(
			final CommonBeansComponent commonBeansComponent
	) {
		this.commonBeansComponent = commonBeansComponent;
	}
	
	@RabbitListener(queues = "${demo_ia_back.rabbitmq.queue}")
	public void handleEmailSentEvent(final Message message) {
		
		EmailSentEvent event = (EmailSentEvent) commonBeansComponent.jackson2MessageConverter()
			.fromMessage(message, EmailSentEvent.class);
		
		System.out.println("=======================");
		System.out.println(event);
		System.out.println("=======================");
	}	
}
