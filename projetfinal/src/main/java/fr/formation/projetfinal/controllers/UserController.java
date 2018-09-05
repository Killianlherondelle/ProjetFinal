package fr.formation.projetfinal.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.projetfinal.entities.Country;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.IUserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

	private final IUserService userService;

	@Autowired
	protected UserController(IUserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unused")
	@GetMapping("/toCreate")
	public String toCreate(@ModelAttribute("user") User user, Model model) {
		populateModel(model);
		return "userCreate";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		populateModel(model);
		if (validateAndSave(user, result)) {
			model.addAttribute("user", new User());
			return "redirect:/security/login";

		}
		return "userCreate";
	}

	@GetMapping("/toUpdate")
	public String toUpdate(Model model) {
		User user = userService.findById(getUser().getId());
		model.addAttribute("user", user);
		populateModel(model);
		return "userUpdate";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		user.setId(getUser().getId());
		if (validateAndSave(user, result)) {
			return "redirect:/home/welcome";
		}
		populateModel(model);
		return "userUpdate";
	}

	private boolean validateAndSave(User user, BindingResult result) {
		validate(user, result);
		if (!result.hasErrors()) {
			userService.save(user);
			return true;
		}
		return false;
	}

	private void validate(User user, BindingResult result) {
		System.out.println("validate");
		if (!userService.validateEmail(user)) {
			result.rejectValue("email", "error.entities.user.duplicateEmail");
		}
	}

	private void populateModel(Model model) {
		// Firm firm = new Firm();
		// Country country = new Country();
		// firm.setCountry(country);
		// firm.setCode("001");
		// List<Firm> firms = new ArrayList<Firm>();
		// firms.add(firm);
		// boolean active = true;

		// model.addAttribute("active", active);
		// model.addAttribute("firms", firms);
		model.addAttribute("roles", User.Role.values());
	}
}