package br.com.demo.ia.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import br.com.demo.ia.component.CommonBeansComponent;
import br.com.demo.ia.service.UserService;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserService userService;
	
	private final String realm;
	
	private final CommonBeansComponent commonBeansComponent;

	public WebSecurityConfiguration(
			final CommonBeansComponent commonBeansComponent,
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
		http.csrf().disable()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users/password").hasRole("ADMIN")
					.anyRequest().authenticated()
				.and()
					.httpBasic()
						.realmName(realm);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
			.passwordEncoder(commonBeansComponent.passwordEncoder());
	}
	
}
