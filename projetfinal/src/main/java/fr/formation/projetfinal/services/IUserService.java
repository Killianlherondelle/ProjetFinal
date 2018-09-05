package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.dto.UserDTO;
import fr.formation.projetfinal.entities.User;

public interface IUserService {

	public User save(User user);
	
	public void save(UserCustomerDTO userCustomerDTO);

	public boolean validateEmail(User user);

	public boolean validateEmail(UserCustomerDTO user);

	public User findById(Long id);

	public List<UserDTO> findAllAsDTO(AppLanguage lang);
}
