package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.CurrencyDTO;

public interface ICurrencyService {

	public List<CurrencyDTO> findAllAsDTO(AppLanguage appLanguage);

}
