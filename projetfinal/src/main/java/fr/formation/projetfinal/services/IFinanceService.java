package fr.formation.projetfinal.services;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.projetfinal.AppLanguage;

import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.Perf;


public interface IFinanceService {

	public Finances save(Finances finance);
	
    public boolean validateCode(Finances finance);

	public List<ValueDTO> findAllAsDTO(AppLanguage appLanguage);

	public BigDecimal calculatePerfPlus(Finances finance, Perf perf, Firm firm);
    


}
