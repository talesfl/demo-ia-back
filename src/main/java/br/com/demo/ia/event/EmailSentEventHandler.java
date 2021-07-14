package br.com.demo.ia.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.demo.ia.domain.Email;

@Component
public class EmailSentEventHandler {
	
	@RabbitListener(queues = "${demo_ia_back.rabbitMQ.queue}")
	public void handleEmailSentEvent(final EmailSentEvent event) {
		
		Email email = event.getEmail();
		
		System.out.println("========================================");
		System.out.println("#           Email Received             #");
		System.out.println("========================================");
		System.out.println();
		System.out.println("#     From:" + email.getUserFrom().getEmail());
		System.out.println("#       To:" + email.getUserTo().getEmail());
		System.out.println("#  Subject:" + email.getSubject());
		System.out.println();
		System.out.println("========================================");
	}
}
