package dev.Vijay.loginregistrationspringBootsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.Vijay.loginregistrationspringBootsecurity.model.User;
import dev.Vijay.loginregistrationspringBootsecurity.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private  UserRepository userRepository;
	
	
	
	public MyUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		System.out.println("MYUserDetailsService is called");
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Not found");
		}
		else {
			return new MyUserDetails(user);
		}
	}

}
