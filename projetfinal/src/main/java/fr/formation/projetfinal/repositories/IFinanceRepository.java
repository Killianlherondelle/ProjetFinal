package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancePODTO;

public interface IFinanceRepository {
	
	public List<FinancePODTO> findAllForPOAsDTO(AppLanguage lang);

}
