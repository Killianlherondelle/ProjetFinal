package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancesTypeDTO;

public interface IFinanceTypeRepository {

	public List<FinancesTypeDTO> findAllAsDTO(AppLanguage lang);

}
