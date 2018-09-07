package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.CurrencyDTO;
import fr.formation.projetfinal.dto.PerfDTO;

@Repository
public class PerfRepository extends BaseRepository implements IPerfRepository {
	
		@SuppressWarnings("unchecked")
		public List<PerfDTO> findAllAsDTO(AppLanguage lang) {
			StringBuilder queryBuilder = new StringBuilder(
					"select new fr.formation.projetfinal.dto.PerfDTO(p.id, p.parameterA, p.paramaterB) from Perf p");
			Query query = em.createQuery(queryBuilder.toString());
			return query.getResultList();
		}
}
