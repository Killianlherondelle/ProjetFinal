package fr.formation.projetfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.formation.projetfinal.entities.Country;


public interface ICountryJpaRepository extends JpaRepository<Country, Long> {

	
}
