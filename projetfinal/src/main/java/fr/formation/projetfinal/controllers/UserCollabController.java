package fr.formation.projetfinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.projetfinal.dto.UserCollabDTO;
import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.ICollabService;
import fr.formation.projetfinal.services.IUserService;

@Secured({ "ROLE_PO", "ROLE_ADMIN" })
@Controller
@RequestMapping("/usercollab")
public class UserCollabController extends BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private ICollabService collabService;

	@SuppressWarnings("unused")
	@GetMapping("/toCreate")
	public String toCreate(@ModelAttribute("user") UserCollabDTO userCollabDTO, Model model) {
		populateModel(model);
		return "userCollabCreate";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("user") UserCollabDTO userCollabDTO, BindingResult result,
			Model model) {
		populateModel(model);
		if (validateAndSave(userCollabDTO, result)) {
			model.addAttribute("user", new UserCollabDTO());// reset
			return "redirect:/list/list";
		}
		return "userCollabCreate";
	}

	@GetMapping("/toUpdate")
	public String toUpdate(Model model) {
		User user = userService.findById(getUser().getId());
		model.addAttribute("user", user);
		populateModel(model);
		return "userUpdate";// TODO
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("user") UserCollabDTO userCollabDTO, BindingResult result,
			Model model) {
		userCollabDTO.setCollabId(getUser().getId());
		if (validateAndSave(userCollabDTO, result)) {
			return "redirect:/home/welcome";
		}
		populateModel(model);
		return "userUpdate";// TODO
	}

	private boolean validateAndSave(UserCollabDTO userCollabDTO, BindingResult result) {
		validate(userCollabDTO, result);

		if (!result.hasErrors()) {
			userService.saveCollab(userCollabDTO);
			return true;
		}
		return false;
	}

	private void validate(UserCollabDTO userCollabDTO, BindingResult result) {
		Long collabId = userCollabDTO.getCollabId();
		if (collabId.equals(Long.valueOf(0L))) {
			result.rejectValue("collabId", "error.commons.required");
		} else if (!userService.validateCollabEmail(userCollabDTO)) {
			result.rejectValue("collabId", "error.entities.user.duplicateEmail");
		}
	}

	private void populateModel(Model model) {
		List<ValueDTO> emails = collabService.findAllAsDTO();
		model.addAttribute("emails", emails);
		model.addAttribute("roles", User.Role.rolesCollab());
	}
}