package fr.formation.projetfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.services.IFinanceService;


@Controller
@RequestMapping("/list")
public class ListFinancesController extends BaseController  {
	
	
	private final IFinanceService financeService;

	@Autowired
	protected ListFinancesController(IFinanceService financeService) {
		this.financeService = financeService;
	}

	@GetMapping("/Finances")
	public String welcome(Model model) {
		populateModel(model);
		return "ListFinances";
	}

	private void populateModel(Model model) {
		List<ValueDTO> finances = financeService.findAllAsDTO(getAppLanguage());
		model.addAttribute("finances", finances);
	}
}


