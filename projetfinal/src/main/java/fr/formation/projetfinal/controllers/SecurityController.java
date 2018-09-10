package fr.formation.projetfinal.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/security")
public class SecurityController {

	@SuppressWarnings("unused")
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) Boolean error,
			@RequestParam(value = "logout", required = false) Boolean logout,  Model model) {
		model.addAttribute("error", error);
		return "login";
	}

}
