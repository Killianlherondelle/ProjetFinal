package fr.formation.projetfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projetfinal.entities.Perf;

public interface IPerfJpaRepository extends JpaRepository<Perf, Long> {
	

}
