package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.currencyDTO;

public class CurrencyRepository extends BaseRepository implements ICurrencyRepository {
	
		@SuppressWarnings("unchecked")
		@Override
		public List<currencyDTO> findAllAsDTO(AppLanguage lang) {
			StringBuilder queryBuilder = new StringBuilder(
			"select new fr.formation.projetfinal.dto.currencyDTO(c.id, c.iso) from Currency c");
			Query query = em.createQuery(queryBuilder.toString());
			return query.getResultList();
		}
	

}
