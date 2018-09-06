package fr.formation.projetfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.CurrencyDTO;
import fr.formation.projetfinal.repositories.ICurrencyRepository;

@Service
public class CurrencyService implements ICurrencyService {
	

    private final ICurrencyRepository currencyRepository;

    @Autowired
    protected CurrencyService(ICurrencyRepository currencyRepository) {
	this.currencyRepository = currencyRepository;
    }
    
    
	@Override
	public List<CurrencyDTO> findAllAsDTO(AppLanguage lang) {
		return currencyRepository.findAllAsDTO(lang);
	}

}
