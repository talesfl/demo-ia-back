package br.com.demo.ia.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSentEventDispatcher {
	
	private RabbitTemplate rabbitTemplate;
	
	private String exchange;
	
	private String topicRoutingKey;

	public EmailSentEventDispatcher(
			
			final RabbitTemplate rabbitTemplate,
			
			@Value("${demo_ia_back.exchange}")
			final String exchange, 
			
			@Value("${demo_ia_back.topic.routing_key}")
			final String topicRoutingKey
	) {
		
		this.rabbitTemplate = rabbitTemplate;
		this.exchange = exchange;
		this.topicRoutingKey = topicRoutingKey;
	}
	
	public void send(final EmailSentEvent event) {
		rabbitTemplate.convertAndSend(exchange, topicRoutingKey, event);
	}
	
}
