package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.currencyDTO;

public interface ICurrencyService {

	List<currencyDTO> findAllAsDTO(AppLanguage appLanguage);

}
