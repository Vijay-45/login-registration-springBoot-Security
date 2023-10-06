package dev.Vijay.loginregistrationspringBootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev.Vijay.loginregistrationspringBootsecurity.dto.UserDto;
import dev.Vijay.loginregistrationspringBootsecurity.model.User;
import dev.Vijay.loginregistrationspringBootsecurity.service.UserService;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	private UserService service;
	
	
	public HomeController(UserService service) {
		super();
		this.service = service;
	}
	@GetMapping("/")
	public String getHome() {
		return "index";
	}	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String showregister(Model model) {
		UserDto user=new UserDto();
		model.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto,BindingResult result,Model model) {
		User user=service.findByEmail(userDto.getEmail());
		if(user!=null && user.getEmail()!=null && !user.getEmail().isEmpty()) {
			result.rejectValue("email",null, "There is already an account registered with the same email");
		}
		if(result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}
		
		service.saveUser(userDto);
		return "redirect:/register?success";
	}
	
}
