package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancesTypeDTO;

public interface IFinancesTypeService {

	List<FinancesTypeDTO> findAllAsDTO(AppLanguage appLanguage);



}
