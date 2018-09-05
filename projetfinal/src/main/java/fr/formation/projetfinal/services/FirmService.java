package fr.formation.projetfinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.dto.FirmItemDTO;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.repositories.IFirmJpaRepository;
import fr.formation.projetfinal.repositories.IFirmRepository;

@Service
public class FirmService implements IFirmService{

	private final IFirmRepository firmRepository;
	private final IFirmJpaRepository firmJpaRepository;
	
    @Autowired
    protected FirmService(IFirmRepository firmRepository,
	    IFirmJpaRepository firmJpaRepository) {
	this.firmRepository = firmRepository;
	this.firmJpaRepository = firmJpaRepository;
    }

	
	@Override
    public List<FirmItemDTO> findAllAsDTO() {
	return firmRepository.findAllAsDTO();
    }

	@Override
    public Firm findById(Long id) {
	Optional<Firm> optional = firmJpaRepository.findById(id);
	return optional.get();
    }
}
