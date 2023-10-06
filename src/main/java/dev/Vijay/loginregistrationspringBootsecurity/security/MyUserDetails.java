package dev.Vijay.loginregistrationspringBootsecurity.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dev.Vijay.loginregistrationspringBootsecurity.model.User;

public class MyUserDetails implements UserDetails {

//	private String userName;
//	private String email;
//	private String password;
//	private List<GrantedAuthority> authorities;

	private User user;

	public MyUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public MyUserDetails(User user) {
//		this.userName=user.getName();
//		this.email=user.getEmail();
//		this.password=user.getPassword();
//		this.authorities=Arrays.stream(user.getRole().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//		System.out.println("MyUserDetails is Called");
//	}

	public MyUserDetails(User user) {
		super();
		this.user = user;
		System.out.println("MyUserDetails is Called.");

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.stream(user.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}
	
	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}