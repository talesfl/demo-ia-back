package br.com.demo.ia.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.demo.ia.service.UserService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserService userService;
	
	private final String realm;
	
	private final CommonBeansConfig commonBeansComponent;

	public WebSecurityConfig(
			final CommonBeansConfig commonBeansComponent,
			final UserService userService,
			
			@Value("${demo_ia_back.realm}")
			final String realm
	) {
		this.userService = userService;
		this.realm = realm;
		this.commonBeansComponent = commonBeansComponent;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorizeRequests -> {
				authorizeRequests
				.antMatchers(HttpMethod.POST, "/api/authentications/login").permitAll()
				.antMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users/password").hasRole("ADMIN")
				.antMatchers("/api/**").authenticated();
				
			}).httpBasic()
					.realmName(realm);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
			.passwordEncoder(commonBeansComponent.passwordEncoder());
	}
	
}
