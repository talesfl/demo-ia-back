package br.com.demo.ia.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaEmailListener {

	@KafkaListener(
		topics = "${demo_ia_back.kafka.topic.routing_key_admin}", 
		groupId = "${spring.kafka.consumer.group-id}"
	)
	public void emailAdminListener(String message) {
		
	}
	
	@KafkaListener(
		topics = "${demo_ia_back.kafka.topic.routing_key}",
		groupId = "${spring.kafka.consumer.group-id}"
	)
	public void emailUserListener(String message) {
		
	}
}
