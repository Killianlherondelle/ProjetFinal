package fr.formation.projetfinal.controllers;

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

import fr.formation.projetfinal.entities.Perf;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.IPerfService;
import fr.formation.projetfinal.services.IUserService;

@Controller
@RequestMapping("/perf")
public class PerfController extends BaseController {

	private final IPerfService perfService;

	@Autowired
	protected PerfController(IPerfService perfService) {
		this.perfService = perfService;
	}

	

	@GetMapping("/toUpdate")
	public String toUpdate(Model model) {
		Perf perf = perfService.findById(1L);
		model.addAttribute("perf", perf);
		
		return "perfParam";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("perf") Perf perf, BindingResult result, Model model) {
		perf.setId(1L);
		if (validateAndSave(perf, result)) {
			return "perfParam";
		}

		return "perfParam";
	}

	private boolean validateAndSave(Perf perf, BindingResult result) {
//		validate(perf, result);
		if (!result.hasErrors()) {
			
			perfService.save(perf);
			return true;
		}
		return false;
	}

	

}