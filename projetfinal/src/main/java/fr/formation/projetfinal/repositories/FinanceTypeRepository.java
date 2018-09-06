package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancesTypeDTO;

public class FinanceTypeRepository extends BaseRepository implements IFinanceTypeRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<FinancesTypeDTO> findAllAsDTO(AppLanguage lang) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.currencyDTO(f.id, c.code, c.frenchName) from FinancesType f");
		Query query = em.createQuery(queryBuilder.toString());
		return query.getResultList();
	}

}
