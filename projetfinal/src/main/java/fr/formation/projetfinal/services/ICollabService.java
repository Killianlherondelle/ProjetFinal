package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Collaborator;

public interface ICollabService {

	public Collaborator findById(Long id);

	List<ValueDTO> findAllAsDTO();
}
