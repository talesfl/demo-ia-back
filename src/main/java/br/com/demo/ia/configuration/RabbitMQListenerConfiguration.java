package br.com.demo.ia.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Configuration;

import br.com.demo.ia.component.CommonBeansComponent;

@Configuration
public class RabbitMQListenerConfiguration implements RabbitListenerConfigurer {
	
	private final CommonBeansComponent commonBeansComponent;
	
	public RabbitMQListenerConfiguration(CommonBeansComponent commonBeansComponent) {
		this.commonBeansComponent = commonBeansComponent;
	}
	
	@Override
	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(commonBeansComponent.defaultMessageHandlerMethodFactory());
	}

}
