package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserCollabDTO;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.dto.UserDTO;
import fr.formation.projetfinal.entities.User;

public interface IUserService {

	public User save(User user);
	
	public User save(UserCustomerDTO userCustomerDTO);
	
	public User saveCollab(UserCollabDTO userCollabDTO);

	public boolean validateEmail(User user);

	public boolean validateEmail(UserCustomerDTO user);
	
	public boolean validateCollabEmail(UserCollabDTO userCollabDTO);

	public User findById(Long id);

	public List<UserDTO> findAllAsDTO(AppLanguage lang);
}
