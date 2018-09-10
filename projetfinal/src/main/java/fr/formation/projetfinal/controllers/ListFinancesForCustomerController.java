package fr.formation.projetfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.projetfinal.dto.FinancesForCustomerDTO;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.IFinanceService;
@Secured({ "ROLE_CUSTOMER" })
@Controller
@RequestMapping("/listfinancesforcustomer")
public class ListFinancesForCustomerController extends BaseController {

	private final IFinanceService financeService;

	@Autowired
	protected ListFinancesForCustomerController(IFinanceService financeService) {
		this.financeService = financeService;
	}

	@GetMapping("/listdisplay")
	public String welcome(Model model) {
		populateModel(model);
		return "listFinancesForCustomer";
	}

	private void populateModel(Model model) {
		User thisUser = getUser();// Get the current user
		List<Firm> firms = thisUser.getFirms();
		Firm firm = firms.get(0);// get the only firm he has

		String firmName = firm.getName();
		model.addAttribute("firmName", firmName);

		Long firmId = firm.getId();
		List<FinancesForCustomerDTO> customerFinances = financeService
				.findAllFinancesForCustomerFirmAsDTO(getAppLanguage(), firmId);// get all finances for this firm
		model.addAttribute("customerFinances", customerFinances);
	}
}
