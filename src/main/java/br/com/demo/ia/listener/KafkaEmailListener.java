package br.com.demo.ia.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.demo.ia.configuration.CommonBeansConfig;
import br.com.demo.ia.domain.Email;
import br.com.demo.ia.service.EmailService;

@Component
class KafkaEmailListener {
	
	private final EmailService emailService;
	
	private final CommonBeansConfig commonBeansConfig;
	

	public KafkaEmailListener(
			final EmailService emailService,
			final CommonBeansConfig commonBeansConfig
	) {
		this.emailService = emailService;
		this.commonBeansConfig = commonBeansConfig;
	}

	@KafkaListener(
		topics = "${demo_ia_back.kafka.topic.routing_key_admin}", 
		groupId = "${spring.kafka.consumer.group-id}"
	)
	public void emailAdminListener(String message) { 
		// TODO: buscar todos os admins e salvar o e-mail para cada um.
		// handleMessage(message); 
	}
	
	@KafkaListener(
		topics = "${demo_ia_back.kafka.topic.routing_key}",
		groupId = "${spring.kafka.consumer.group-id}"
	)
	public void emailUserListener(String message) {	handleMessage(message); }
	

	private void handleMessage(String message) {
		try {
			Email email = this.commonBeansConfig.objectMapper().readValue(message, Email.class);
			emailService.save(email);
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot deserialize message.", e);
		}
	}
}
