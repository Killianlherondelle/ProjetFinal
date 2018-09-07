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

import fr.formation.projetfinal.dto.FirmItemDTO;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.IFirmService;
import fr.formation.projetfinal.services.IUserService;
@Secured({ "ROLE_PO", "ROLE_ADMIN" })
@Controller
@RequestMapping("/usercust")
public class UserCustomerController extends BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IFirmService firmService;

	@SuppressWarnings("unused")
	@GetMapping("/toCreate")
	public String toCreate(@ModelAttribute("user") UserCustomerDTO userCustomerDTO, Model model) {
		populateModel(model);
		return "userCustomerCreate";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("user") UserCustomerDTO userCustomerDTO, BindingResult result,
			Model model) {
		populateModel(model);
		if (validateAndSave(userCustomerDTO, result)) {
			model.addAttribute("user", new UserCustomerDTO());
			return "redirect:/security/login";
		}
		return "userCustomerCreate";
	}

	@GetMapping("/toUpdate")
	public String toUpdate(Model model) {
		User user = userService.findById(getUser().getId());
		model.addAttribute("user", user);
		populateModel(model);
		return "userUpdate";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("user") UserCustomerDTO userCustomerDTO, BindingResult result,
			Model model) {
		userCustomerDTO.setId(getUser().getId());
		if (validateAndSave(userCustomerDTO, result)) {
			return "redirect:/home/welcome";
		}
		populateModel(model);
		return "userUpdate";
	}

	private boolean validateAndSave(UserCustomerDTO userCustomerDTO, BindingResult result) {
		validate(userCustomerDTO, result);
		if (!result.hasErrors()) {
			userService.save(userCustomerDTO);
			return true;
		}
		return false;
	}

	private void validate(UserCustomerDTO userCustomerDTO, BindingResult result) {
		if (!userService.validateEmail(userCustomerDTO)) {
			result.rejectValue("email", "error.entities.user.duplicateEmail");
		}
	}

	private void populateModel(Model model) {
		List<FirmItemDTO> firms = firmService.findAllAsDTO();
		model.addAttribute("firms", firms);
	}
}