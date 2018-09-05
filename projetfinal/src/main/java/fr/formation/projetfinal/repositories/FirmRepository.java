package fr.formation.projetfinal.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.projetfinal.dto.FirmItemDTO;

@Repository
public class FirmRepository extends BaseRepository implements IFirmRepository{
	
	 @SuppressWarnings("unchecked")
	    @Override
	    public List<FirmItemDTO> findAllAsDTO() {
		StringBuilder queryBuilder = new StringBuilder(
			"select new fr.formation.projetfinal.dto.FirmItemDTO(f.id, f.name) from Firm f");
		
			Query query = em.createQuery(queryBuilder.toString());
		
		return query.getResultList();
	    }

}
