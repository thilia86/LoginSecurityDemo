package chatapp.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

	@GetMapping("/leader")
	public String showLeader() {
		
		return "leader";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		
		return "admin";
	}

}
