package fr.formation.projetfinal.repositories;

import java.util.List;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.PerfDTO;

public interface IPerfRepository {

	List<PerfDTO> findAllAsDTO(AppLanguage lang);

}
