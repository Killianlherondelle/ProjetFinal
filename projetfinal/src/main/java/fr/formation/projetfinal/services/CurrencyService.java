package fr.formation.projetfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.currencyDTO;
import fr.formation.projetfinal.repositories.ICurrencyRepository;


public class CurrencyService implements ICurrencyService {
	

    private final ICurrencyRepository currencyRepository;

    @Autowired
    protected CurrencyService(ICurrencyRepository currencyRepository) {
	this.currencyRepository = currencyRepository;
    }
	@Override
	public List<currencyDTO> findAllAsDTO(AppLanguage lang) {
		return currencyRepository.findAllAsDTO(lang);
	}

}
