package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.PerfDTO;
import fr.formation.projetfinal.dto.UserCollabDTO;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.dto.UserDTO;
import fr.formation.projetfinal.entities.Perf;
import fr.formation.projetfinal.entities.User;

public interface IPerfService {

	public void save(Perf perf);
	
	
	
	

	public List<PerfDTO> findAllAsDTO(AppLanguage lang);





	public Perf findById(Long id);
}
