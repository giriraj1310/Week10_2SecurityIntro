package ca.sheridancollege;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome()
	{
		return "th_index";
	}
	
	@GetMapping("/user")
	public String showUser(){
		return "user/th_index";
	}
	
	@GetMapping("/access-denied")
	public String showError() {
		
		return "error/th_access-denied";
	}
	
	@GetMapping("/login")
	public String showLogIn() {
		return "th_login";
	}
	
	@GetMapping("/home")
	public String showHomeJsp() {
		return "home";
	}
	
	@GetMapping("/home2")
	public String showHomeJsp2() {
		return "/user/home";
	}
	
	@GetMapping("/user/home2")
	public String showHomeJsp2user() {
		return "/user/home";
	}
	
	
}
