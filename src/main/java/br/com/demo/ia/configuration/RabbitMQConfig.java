package br.com.demo.ia.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	private final CommonBeansConfig commonBeansComponent;
	
	public RabbitMQConfig(final CommonBeansConfig commonBeansComponent) {
		this.commonBeansComponent = commonBeansComponent;
	}

	@Bean
	public TopicExchange exchange(
		@Value("${demo_ia_back.rabbitmq.exchange}") final String exchangeName
	) {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public Queue queue(
		@Value("${demo_ia_back.rabbitmq.queue}") 
		final String queueName
	) {
		return new Queue(queueName, true);
	}
	
	@Bean
	public Binding binding(
		final Queue queue, 
		
		final TopicExchange exchange,
		
		@Value("${demo_ia_back.rabbitmq.topic.routing_key}")
		final String routingKey
	) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(commonBeansComponent.jackson2MessageConverter());

		return rabbitTemplate;
	}


}
