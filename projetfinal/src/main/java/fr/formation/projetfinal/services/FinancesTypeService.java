package fr.formation.projetfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancesTypeDTO;
import fr.formation.projetfinal.repositories.IFinanceTypeRepository;

public class FinancesTypeService implements IFinancesTypeService {

    private final IFinanceTypeRepository typeRepository;

    @Autowired
    protected FinancesTypeService(IFinanceTypeRepository typeRepository) {
	this.typeRepository = typeRepository;
    }

    @Override
    public List<FinancesTypeDTO> findAllAsDTO(AppLanguage lang) {
	return typeRepository.findAllAsDTO(lang);
    }

}
