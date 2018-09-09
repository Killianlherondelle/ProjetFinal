package fr.formation.projetfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.formation.projetfinal.dto.*;
import fr.formation.projetfinal.services.*;
@Secured({ "ROLE_BANKER" })
@Controller
@RequestMapping("/listba")
public class ListFinancesForBankerController extends BaseController {

	private final IFinanceService financeService;

	@Autowired
	protected ListFinancesForBankerController(IFinanceService financeService) {
		this.financeService = financeService;
	}

	@GetMapping("/list")
	public String welcome(Model model) {
		populateModel(model);
		return "listBankerFinances";
	}


	private void populateModel(Model model) {
		List<FinancePODTO> finances = financeService.findAllForBankerAsDTO(getUser().getId());
		
		model.addAttribute("finances", finances);
	}
}
