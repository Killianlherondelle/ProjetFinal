package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;

import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Finances;

public interface IFinanceService {

	public Finances save(Finances finance);
	
    public boolean validateCode(Finances finance);

	public List<ValueDTO> findAllAsDTO(AppLanguage appLanguage);
    


}
