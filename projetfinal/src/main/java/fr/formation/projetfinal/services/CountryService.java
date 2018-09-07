package fr.formation.projetfinal.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.formation.projetfinal.entities.Country;
import fr.formation.projetfinal.repositories.ICountryJpaRepository;


@Service
public class CountryService implements ICountryService {
	
	private final ICountryJpaRepository countryJpaRepository;
	
	@Autowired
	protected CountryService(ICountryJpaRepository countryJpaRepository) {
		this.countryJpaRepository = countryJpaRepository;
		
	}
	
	
    @Override
	public Country findById(Long id) {
		Optional<Country> optional = countryJpaRepository.findById(id);
		return optional.get();
	}

}
