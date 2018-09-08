package fr.formation.projetfinal.controllers;


import java.time.LocalDate;
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

import fr.formation.projetfinal.dto.FinancesTypeDTO;
import fr.formation.projetfinal.dto.CurrencyDTO;
import fr.formation.projetfinal.entities.Currency;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.entities.FinancesType;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.services.ICurrencyService;
import fr.formation.projetfinal.services.IFinanceService;
import fr.formation.projetfinal.services.IFinancesTypeService;

@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
@Controller
@RequestMapping("/finances")
public class RequestFinancesController extends BaseController {

	private final IFinanceService financeService;
	private final ICurrencyService currencyService;
	private final IFinancesTypeService typeService;

	@Autowired
	protected RequestFinancesController(IFinanceService financeService, ICurrencyService currencyService,
			IFinancesTypeService typeService) {
		this.financeService = financeService;
		this.currencyService = currencyService;
		this.typeService = typeService;
	}

	@GetMapping("/toCreate")
	public String toCreate(@ModelAttribute("finance") Finances finance, Model model) {
		User thisUser = getUser();
		List<Firm> firms = thisUser.getFirms();
		if (!firms.isEmpty()) {
			Firm firm = firms.get(0);
			finance.setFirm(firm);// get the firm for the session and the JSP.
		}
		populateModel(model);
		return "RequestFinances";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("finance") Finances finance, BindingResult result, Model model) {
		if (validateAndSave(finance, result)) {
			Finances newFinance = new Finances();
			model.addAttribute("finance", newFinance);
		}
		populateModel(model);
		return "RequestFinances";
	}

	private boolean validateAndSave(Finances finance, BindingResult result) {
		validate(finance, result);
		if (!result.hasErrors()) {
			finance.setDateRecording(LocalDate.now());
			financeService.save(finance);
			return true;
		}
		return false;
	}

	private void validate(Finances finance, BindingResult result) {
		Currency currency = finance.getCurrency();

		if (Long.valueOf(0L).equals(currency.getId())) {
			result.rejectValue("currency.id", "error.commons.required");

		}
		FinancesType financeType = finance.getFinanceType();
		if (Long.valueOf(0L).equals(financeType.getId())) {
			result.rejectValue("financeType.id", "error.commons.required");

		}
		if (!financeService.validateCode(finance)) {
			result.rejectValue("code", "error.entities.finances.duplicateCode");
		}
	}

	private void populateModel(Model model) {
		List<CurrencyDTO> currencies = currencyService.findAllAsDTO(getAppLanguage());
		List<FinancesTypeDTO> financeType = typeService.findAllAsDTO(getAppLanguage());
		model.addAttribute("currencies", currencies);
		model.addAttribute("financeTypes", financeType);
	}
}
