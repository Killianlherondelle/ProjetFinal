package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserDTO;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDTO> findAllAsDTO(AppLanguage lang) {
		StringBuilder queryBuilder = new StringBuilder(
				"select new fr.formation.projetfinal.dto.UserDTO(u.id, u.lastName, u.email, u.role, u.enabled) from User u");
		// String nameCol = "frenchName as courseName, t.";
		// String typeNameCol = "frenchName";
		// if (lang.isEnglish()) {
		// nameCol = "englishName as courseName, t.";
		// typeNameCol = "englishName";
		// }
		Query query = em.createQuery(queryBuilder.toString());
		return query.getResultList();
	}
}
