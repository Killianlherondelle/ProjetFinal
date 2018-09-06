package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.dto.*;

public interface ICollabRepository {

	public List<ValueDTO> findAllAsDTO();

}
