package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancePODTO;

@Repository
public class FinanceRepository extends BaseRepository implements IFinanceRepository {

	@SuppressWarnings("unchecked")
	
	public List<FinancePODTO> findAllForPOAsDTO(AppLanguage lang) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.FinancePODTO(f.id, f.code, f.firm, f.perfPlus) from Finances f");

			Query query = em.createQuery(queryBuilder.toString());
			return query.getResultList();
		    }
	}


