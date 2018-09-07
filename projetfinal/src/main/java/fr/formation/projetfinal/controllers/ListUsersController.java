package fr.formation.projetfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.formation.projetfinal.dto.*;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.*;

@Controller
@RequestMapping("/list")
public class ListUsersController extends BaseController {

	private final IUserService userService;

	@Autowired
	protected ListUsersController(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/list")
	public String welcome(Model model) {
		populateModel(model);
		return "ListUsers";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		User userToUpdate = userService.findById(id);// get the corresponding User
		userToUpdate.setEnabled(false);
		userService.save(userToUpdate);

		populateModel(model);
		return "ListUsers";// return to the same jsp
	}

	private void populateModel(Model model) {
		List<UserDTO> users = userService.findAllAsDTO(getAppLanguage());
		System.out.println(users);
		model.addAttribute("users", users);
	}
}
