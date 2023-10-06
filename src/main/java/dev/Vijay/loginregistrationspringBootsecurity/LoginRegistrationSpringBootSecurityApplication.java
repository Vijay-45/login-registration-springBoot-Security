package dev.Vijay.loginregistrationspringBootsecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.Vijay.loginregistrationspringBootsecurity.model.User;
import dev.Vijay.loginregistrationspringBootsecurity.repository.UserRepository;

@SpringBootApplication
public class LoginRegistrationSpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegistrationSpringBootSecurityApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository users) {
//		return args ->{
//			users.save(new User("Vijay","vijay@gmail.com","pass","ROLE_ADMIN"));
//		};
//	}

}
