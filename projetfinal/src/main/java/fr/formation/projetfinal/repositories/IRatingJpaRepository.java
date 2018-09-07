package fr.formation.projetfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projetfinal.entities.Rating;

public interface IRatingJpaRepository extends JpaRepository<Rating, Long> {

}
