package fr.formation.projetfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projetfinal.entities.Firm;

public interface IFirmJpaRepository extends JpaRepository<Firm, Long> {
	

}
