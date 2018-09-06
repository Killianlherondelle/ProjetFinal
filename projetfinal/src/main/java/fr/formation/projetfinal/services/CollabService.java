package fr.formation.projetfinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Collaborator;
import fr.formation.projetfinal.repositories.ICollabJpaRepository;
import fr.formation.projetfinal.repositories.ICollabRepository;

@Service
public class CollabService implements ICollabService {

	private final ICollabRepository collabRepository;
	private final ICollabJpaRepository collabJpaRepository;

	@Autowired
	protected CollabService(ICollabRepository collabRepository, ICollabJpaRepository collabJpaRepository) {
		this.collabRepository = collabRepository;
		this.collabJpaRepository = collabJpaRepository;
	}

	@Override
	public List<ValueDTO> findAllAsDTO() {
		return collabRepository.findAllAsDTO();
	}

	@Override
	public Collaborator findById(Long id) {
		Optional<Collaborator> optional = collabJpaRepository.findById(id);
		return optional.get();
	}
}
