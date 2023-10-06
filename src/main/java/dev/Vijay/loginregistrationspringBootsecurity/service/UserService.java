package dev.Vijay.loginregistrationspringBootsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.Vijay.loginregistrationspringBootsecurity.dto.UserDto;
import dev.Vijay.loginregistrationspringBootsecurity.model.User;
import dev.Vijay.loginregistrationspringBootsecurity.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void saveUser(UserDto dto) {
		User user=new User();
		user.setName(dto.getFirstName()+" "+dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
