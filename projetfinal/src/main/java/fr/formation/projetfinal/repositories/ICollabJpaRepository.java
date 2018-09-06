package fr.formation.projetfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projetfinal.entities.Collaborator;

public interface ICollabJpaRepository extends JpaRepository<Collaborator, Long> {
	

}
