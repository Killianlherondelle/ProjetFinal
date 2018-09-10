package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancePODTO;
import fr.formation.projetfinal.dto.FinancesForCustomerDTO;

public interface IFinanceRepository {

	public List<FinancePODTO> findAllForPOAsDTO(AppLanguage lang);

	public List<FinancePODTO> findAllForBankerAsDTO(Long userId);

	/**
	 * Returns the List of all finances for the customer (1 finance = 1
	 * FinancesForCustomerDTO ; the "s" of "Finances" doesn't mean many here).
	 * 
	 * @param lang
	 * @param firm_id
	 * @return List of FinancesForCustomerDTO
	 */
	public List<FinancesForCustomerDTO> findAllFinancesForCustomerFirmAsDTO(AppLanguage lang, Long firm_id);

}
