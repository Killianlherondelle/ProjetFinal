package fr.formation.projetfinal.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.PerfDTO;
import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Perf;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.repositories.IPerfJpaRepository;
import fr.formation.projetfinal.repositories.IPerfRepository;


@Service
public class PerfService implements IPerfService {

   
    private final IPerfJpaRepository perfJpaRepository;
    private final IPerfRepository perfRepository;
    @Autowired
    protected PerfService(IPerfJpaRepository perfJpaRepository, IPerfRepository perfRepository) {
	this.perfRepository = perfRepository;
	this.perfJpaRepository = perfJpaRepository;
    }

  

    @Override
    public void save(Perf perf) {
	perfJpaRepository.save(perf);
    }

    @Override
    public List<PerfDTO> findAllAsDTO(AppLanguage lang) {
	return perfRepository.findAllAsDTO(lang);
    }



    @Override
	public Perf findById(Long id) {
		Optional<Perf> optional = perfJpaRepository.findById(id);
		return optional.get();
	}
    
    
    

    }
