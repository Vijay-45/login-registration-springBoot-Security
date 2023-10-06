package dev.Vijay.loginregistrationspringBootsecurity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	
	private Long id;
	@NotEmpty(message = "First Name should not be empty")
	private String firstName;
	@NotEmpty(message = "Last Name should not be empty")
	private String lastName;
	@NotEmpty(message = "Email should not be empty")
	@Email
	private String email;
	@NotEmpty(message = "Password should not be empty")
	private String password;
	private String role;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String firstName, String lastName, String email, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
