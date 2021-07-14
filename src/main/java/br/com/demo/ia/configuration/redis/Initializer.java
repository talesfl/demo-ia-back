package br.com.demo.ia.configuration.redis;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer {

	public Initializer() {
		super(RedisHttpSessionConfig.class);
	}

}