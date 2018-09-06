package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancesTypeDTO;


@Repository
public class FinanceTypeRepository extends BaseRepository implements IFinanceTypeRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<FinancesTypeDTO> findAllAsDTO(AppLanguage lang) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.FinancesTypeDTO(f.id, f.frenchName) from FinancesType f");
		Query query = em.createQuery(queryBuilder.toString());
		return query.getResultList();
	}

}
