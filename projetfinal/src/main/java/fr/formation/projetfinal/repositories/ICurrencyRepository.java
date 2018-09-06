package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.CurrencyDTO;

public interface ICurrencyRepository {

	public List<CurrencyDTO> findAllAsDTO(AppLanguage lang);

}
