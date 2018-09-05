package fr.formation.projetfinal.services;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FirmItemDTO;
import fr.formation.projetfinal.entities.Firm;


public interface IFirmService {
	

	
	public Firm findById(Long id);

	List<FirmItemDTO> findAllAsDTO();
}
