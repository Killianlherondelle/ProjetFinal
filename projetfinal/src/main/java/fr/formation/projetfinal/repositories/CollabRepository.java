package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.dto.ValueDTO;

@Repository
public class CollabRepository extends BaseRepository implements ICollabRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<ValueDTO> findAllAsDTO() {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.ValueDTO(c.id, c.email) from Collaborator c");

		Query query = em.createQuery(queryBuilder.toString());

		return query.getResultList();
	}

}
