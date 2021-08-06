package com.loginreg.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "plebeian";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
	model.addAttribute("user", new User());
	
	return "loginpage";
	
}

	@GetMapping("/register")
		public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signuppage";
	}
	
	@PostMapping("/process_register")
		public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		return "register_success";		
	}
	
	@GetMapping("/list_users")
		public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers",listUsers);
		return "users";
	}
	
	@GetMapping("/index")
	public String viewIndexPage() {
		
		return "index";
	}
	
	@GetMapping("/ebooks")
	public String viewEbooksPage() {
		
		return "ebooks";
	}
	@GetMapping("/csgo")
	public String viewCSGoPage() {
		
		return "/CS-GO/csgo.html";
	}
	@GetMapping("/valorant")
	public String viewValorantPage() {
		
		return "/Valorant/val.html";
	}
	@GetMapping("/pubg")
	public String viewFifaPage() {
		
		return "/PUBG/pubg.html";
	}
	
	@GetMapping("/boruto")
	public String viewBorutoPage() {
		
		return "/Boruto/boruto.html";
	}

	
}

	