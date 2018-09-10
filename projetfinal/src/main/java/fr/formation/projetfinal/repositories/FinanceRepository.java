package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancePODTO;
import fr.formation.projetfinal.dto.FinancesForCustomerDTO;

@Repository
public class FinanceRepository extends BaseRepository implements IFinanceRepository {

	@SuppressWarnings("unchecked")
	public List<FinancePODTO> findAllForPOAsDTO(AppLanguage lang) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.FinancePODTO(f.id, f.code, f.firm, f.perfPlus, f.dateRecording) from Finances f");
		queryBuilder.append(" order by dateRecording");
		Query query = em.createQuery(queryBuilder.toString());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<FinancePODTO> findAllForBankerAsDTO(Long userId) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.FinancePODTO(f.id, f.code, f.firm, f.perfPlus, f.dateRecording)");
		queryBuilder.append(" from User u join u.firms c join");
		queryBuilder.append(" Finances f on f.firm.id = c.id");
		queryBuilder.append(" where u.id = :userId order by dateRecording");

		Query query = em.createQuery(queryBuilder.toString());
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.projetfinal.repositories.IFinanceRepository#
	 * findAllFinancesForCustomerFirmAsDTO(fr.formation.projetfinal.AppLanguage,
	 * java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FinancesForCustomerDTO> findAllFinancesForCustomerFirmAsDTO(AppLanguage lang, Long firm_id) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.FinancesForCustomerDTO(f.id, f.code, f.amount, f.perfPlus, f.firm.id, f.dateRecording) from Finances f where f.firm.id = :firm_id order by f.dateRecording");
		Query query = em.createQuery(queryBuilder.toString());
		query.setParameter("firm_id", firm_id);// completes the query with de dynamic param.
		return query.getResultList();
	}

}
