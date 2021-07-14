package br.com.demo.ia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
	
	private final CommonBeansConfig commonBeansComponent;
	
	public RedisConfig(CommonBeansConfig commonBeansComponent) {
		this.commonBeansComponent = commonBeansComponent;
	}
	
	@Bean
	public RedisTemplate<?, ?> redisTemplate(final RedisConnectionFactory redisConnectionFactory){
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
		stringRedisTemplate.setDefaultSerializer(commonBeansComponent.genericJackson2JsonRedisSerializer());
		
		return stringRedisTemplate;
	}
}
