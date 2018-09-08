package fr.formation.projetfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.formation.projetfinal.dto.*;
import fr.formation.projetfinal.services.*;
@Secured({ "ROLE_PO", "ROLE_ADMIN" })
@Controller
@RequestMapping("/listpo")
public class ListFinancesForPOController extends BaseController {

	private final IFinanceService financeService;

	@Autowired
	protected ListFinancesForPOController(IFinanceService financeService) {
		this.financeService = financeService;
	}

	@GetMapping("/list")
	public String welcome(Model model) {
		populateModel(model);
		return "listPOFinances";
	}


	private void populateModel(Model model) {
		List<FinancePODTO> finances = financeService.findAllForPOAsDTO(getAppLanguage());
		
		model.addAttribute("finances", finances);
	}
}
