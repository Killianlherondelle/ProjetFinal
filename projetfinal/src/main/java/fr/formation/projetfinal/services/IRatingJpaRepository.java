package fr.formation.projetfinal.services;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projetfinal.entities.Rating;

public interface IRatingJpaRepository extends JpaRepository<Rating, Long> {

}
