package fr.formation.projetfinal.services;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancePODTO;
import fr.formation.projetfinal.dto.FinancesForCustomerDTO;
import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.Perf;

public interface IFinanceService {

	public Finances save(Finances finance);

	public boolean validateCode(Finances finance);

	public List<ValueDTO> findAllAsDTO(AppLanguage appLanguage);

	public BigDecimal calculatePerfPlus(Finances finance, Perf perf, Firm firm);

	public List<FinancePODTO> findAllForPOAsDTO(AppLanguage appLanguage);

	/**
	 * Returns the List of all finances for the customer (1 finance = 1
	 * FinancesForCustomerDTO ; the "s" of "Finances" doesn't mean many here).
	 * 
	 * @param lang
	 * @param firm_id
	 * @return List of FinancesForCustomerDTO
	 */
	public List<FinancesForCustomerDTO> findAllFinancesForCustomerFirmAsDTO(AppLanguage lang, Long firm_id);

	public List<FinancePODTO> findAllForBankerAsDTO(Long userId);

}
