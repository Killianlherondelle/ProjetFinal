package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserDTO;

public interface IUserRepository {
	
	 public List<UserDTO> findAllAsDTO(AppLanguage lang);

}
