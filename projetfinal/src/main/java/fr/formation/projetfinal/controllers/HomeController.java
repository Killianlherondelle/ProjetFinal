package fr.formation.projetfinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class HomeController {

	@GetMapping("/login")
	public String welcome() {
		return "login";
	}

}
