package fr.formation.projetfinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.formation.projetfinal.entities.Rating;


@Service
public class RatingService implements IRatingService {
	
	
	private final IRatingJpaRepository ratingJpaRepository;
	
	@Autowired
	protected RatingService (IRatingJpaRepository ratingJpaRepository) {
		this.ratingJpaRepository = ratingJpaRepository;
	}
	
	
	@Override
	public Rating findById(Long id) {
		Optional<Rating> optional = ratingJpaRepository.findById(id);
		return optional.get();
	}

}
