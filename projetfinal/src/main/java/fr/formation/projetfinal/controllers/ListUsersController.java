package fr.formation.projetfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.formation.projetfinal.dto.*;
import fr.formation.projetfinal.services.*;

@Controller
@RequestMapping("/list")
public class ListUsersController extends BaseController {

	private final IUserService userService;

	@Autowired
	protected ListUsersController(IUserService userService) {
		this.userService = userService;
		System.out.println("list/list");
	}

	@GetMapping("/list")
	public String welcome(Model model) {
		populateModel(model);
		System.out.println("list/list");
		return "ListUsers";
	}

	private void populateModel(Model model) {
		List<UserDTO> users = userService.findAllAsDTO(getAppLanguage());
		System.out.println(users);
		model.addAttribute("users", users);
	}
}
