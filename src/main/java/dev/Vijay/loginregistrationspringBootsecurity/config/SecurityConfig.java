package dev.Vijay.loginregistrationspringBootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import dev.Vijay.loginregistrationspringBootsecurity.security.MyUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	private MyUserDetailsService detailsService;
	
	
	public SecurityConfig(MyUserDetailsService detailsService) {
		super();
		this.detailsService = detailsService;
	}

	@Bean
	SecurityFilterChain chain(HttpSecurity http) throws Exception{
		return http
				.csrf(csrf ->csrf.disable())
				.authorizeHttpRequests(auth ->auth
						.requestMatchers("/register/**").permitAll()
						.anyRequest().authenticated())
				.userDetailsService(detailsService)
				.formLogin(form ->form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/")
						.permitAll())
				.logout(logout ->logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll())
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	}
	
	
	
}
