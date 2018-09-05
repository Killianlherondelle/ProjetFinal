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
			"select new fr.formation.projetfinal.dto.UserDTO(u.id, u.lastName, u.email,u.role,u.firm, u.");
//		String nameCol = "frenchName as userName";
//		String typeNameCol = "frenchName";
//		if (lang.isEnglish()) {
//		    nameCol = "englishName as userName, t.";
//		    typeNameCol = "englishName";
//		}
//		queryBuilder.append(nameCol);
//		queryBuilder.append(typeNameCol);
//		queryBuilder.append(") from user c join c.type t");
//		queryBuilder.append(" order by t.code, courseName");
		Query query = em.createQuery(queryBuilder.toString());
		return query.getResultList();
	    }

}
