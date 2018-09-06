package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.CurrencyDTO;

@Repository
public class CurrencyRepository extends BaseRepository implements ICurrencyRepository {
	
		@SuppressWarnings("unchecked")
		@Override
		public List<CurrencyDTO> findAllAsDTO(AppLanguage lang) {
			StringBuilder queryBuilder = new StringBuilder(
					"select new fr.formation.projetfinal.dto.CurrencyDTO(c.id, c.iso) from Currency c");
			Query query = em.createQuery(queryBuilder.toString());
			return query.getResultList();
		}
}
