package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.currencyDTO;

public interface ICurrencyRepository {

	public List<currencyDTO> findAllAsDTO(AppLanguage lang);

}
