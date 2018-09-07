package fr.formation.projetfinal.controllers;

import java.time.LocalDate;
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

import fr.formation.projetfinal.dto.FinancesTypeDTO;
import fr.formation.projetfinal.dto.CurrencyDTO;
import fr.formation.projetfinal.entities.Currency;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.entities.FinancesType;
import fr.formation.projetfinal.services.ICurrencyService;
import fr.formation.projetfinal.services.IFinanceService;
import fr.formation.projetfinal.services.IFinancesTypeService;


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
	public String toCreate(@ModelAttribute("finance") Finances finance,
		    Model model) {
		
		populateModel(model);
		return "RequestFinances";
	}

	
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("finance") Finances finance, BindingResult result, Model model) {
			populateModel(model);
			System.out.println("---------------------------------------------finance1");
			if (validateAndSave(finance, result)) {
				System.out.println("---------------------------------------------finance2");
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
			System.out.println("---------------------------------------------Validate and save réussi et methode save");
			return true;
		}
		return false;
	}
	
	
	
	private void validate(Finances finance, BindingResult result) {
		Currency currency = finance.getCurrency();
		
		if (Long.valueOf(0L).equals(currency.getId())) {
			System.out.println("-------------------------------test devise");
			result.rejectValue("currency.id", "error.commons.required");
			
		}
		FinancesType financeType = finance.getFinanceType();
		if (Long.valueOf(0L).equals(financeType.getId())) {
			System.out.println("-----------------------------------test type de finance");
			result.rejectValue("financeType.id", "error.commons.required");
			
		}
		if (!financeService.validateCode(finance)) {
			System.out.println("-------------------------------------------test validité du code");
		    result.rejectValue("code", "error.entities.finances.duplicateCode");
		}
		System.out.println("-------------------------------------------test validé");
	}

	
	
	
	
	
	
	
	
	private void populateModel(Model model) {
		List<CurrencyDTO> currencies = currencyService.findAllAsDTO(getAppLanguage());
		List<FinancesTypeDTO> financeType = typeService.findAllAsDTO(getAppLanguage());
		model.addAttribute("currencies", currencies);
		model.addAttribute("financeTypes", financeType);
	}
}
